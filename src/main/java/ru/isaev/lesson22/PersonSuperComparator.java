package ru.isaev.lesson22;

import java.util.Comparator;

class PersonSuperComparator implements Comparator<Person> {
    public int compare(Person a, Person b) {
        int compareNames = a.getName().compareTo(b.getName());
        if (compareNames != 0)
            return compareNames;
        else
            return b.getAge() - a.getAge();
    }
}
