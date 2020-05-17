package ru.isaev.lesson22;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>() {
            {
                add(new Person(25, "Михаил"));
                add(new Person(18, "Анастасия"));
                add(new Person(19, "Шахерезада"));
                add(new Person(20, "Евгений"));
                add(new Person(20, "Михаил"));
                add(new Person(18, "Авраам"));
                sort(new PersonSuperComparator());
            }
        };
        for (Person p : personList) {
            System.out.println(p.toString());
        }
    }
}


