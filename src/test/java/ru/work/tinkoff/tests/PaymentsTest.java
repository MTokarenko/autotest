package ru.work.tinkoff.tests;

import org.testng.annotations.Test;
import ru.work.tinkoff.ui.pages.MainPage;

import static com.codeborne.selenide.Selenide.page;

public class PaymentsTest extends TestBase {

    @Test
    public void test() {
        page(MainPage.class).openSecondMenu(MainPage.SecondMenu.CASH_LOAN);
    }
}
