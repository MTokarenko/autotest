package ru.work.tinkoff.additional;

import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<String> ref = Arrays.asList("1 2 3 4 5".split(" "));
        List<String> db = Arrays.asList("1 2 3 4 5".split(" "));
        checkExtraKeys(ref, db);
    }

    public static void checkExtraKeys(List<String> reference, List<String> database) {
        if (reference.equals(database)) {
            System.out.println("success!");
        }

    }

    public void checkValidKeys(List<String> reference, List<String> database) {

    }
}
