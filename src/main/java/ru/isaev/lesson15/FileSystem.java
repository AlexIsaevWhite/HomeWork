package ru.isaev.lesson15;

import java.io.*;
import java.nio.file.Files;

public class FileSystem {
    final private static String SEPARATOR = File.separator + File.separator;
    private static boolean dirIsExist;
    private static boolean firstFileIsExist;

    public static void main(String[] args) {
        File dir = new File("target" + SEPARATOR + "classes" + SEPARATOR + "ru" + SEPARATOR + "isaev" + SEPARATOR + "lesson15" + SEPARATOR + "test");
        File dir2 = new File(dir, "new");
        File newFile1 = new File(dir, "MyObject.obj");
        File newFile2 = new File(dir2, "MyObject2.obj");
        File renamedFile = new File(dir, "RenamedMyObject.obj");
        File duplicateFile = new File(dir, "DuplicateMyObject.obj");
        dirIsExist = Files.exists(dir.toPath());
        firstFileIsExist = Files.exists(newFile1.toPath());

        if (!dirIsExist && !firstFileIsExist) {
            createDir(dir);
            createDir(dir2);
            createFile(newFile1);
            writeFileFromObject(new MyObjectForFile(), newFile1);
        }
        if (dirIsExist && firstFileIsExist) {
            copy(newFile1, duplicateFile);
            rename(duplicateFile, renamedFile);
            copy(newFile1, duplicateFile);
            delete(newFile1);
            createFile(newFile2);
        }
        recursion(dir);
    }

    static void createFile(File newFile) {
        try {
            firstFileIsExist = newFile.createNewFile();
            System.out.println("Файл " + newFile.getName() + " создан.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void createDir(File dir) {
        dirIsExist = dir.mkdir();
        System.out.println("Директория " + dir.getAbsolutePath() + " создана");
    }

    static void copy(File file, File duplicate) {
        try {
            Files.copy(file.toPath(), duplicate.toPath());
            System.out.println("Файл " + file.getName() + " скопирован в " + duplicate.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void rename(File file, File renamedFile) {
        if (file.renameTo(renamedFile))
            System.out.println("Файл " + file.getName() + " переименован в " + renamedFile.getName());
    }

    static void delete(File file) {
        try {
            Files.delete(file.toPath());
            System.out.println("Файл " + file.getName() + " удален.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void showWhatInsideMyObject(File file) {
        MyObjectForFile fromFile = (MyObjectForFile) readFromFile(file);
        if (fromFile != null) {
            System.out.println("Содержимое файла " + file.getName() + ":");
            System.out.println("int: " + fromFile.A);
            System.out.println("String: " + fromFile.B);
            for (char c : fromFile.C)
                System.out.println("char[]: " + c);
        }
    }

    static Object readFromFile(File file) {
        Object readFromFile = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            readFromFile = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Неверное содержимое файла " + file.getName());
        }
        return readFromFile;
    }

    static void writeFileFromObject(Object object, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(object);
            System.out.println("Файл " + file.getName() + " заполнен.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void recursion(File dir) {
        if (dir.exists()) {
            File[] files = dir.listFiles();
            assert files != null;
            for (File file : files) {
                if (file.isFile())
                    showWhatInsideMyObject(file);
                else
                    recursion(file);
            }
        }
    }
}
