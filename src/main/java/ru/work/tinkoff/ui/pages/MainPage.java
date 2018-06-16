package ru.work.tinkoff.ui.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
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

    public enum SecondMenu {

        CREDIR_CARDS("Кредитные карты"),
        DEBET_CARDS("Дебетовые карты"),
        CASH_LOAN("Кредит наличными"),
        MORTGAGE("Ипотека"),
        DEPOSI("Вклады"),
        PAYMENTS("Платежи");

        String value;

        SecondMenu(String secondMenu) {
            value = secondMenu;
        }

        public String getValue() {
            return value;
        }
    }
}
