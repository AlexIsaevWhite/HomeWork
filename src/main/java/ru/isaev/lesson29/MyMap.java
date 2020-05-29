package ru.isaev.lesson29;

import java.util.*;

public class MyMap {

    public static void main(String[] args) {
        Map<String, Person> myMap = createMap();
        System.out.println(myMap);
        removeTheDuplicates(myMap);
        System.out.println();
        System.out.println(myMap);
    }

    public static Map<String, Person> createMap() {
        Map<String, Person> book = new HashMap<>();
        Person person1 = new Person(29, "Петрова", "жен");
        Person person2 = new Person(34, "Сидорова", "жен");
        Person person3 = new Person(34, "Тихонова", "жен");
        Person person4 = new Person(35, "Петров", "муж");
        book.put("Key1", person1);
        book.put("Key2", person1);
        book.put("Key3", person2);
        book.put("Key4", person3);
        book.put("Key5", person4);
        book.put("Key6", person4);
        return book;
    }

    public static void removeTheDuplicates(Map<String, Person> map) {
        ArrayList<Person> forRemove = new ArrayList<>();
        Collection<Person> values = map.values();
        for (Person person : values) {
            if (Collections.frequency(values, person) > 1 && !forRemove.contains(person)) {
                forRemove.add(person);
            }
        }
        forRemove.forEach((person) -> removeItemFromMapByValue(map, person));
    }

    public static void removeItemFromMapByValue(Map<String, Person> map, Person value) {
        Map<String, Person> copy = new HashMap<>(map);
        for (Map.Entry<String, Person> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }
}
