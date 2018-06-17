package ru.work.tinkoff.ui.pages.payments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SupplierPaymentPage {

    public String REQUIRED_FIELD_MSG = "Поле обязательное";
    public String INSURANCE_MSG = "Сумма добровольного страхования не может быть больше итоговой суммы.";
    public String MIN_TEN_MSG = "Минимум — 10 \u20BD";
    public String MAX_FIFTEEN_MSG = "Максимум — 15 000 \u20BD";

    String inputXpath = ".//div[@data-qa-file='UIInput' and .//input[@id='%s']]";

    public SelenideElement getPayerCode() {
        return payerCode;
    }

    private SelenideElement payerCode = $x(".//div[@data-qa-file='UIInput' and .//input[@id='payerCode']]");
    private SelenideElement period = $x(".//div[@data-qa-file='UIInputDate' and .//input[@id='period']]");
    private SelenideElement insuranceAmount = $x(".//div[@data-qa-file='StatelessInput' and " +
            ".//span[.='Сумма добровольного страхования жилья из квитанции за ЖКУ в Москве, \u20BD ']]");
    private SelenideElement paymentAmount = $x(".//div[@data-qa-file='StatelessInput' and " +
            ".//span[contains(text(), 'Сумма платежа,')]]");

    public SupplierPaymentPage openPaymentTab() {
        $x(".//span[@data-qa-file='Tab' and .='Оплатить ЖКУ в Москве']")
                .shouldBe(visible).click();
        payerCode.shouldBe(visible);
        return this;
    }

    public boolean hasErrorMsg(SelenideElement element, String message) {
        SelenideElement err = element.$x("following-sibling::div[contains(@class, 'error')]");
        if (err.exists()) {
            return err.getText().equals(message);
        } else return false;
    }

    public boolean hasErrorMsg(SelenideElement element) {
        return element.$x("following-sibling::div[contains(@class, 'error')]").exists();
    }

    public SelenideElement getPeriod() {
        return period;
    }

    public SelenideElement getInsuranceAmount() {
        return insuranceAmount;
    }

    public SelenideElement getPaymentAmount() {
        return paymentAmount;
    }
}
