package ru.work.tinkoff.additional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task6 {
    public static void main(String[] args) {
        System.out.println(calculateSymbols(""));
    }

    private static String calculateSymbols(String string) {
        if (string.isEmpty()) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        List<String> symbols = Arrays.asList(string.split(""));
        for (String symbol : symbols) {
            if (map.containsKey(symbol)) {
                map.replace(symbol, map.get(symbol) + 1);
            } else {
                map.put(symbol, 1);
            }
        }
        String result = "";
        for (String key : map.keySet()) {
            result = result.concat("" + map.get(key) + key);
        }
        return result;
    }
}
