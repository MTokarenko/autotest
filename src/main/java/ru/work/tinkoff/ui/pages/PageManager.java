package ru.work.tinkoff.ui.pages;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static java.lang.String.format;

public class PageManager {

    private static final Properties properties = new Properties();

    public PageManager(String browser) {
        Configuration.browser = browser;
    }

    static String getProperty(String key) {
        String target = System.getProperty("target", "local");
        try (Reader fileReader = new FileReader(getResourceFile(format("%s.properties", target)))) {
            properties.load(fileReader);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static File getResourceFile(String fileName) {
        try {
            return new File(PageManager.class.getClassLoader().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void init() {
        Configuration.timeout = 10000;
        Configuration.savePageSource = true;
        Configuration.fastSetValue = true;
        Configuration.baseUrl = getProperty("web.url");

        String driverFolder = "src\\test\\resources\\drivers\\";
        switch (Configuration.browser) {
            case BrowserType.FIREFOX:
                System.setProperty("webdriver.gecko.driver", driverFolder + "geckodriver.exe");
                break;
            case BrowserType.CHROME:
                System.setProperty("webdriver.chrome.driver", driverFolder + "chromedriver.exe");
                break;
        }

        open(Configuration.baseUrl);
    }

    public void stop() {
        close();
    }

}

