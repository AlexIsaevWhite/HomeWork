package ru.isaev.lesson22;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(25, "Михаил"));
        personList.add(new Person(18, "Анастасия"));
        personList.add(new Person(19, "Шахерезада"));
        personList.add(new Person(20, "Евгений"));
        personList.add(new Person(20, "Михаил"));
        personList.add(new Person(18, "Авраам"));
        personList.sort(new PersonSuperComparator());
        for (Person p : personList) {
            System.out.println(p.toString());
        }
    }
}


