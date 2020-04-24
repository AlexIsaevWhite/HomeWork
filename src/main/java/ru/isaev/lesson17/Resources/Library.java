package ru.isaev.lesson17.Resources;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.ListIterator;

public class Library {
    private ArrayList<Book> Books;

    public Library() {
        Books = new ArrayList<>();
    }

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

    public void readFromFile(File file) {
        Books = null;
        try (BufferedInputStream bos = new BufferedInputStream(new FileInputStream(file));
             ObjectInputStream oos = new ObjectInputStream(Base64.getDecoder().wrap(bos))) {
            Books = (ArrayList<Book>) oos.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Библиотека не найдена.");
        } catch (ClassNotFoundException e) {
            System.out.println("Неверный формат файла.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook(String name, String author, int year) {
        Book newBook = new Book(name, author, year);
        if (Books.contains(newBook))
            System.out.println("Такая книга уже существует.");
        else
            Books.add(newBook);
    }

    public void deleteBook(String name, String author, int year) {
        if (!Books.remove(new Book(name, author, year)))
            System.out.println("Такой книги нет.");
    }

    public void viewBooks() {
        int num = 1;
        for (ListIterator<Book> it = Books.listIterator(); it.hasNext(); num++) {
            System.out.printf("%s Название: %s%s  Автор: %s%s  Год издания: %s%s%s", num, it.next().getName(), System.lineSeparator(), it.next().getAuthor(), System.lineSeparator(), it.next().getYearOfPublishing(), System.lineSeparator(), System.lineSeparator());
        }
    }
}

