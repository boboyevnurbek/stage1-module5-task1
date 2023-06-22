package com.epam.mjc;

import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream().parallel()
                .allMatch(s -> !s.isBlank() && Character.isUpperCase(s.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list ->
            list.addAll(
                    list.stream()
                            .filter(n -> n % 2 == 0)
                            .collect(Collectors.toList())
            );
    }


    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(s -> s.matches("[A-Z]\\S*\\s+\\w+\\s+\\w+\\s+\\w+.*\\."))
                .collect(Collectors.toList());

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> list.stream()
                .collect(Collectors.toMap(s -> s, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
    }
}
