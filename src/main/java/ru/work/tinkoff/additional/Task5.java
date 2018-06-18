package ru.work.tinkoff.additional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<String> ref = new ArrayList<>(Arrays.asList("1 2 3 4 5".split(" ")));
        List<String> bd = new ArrayList<>(Arrays.asList("1 2 6 7 8 4 5".split(" ")));
        checkExtraKeys(ref, bd);
    }

    private static void checkExtraKeys(List<String> reference, List<String> database) {
        List<String> a = new ArrayList<>(database);
        a.removeAll(reference);
        System.out.println(a);
        List<String> b = new ArrayList<>(reference);
        if(!b.containsAll(database)){
            b.removeAll(database);
            System.out.println(b);
        }

    }
}
