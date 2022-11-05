package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s : x) {
                if (s.isEmpty() || !Character.isUpperCase(s.charAt(0))) return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> evenNumbers = new ArrayList<>();
            for (Integer i : x) {
                if (i % 2 == 0) {
                    evenNumbers.add(i);
                }
            }
            x.addAll(evenNumbers);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> filteredList = new ArrayList<>();
            for (String s : values) {
                if (s.matches("[A-Z]\\w+ \\w+ \\w+ \\w+.*\\.")) filteredList.add(s);
            }
            return filteredList;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> result = new HashMap<>();
            for (String s : list) {
                result.put(s, s.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> concatList = new ArrayList<>(list1);
            concatList.addAll(list2);
            return concatList;
        };
    }
}
