package ru.work.tinkoff.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class SupplierPaymentPage {

    String inputXpath = ".//div[@data-qa-file='UIInput' and .//input[@id='%s']]";

    private SelenideElement payerCode = $x(format(inputXpath, "payerCode"));
    private SelenideElement period = $x(format(inputXpath, "period"));
    private SelenideElement insuranceAmount = $x("span[.='Сумма добровольного страхования жилья из квитанции за ЖКУ в Москве, \u20BD ']");
}
