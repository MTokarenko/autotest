package ru.work.tinkoff.tests;

import org.testng.annotations.Test;
import ru.work.tinkoff.ui.pages.MainPage;
import ru.work.tinkoff.ui.pages.SecondMenu;
import ru.work.tinkoff.ui.pages.payments.PaymentsCategoriesPage;
import ru.work.tinkoff.ui.pages.payments.PaymentsPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertEquals;

public class PaymentsTest extends TestBase {

    @Test
    public void test() {
        page(MainPage.class)
                .openSecondMenu(PaymentsPage.class, SecondMenu.PAYMENTS)
                .openPayment("ЖКХ")
                .setRegion("г. Москва");

        assertEquals(page(PaymentsCategoriesPage.class).getCurrentRegion(), "Москве");
        $$x("$$x(\".//li[@data-qa-file=\\\"UIMenuItemProvider\\\"]\")");
    }
}
