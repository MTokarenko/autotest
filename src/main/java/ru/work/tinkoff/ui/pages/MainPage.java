package ru.work.tinkoff.ui.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.format;
import static ru.work.tinkoff.ui.pages.PageManager.getProperty;

public class MainPage {

    SelenideElement logo = $x(".//div[@data-qa-file='FirstMenu']//span[.='Тинькофф']");

    MainPage() {
        logo.shouldBe(Condition.visible);
    }

    MainPage openMainPage() {
        getWebDriver().get(getProperty("web.url"));
        logo.shouldBe(visible);
        return this;
    }

    public void openSecondMenu(SecondMenu menu) {
        String xpath = format(".//span[@data-qa-file='SecondMenu' and .='%s']", menu.getValue());
        $x(xpath).click();
    }

    public <T> T openSecondMenu(Class<T> clazz, SecondMenu menu) {
        openSecondMenu(menu);
        return page(clazz);
    }

}
