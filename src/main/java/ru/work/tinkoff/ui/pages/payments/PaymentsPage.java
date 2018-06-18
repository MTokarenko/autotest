package ru.work.tinkoff.ui.pages.payments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static ru.work.tinkoff.Utils._$;

public class PaymentsPage {

    SelenideElement search = _$("SearchInput");
    SelenideElement region = $x(".//span[@data-qa-file='PaymentsCatalogHeader']");

    PaymentsPage() {
        search.shouldBe(exist);
    }

    public PaymentsCategoriesPage openPayment(String category) {
        $x(format(".//li[@data-qa-file='UIMenuItemProvider']//a[.='%s']", category)).click();
        region.shouldBe(exist);
        sleep(1000);
        return page(PaymentsCategoriesPage.class);
    }

    public void search(String value) {
        search.sendKeys(value);
    }


}
