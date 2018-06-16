package ru.work.tinkoff.additional;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.*;

import static java.lang.String.format;

public class Task2 {

    private static final String FILE_NAME = "task2.txt";
    private List<String> lines;

    Task2() throws IOException {
        this.lines = IOUtils.readLines(Task2.class.getClassLoader()
                .getResourceAsStream(FILE_NAME), "UTF-8");
    }

    public static void main(String[] args) throws IOException {
        new Task2().run("3", "value");
    }

    private void run(String column, String value) {
        if (value == null || value.equals("")) {
            value = " ";
        }

        if (lines.size() != 2) {
            throw new RuntimeException(format("Некорректный файл - %s.\nФайл должен состоять из двух строк", FILE_NAME));
        }

        List columns = Arrays.asList(lines.get(0).split(","));
        List values = Arrays.asList(lines.get(1).split(","));

        if (columns.size() != values.size()) {
            throw new RuntimeException("Не совпадает количество колонок и их значений в файле");
        } else if (new HashSet<>(columns).size() != columns.size()) {
            throw new RuntimeException("Колонки в файле должны быть уникальными");
        } else if (!columns.contains(column)) {
            throw new RuntimeException(format("В файле отсутствует колонка - %s", column));
        }

        values.set(columns.indexOf(column), value);
    }
}
