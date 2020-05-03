package ru.isaev.lesson17.Resources;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;

public class Library implements Serializable {
    private ArrayList<Book> books = new ArrayList<>();

    /**
     * Метод записывающий закодированные данные класса через буфер в файл
     *
     * @param file файл, в который будет осуществлена запись
     */
    public void writeToFile(File file) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
             ObjectOutputStream oos = new ObjectOutputStream(Base64.getEncoder().wrap(bos))) {
            for (Book book : books) {
                oos.writeByte(0);
                oos.writeObject(book);
            }
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
    public void readFromFile(File file) throws IOException {
        try (BufferedInputStream bos = new BufferedInputStream(new FileInputStream(file));
             ObjectInputStream oos = new ObjectInputStream(Base64.getDecoder().wrap(bos))) {
            while (oos.available() > 0) {
                oos.readByte();
                Object readObject = oos.readObject();
                if (readObject instanceof Book) {
                    books.add((Book) readObject);
                } else {
                    throw new ClassNotFoundException();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Библиотека не найдена.");
        } catch (ClassNotFoundException e) {
            System.err.println("Неверный формат файла.");
        } catch (IOException e) {
            System.err.println("Файл поврежден.");
            throw e;
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
        Book newBook = new Book(name, author, year);
        if (books.contains(newBook)) {
            System.out.println("Такая книга уже существует.");
        } else {
            books.add(newBook);
        }
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
        if (books != null) {
            if (!books.remove(new Book(name, author, year))) {
                System.out.println("Такой книги нет в архиве.");
            }
        } else {
            System.out.println("Архив уже пуст.");
        }

    }

    /**
     * Выводит информацию об архиве на консоль
     */
    public void viewBooks() {
        int num = 1;
        for (Book book : books) {
            System.out.printf("%s.%s%s%s%s", num, System.lineSeparator(), book, System.lineSeparator(), System.lineSeparator());
            num++;
        }
    }
}

