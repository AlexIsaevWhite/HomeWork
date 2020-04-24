package ru.isaev.lesson17;

import ru.isaev.lesson17.Resources.Library;

import java.io.File;

public class Main {
    final private String SEPARATOR = File.separator + File.separator;
    final private File DEFAULT_DESTANATION = new File("target" + SEPARATOR + "classes" + SEPARATOR + "ru" + SEPARATOR + "isaev" + SEPARATOR + "lesson17" + SEPARATOR + "Library.bin");
    private Library myLabrary;

    public static void main(String[] args) {
        new Main().startWork();
    }

    void startWork() {
        initialization();
    }

    void initialization() {
        myLabrary = new Library();
        if (DEFAULT_DESTANATION.exists())
            myLabrary.readFromFile(DEFAULT_DESTANATION);
        else {
            myLabrary.writeToFile(DEFAULT_DESTANATION);
            System.out.println("Создается архив.");
        }
    }
}
