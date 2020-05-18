package ru.isaev.lesson24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringFilter {

    public static void main(String[] args) {
        String[] strings = {"foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"};
        Set<String> elements = new HashSet<>(Arrays.asList(strings));
        System.out.println(elements);
        Set<String> resElements = removeEvenLength(elements);
        System.out.println(resElements);
    }

    public static Set<String> removeEvenLength(Set<String> set) {
        Set<String> result = new HashSet<>(set);
        result.removeIf(s -> s.length() % 2 == 0);
        return result;
    }
}
