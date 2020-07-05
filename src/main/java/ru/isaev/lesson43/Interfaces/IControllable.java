package ru.isaev.lesson43.Interfaces;

public interface IControllable {

    void viewAllBooks();

    void regNewReader(String firstName, String lastName);

    void viewReaderBooks(String firstName, String lastName);

    void giveBook(String bookName, String firstName, String lastName);

    void getBook(String bookName, String firstName, String lastName);

    void viewBookInfo(String bookName);

    void viewReaderInfo(String firstName, String lastName);

    void viewAuthorInfo(String authorName);

    void searchBook(String bookName, String author);
}