package ru.work.tinkoff;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static ru.work.tinkoff.ui.Selectors.byPath;

public class Utils {

    public static SelenideElement _$(String... dataQaFile) {
        return $(byPath(dataQaFile));
    }


}
