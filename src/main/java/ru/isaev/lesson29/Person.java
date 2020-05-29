package ru.isaev.lesson29;

import java.util.Objects;

public class Person {
    private int age;
    private String surname;
    private String gender;

    public Person(int age, String surname, String gender) {
        this.age = age;
        this.surname = surname;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Person) {
            Person person = (Person) o;
            return age == person.age &&
                    surname.equals(person.surname) &&
                    gender.equals(person.gender);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, surname, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                '}' + System.lineSeparator();
    }
}
