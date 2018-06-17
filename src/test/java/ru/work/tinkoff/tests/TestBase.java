package ru.work.tinkoff.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.work.tinkoff.ui.pages.PageManager;

public class TestBase {

    protected final PageManager pages = new PageManager(BrowserType.CHROME);

    @BeforeClass
    void setUp() {
        pages.init();
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        pages.stop();
    }

}
