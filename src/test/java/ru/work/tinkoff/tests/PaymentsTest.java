package ru.work.tinkoff.tests;

import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;
import ru.work.tinkoff.ui.pages.MainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class PaymentsTest extends TestBase {

    @Test
    public void test() {
        page(MainPage.class).openSecondMenu(MainPage.SecondMenu.PAYMENTS);
        $x(".//span[@data-qa-file=\"UILink\" and .='ЖКХ']").shouldBe(visible).click();
        System.out.println();
        ElementsCollection suppliers = $$x(".//li[@data-qa-file=\"UIMenuItemProvider\"]");
        assertEquals(suppliers.get(0).getText(), "ЖКУ-Москва", "Первый в списке поставщиков не " +
                "\"ЖКУ-Москва\"");
        String savedSupplier = suppliers.get(0).getText();
        suppliers.get(0).click();
        $x(".//span[@data-qa-file=\"Tab\" and .='Оплатить ЖКУ в Москве']").shouldBe(visible).click();
        System.out.println();

    }
}
