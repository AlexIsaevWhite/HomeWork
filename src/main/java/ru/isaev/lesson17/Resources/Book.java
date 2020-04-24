package ru.isaev.lesson17.Resources;

import java.io.Serializable;

class Book implements Serializable {
    private String name;
    private String author;
    private int yearOfPublishing;

    Book(String name, String author, int yearOfPublishing) {
        this.name = name;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    String getName() {
        return name;
    }

    String getAuthor() {
        return author;
    }

    int getYearOfPublishing() {
        return yearOfPublishing;
    }
}
