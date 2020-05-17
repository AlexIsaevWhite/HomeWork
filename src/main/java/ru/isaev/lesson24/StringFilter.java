package ru.isaev.lesson24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringFilter {

    public static void main(String[] args) {
        String[] strings = {"foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"};
        Set<String> elements = new HashSet<>(Arrays.asList(strings));
        showInConsole(elements);
        Set<String> resElements = removeEvenLength(elements);
        showInConsole(resElements);
    }

    static Set<String> removeEvenLength(Set<String> set) {
        Set<String> result = new HashSet<>(set);
        for (String s : set)
            if (s.length() % 2 == 0)
                result.remove(s);
        return result;
    }

    static void showInConsole(Set<String> collection) {
        String s = Arrays.toString(collection.toArray());
        System.out.println(s);
        System.out.println();
    }
}
