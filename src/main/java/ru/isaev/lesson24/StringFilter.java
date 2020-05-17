package ru.isaev.lesson24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringFilter {

    public static void main(String[] args) {
        String[] strings = {"foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"};
        Set<String> elements = new HashSet<>(Arrays.asList(strings));
        showInConsole(elements);
        removeEvenLength(elements);
        showInConsole(elements);
    }

    static void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    static void showInConsole(Set<String> collection) {
        String s = Arrays.toString(collection.toArray());
        System.out.println(s);
        System.out.println();
    }
}
