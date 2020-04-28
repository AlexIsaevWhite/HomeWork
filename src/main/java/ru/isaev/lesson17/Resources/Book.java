package ru.isaev.lesson17.Resources;

import java.io.Serializable;
import java.util.Objects;

class Book implements Serializable {
    private String name;
    private String author;
    private String yearOfPublishing;

    Book(String name, String author, String yearOfPublishing) {
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

    String getYearOfPublishing() {
        return yearOfPublishing;
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

    /**
     * Сравнивает содержимое объектов
     *
     * @param obj объект сравнения
     * @return являются ли сравниваемые объекты идентичными
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return name.equals(book.name)
                    && author.equals(book.author)
                    && yearOfPublishing.equals(book.yearOfPublishing);
        } else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, yearOfPublishing);
    }
}
