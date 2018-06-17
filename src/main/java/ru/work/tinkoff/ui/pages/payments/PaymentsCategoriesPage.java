package ru.work.tinkoff.ui.pages.payments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class PaymentsCategoriesPage {

    private SelenideElement region = $x(".//div[@data-qa-file='PaymentsCatalogHeader']" +
            "//span[@data-qa-file='Link']");

    PaymentsCategoriesPage() {
        $x(".//div[@data-qa-file='StatelessInput']").shouldBe(exist);
    }

    public String getCurrentRegion() {
        return region.shouldBe(visible).getText();
    }

    public PaymentsCategoriesPage setRegion(String region) {
        if (region.equals("г. Москва") && getCurrentRegion().equals("Москве")) {
            return this;
        } else if (region.equals("г. Санкт-Петербург") && getCurrentRegion().equals("Санкт-Петербурге")) {
            return this;
        } else if (!region.equals(getCurrentRegion())) {
            this.region.shouldBe(visible).click();
            $x(format(".//span[@data-qa-file='UILink' and .='%s']", region)).shouldBe(exist).click();
            this.region.shouldBe(exist);
        }
        return this;
    }

    public ElementsCollection getSuppliers() {
        return $$x(".//li[@data-qa-file='UIMenuItemProvider']");
    }
}
