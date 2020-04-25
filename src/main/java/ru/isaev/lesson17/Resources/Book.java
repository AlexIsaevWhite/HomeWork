package ru.isaev.lesson17.Resources;

import java.io.Serializable;

class Book implements Serializable {
    private String name;
    private String author;
    private String yearOfPublishing;

    Book() {
    }

    Book(String name, String author, String yearOfPublishing) {
        this.name = name;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    /**
     * Передает информацию о книге в текстовом варианте
     *
     * @return Название, автор и год издания
     */
    @Override
    public String toString() {
        return " Название: " + name + System.lineSeparator() + " Автор: " + author + System.lineSeparator()
                + " Год издания: " + yearOfPublishing;
    }

    String getName() {
        return name;
    }

    String getAuthor() {
        return author;
    }

    String getYearOfPublishing() {
        return yearOfPublishing;
    }
}
