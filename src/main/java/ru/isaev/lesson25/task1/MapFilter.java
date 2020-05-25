package ru.isaev.lesson25.task1;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MapFilter {
    public static void main(String[] args) {
        String[] key = {"Вася", "Петр", "Виктор", "Сергей", "Вадим"};
        String[] value1 = {"Иванов", "Петров", "Сидоров", "Савельев", "Викторов"};
        String[] value2 = {"Иванов", "Петров", "Иванов", "Савельев", "Петров"};
        Map<String, String> map1 = new TreeMap<String, String>() {
            {
                putArrays(key, value1, this);
            }
        };
        Map<String, String> map2 = new TreeMap<String, String>() {
            {
                putArrays(key, value2, this);
            }
        };
        System.out.println("В map1 нет одинаковых value: " + isUnique(map1));
        System.out.println("В map2 нет одинаковых value: " + isUnique(map2));
    }

    public static boolean isUnique(Map<String, String> map) {
        if (map.isEmpty()) return true;
        Collection<String> values = map.values();
        int identicalElem;
        for (String s : values) {
            identicalElem = Collections.frequency(values, s);
            if (identicalElem > 1)
                return false;
        }
        return true;
    }

    static void putArrays(String[] key, String[] value, Map<String, String> map) {
        for (int i = 0; i < key.length; i++) {
            map.put(key[i], value[i]);
        }
    }
}
