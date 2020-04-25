package ru.isaev.lesson17.Resources;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;

public class Library implements Serializable {
    private ArrayList<Book> Books;

    public Library() {
        Books = new ArrayList<>();
    }

    /**
     * Метод записывающий закодированные данные класса через буфер в файл
     *
     * @param file файл, в который будет осуществлена запись
     */
    public void writeToFile(File file) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
             ObjectOutputStream oos = new ObjectOutputStream(Base64.getEncoder().wrap(bos))) {
            oos.writeObject(Books);
        } catch (FileNotFoundException e) {
            System.err.println("Неверно указан путь к файлу.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод считывающий закодированные данные класса через буфер из файла
     *
     * @param file файл, из которого будет осуществлено чтение
     */
    public void readFromFile(File file) {
        try (BufferedInputStream bos = new BufferedInputStream(new FileInputStream(file));
             ObjectInputStream oos = new ObjectInputStream(Base64.getDecoder().wrap(bos))) {
            Books = (ArrayList<Book>) oos.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Библиотека не найдена.");
        } catch (ClassNotFoundException e) {
            System.err.println("Неверный формат файла.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Добавляет книгу в архив
     *
     * @param name   название книги
     * @param author автор книги
     * @param year   год издания
     */
    public void addBook(String name, String author, String year) {
        boolean bookExist = false;
        for (Book book : Books) {
            if (thisBookExist(book, name, author, year)) {
                System.out.println("Такая книга уже существует.");
                bookExist = true;
                break;
            }
        }
        if (!bookExist)
            Books.add(new Book(name, author, year));
    }

    /**
     * Удаляет определенную книгу из архива
     *
     * @param name   название книги
     * @param author автор книги
     * @param year   год издания
     */
    public void deleteBook(String name, String author, String year) {
        System.out.println("Удаление книги: " + name + ", авторства: " + author);
        if (Books != null)
            if (!Books.remove(forRemoveBook(name, author, year)))
                System.out.println("Такой книги нет в архиве.");
    }

    /**
     * Выводит информацию об архиве на консоль
     */
    public void viewBooks() {
        int num = 1;
        for (Book book : Books) {
            System.out.printf("%s.%s%s%s%s", num, System.lineSeparator(), book, System.lineSeparator(), System.lineSeparator());
            num++;
        }
    }

    private boolean thisBookExist(Book book, String name, String author, String year) {
        return book.getName().equals(name) && book.getAuthor().equals(author) && book.getYearOfPublishing().equals(year);
    }

    private Book forRemoveBook(String name, String author, String year) {
        Book thisBook = new Book();
        for (Book book : Books) {
            if (thisBookExist(book, name, author, year)) {
                thisBook = book;
                break;
            }
        }
        return thisBook;
    }
}

