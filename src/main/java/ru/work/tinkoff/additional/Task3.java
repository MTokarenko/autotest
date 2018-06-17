package ru.work.tinkoff.additional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(shrink("aaabccddd"));
    }

    private static String shrink(String string) {
        List<String> currentSymbols = Arrays.asList(string.split(""));
        List<String> finalSymbols = new ArrayList<>();
        for (String symbol : currentSymbols) {
            if (finalSymbols.isEmpty()) {
                finalSymbols.add(symbol);
            } else if (finalSymbols.get(finalSymbols.size() - 1).equals(symbol)) {
                finalSymbols.remove(finalSymbols.size() - 1);
            } else {
                finalSymbols.add(symbol);
            }
        }
        return finalSymbols.toString();
    }
}
