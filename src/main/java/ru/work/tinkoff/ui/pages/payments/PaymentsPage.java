package ru.work.tinkoff.ui.pages.payments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static java.lang.String.format;

public class PaymentsPage {

    SelenideElement search = $x(".//input[@data-qa-file='SearchInput']");
    SelenideElement region = $x(".//span[@data-qa-file='PaymentsCatalogHeader']");

    PaymentsPage() {
        search.shouldBe(exist);
    }

    public PaymentsCategoriesPage openPayment(String category) {
        $x(format(".//li[@data-qa-file='UIMenuItemProvider']//a[.='%s']", category)).click();
        region.shouldBe(exist);
        return page(PaymentsCategoriesPage.class);
    }


}
