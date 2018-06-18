package ru.work.tinkoff.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import static com.google.common.base.Preconditions.checkNotNull;

public class Selectors extends com.codeborne.selenide.Selectors {
    protected Selectors() {
    }

    public static By byPath(String... path) {
        checkNotNull(path);

        if (path.length == 1) {
            return byDataQaFile(path[0]);
        }

        By[] bys = new By[path.length];

        for (int i = 0; i < path.length; i++) {
            bys[i] = byDataQaFile(path[i]);
        }

        if (bys.length == 1) {
            return bys[0];
        }

        return byChain(bys);
    }

    public static By byDataQaFile(String dataQA) {
        checkNotNull(dataQA);

        return new ByDataQaFile(dataQA);
    }

    public static By byChain(By... bys) {
        checkNotNull(bys);

        return new ByChain(bys);
    }

    public static class ByDataQaFile extends By.ByCssSelector {
        private final String dataQaFile;

        public ByDataQaFile(String dataQaFile) {
            super(String.format("[data-qa-file='%s']", dataQaFile));

            this.dataQaFile = dataQaFile;
        }
    }

    public static class ByChain extends ByChained {
        private By[] bys;

        public ByChain(By... bys) {
            super(bys);
            this.bys = bys;
        }
    }
}
