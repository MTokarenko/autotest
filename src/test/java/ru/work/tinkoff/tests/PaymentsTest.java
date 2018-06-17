package ru.work.tinkoff.tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import ru.work.tinkoff.ui.pages.MainPage;
import ru.work.tinkoff.ui.pages.SecondMenu;
import ru.work.tinkoff.ui.pages.payments.PaymentsCategoriesPage;
import ru.work.tinkoff.ui.pages.payments.PaymentsPage;
import ru.work.tinkoff.ui.pages.payments.SupplierPaymentPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PaymentsTest extends TestBase {

    @Test
    public void test() {
        page(MainPage.class)
                .openSecondMenu(PaymentsPage.class, SecondMenu.PAYMENTS)
                .openPayment("ЖКХ")
                .setRegion("г. Москва");

        assertEquals(page(PaymentsCategoriesPage.class).getCurrentRegion(), "Москве");
        assertEquals(page(PaymentsCategoriesPage.class).getSuppliers().get(0).getText(), "ЖКУ-Москва");

        String savedSupplier = "ЖКУ-Москва";
        page(PaymentsCategoriesPage.class).getSuppliers().get(0).click();

        SupplierPaymentPage supplier = page(SupplierPaymentPage.class);
        supplier.openPaymentTab();
        supplier.getPayerCode().$("input").shouldBe(visible).sendKeys(Keys.ENTER);
        $x(".//div[@data-qa-file='UIFormRowError']").shouldBe(exist);

        assertTrue(supplier.hasErrorMsg(supplier.getPayerCode(), supplier.REQUIRED_FIELD_MSG));
        assertTrue(supplier.hasErrorMsg(supplier.getPeriod(), supplier.REQUIRED_FIELD_MSG));
        assertTrue(supplier.hasErrorMsg(supplier.getPaymentAmount(), supplier.REQUIRED_FIELD_MSG));
        assertFalse(supplier.hasErrorMsg(supplier.getInsuranceAmount()));

        supplier.getPayerCode().$("input").sendKeys("123");
        supplier.getPayerCode().$("input").sendKeys(Keys.ENTER);
        assertTrue(supplier.hasErrorMsg(supplier.getPayerCode(), "Поле неправильно заполнено"));

        supplier.getPeriod().$("input").sendKeys("41.2018");
        supplier.getPeriod().$("input").sendKeys(Keys.ENTER);
        assertTrue(supplier.hasErrorMsg(supplier.getPeriod(), "Поле заполнено некорректно"));

        supplier.getPaymentAmount().$("input").sendKeys("100000");
        supplier.getPaymentAmount().$("input").sendKeys(Keys.ENTER);
        assertTrue(supplier.hasErrorMsg(supplier.getPaymentAmount(), supplier.MAX_FIFTEEN_MSG));

        supplier.getInsuranceAmount().$("input").sendKeys("100001");
        supplier.getInsuranceAmount().$("input").sendKeys(Keys.ENTER);
        assertTrue(supplier.hasErrorMsg(supplier.getInsuranceAmount(), supplier.INSURANCE_MSG));

        supplier.getPayerCode().$("input").clear();
        supplier.getPayerCode().$("input").sendKeys("012345678910");
        supplier.getPayerCode().$("input").sendKeys(Keys.ENTER);
        assertEquals(supplier.getPayerCode().getValue(), "0123456789");

        page(MainPage.class)
                .openMainPage()
                .openSecondMenu(PaymentsPage.class, SecondMenu.PAYMENTS);
        page(PaymentsCategoriesPage.class).setRegion("г. Москва");
        page(PaymentsPage.class).search(savedSupplier);

    }
}
