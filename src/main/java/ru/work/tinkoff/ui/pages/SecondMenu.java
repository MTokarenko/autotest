package ru.work.tinkoff.ui.pages;

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
