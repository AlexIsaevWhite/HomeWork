package ru.isaev.lesson17;

import ru.isaev.lesson17.Resources.Library;

import java.io.File;
import java.io.IOException;

public class Main {
    final private String SEPARATOR = File.separator + File.separator;
    final private File DEFAULT_DESTANATION = new File("target" + SEPARATOR + "classes" + SEPARATOR + "ru" +
            SEPARATOR + "isaev" + SEPARATOR + "lesson17" + SEPARATOR + "Library.bin");
    private Library myLabrary;

    public static void main(String[] args) {
        new Main().startWork();
    }

    void startWork() {
        initialization();
        viewLibrary();
        deleteBooks();
    }

    private void initialization() {
        myLabrary = new Library();
        if (DEFAULT_DESTANATION.exists())
            try {
                myLabrary.readFromFile(DEFAULT_DESTANATION);
            } catch (IOException e) {
                createLibrary();
            }
        else {
            createLibrary();
        }
    }

    private void createLibrary() {
        System.out.println("Создается архив.");
        addBooksInLabrary();
        myLabrary.writeToFile(DEFAULT_DESTANATION);
    }

    private void viewLibrary() {
        System.out.println("Осмотр содержимого архива:");
        myLabrary.viewBooks();
    }

    private void addBooksInLabrary() {
        myLabrary.addBook("Сильмариллион", "Дж. Толкин", "1977 г.");
        myLabrary.addBook("Искусство войны", "Сунь-цзы", "325 — 380 г.");
        myLabrary.addBook("Ведьмак", "Андж. Сапковский", "1986 г.");
        myLabrary.addBook("Артхашастра", "Кауталья или Вишнагупта", "297 — 321 г.");
        myLabrary.addBook("Школа для электрика. Курс молодого бойца", "Материалы сайта \"Школа для электрика\"", "2010 г.");
        myLabrary.addBook("Расчеты релейной защиты и автоматики распределительных сетей", "Шабад М.А.", "2012 г.");
    }

    private void deleteBooks() {
        System.out.println("Попытка удалить определенные книги из архива...");
        myLabrary.deleteBook("Сильмариллион", "Дж. Толкин", "1977 г.");
        myLabrary.deleteBook("Ведьмак", "Андж. Сапковский", "1986 г.");
        myLabrary.writeToFile(DEFAULT_DESTANATION);
    }
}
