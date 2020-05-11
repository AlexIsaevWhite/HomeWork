package ru.isaev.lesson15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystem {
    final private static String SEPARATOR = File.separator;

    public static void main(String[] args) {
        new FileSystem().startWork();
    }

    void startWork() {
        Path dir = Paths.get("target" + SEPARATOR + "classes" + SEPARATOR + "ru" + SEPARATOR + "isaev"
                + SEPARATOR + "lesson15" + SEPARATOR + "test");
        Path dir2 = Paths.get(dir + SEPARATOR + "new");
        File newFile1 = new File(dir.toString(), "MyObject.obj");
        File newFile2 = new File(dir2.toString(), "MyObject2.obj");
        File renamedFile = new File(dir.toString(), "RenamedMyObject.obj");
        File duplicateFile = new File(dir.toString(), "DuplicateMyObject.obj");

        if (createDir(dir2.toFile()) && createFile(newFile1)) {
            copy(newFile1, duplicateFile);
            rename(duplicateFile, renamedFile);
            copy(newFile1, duplicateFile);
            delete(newFile1);
            createFile(newFile2);
        }
        printContent(dir.toFile());
    }

    private boolean createFile(File newFile) {
        try {
            if (newFile.createNewFile()) {
                System.out.println("Файл " + newFile.getName() + " создан.");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean createDir(File dir) {
        if (dir.mkdirs()) {
            System.out.println("Директория " + dir.getAbsolutePath() + " создана");
            return true;
        }
        return false;
    }

    private void copy(File file, File duplicate) {
        try {
            Files.copy(file.toPath(), duplicate.toPath());
            System.out.println("Файл " + file.getName() + " скопирован в " + duplicate.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void rename(File file, File renamedFile) {
        if (file.renameTo(renamedFile)) {
            System.out.println("Файл " + file.getName() + " переименован в " + renamedFile.getName());
        }
    }

    private void delete(File file) {
        try {
            Files.delete(file.toPath());
            System.out.println("Файл " + file.getName() + " удален.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printContent(File dir) {
        printContent(dir, 0);
    }

    private void printContent(File dir, int depth) {
        if (dir.exists()) {
            File[] files = dir.listFiles();
            String path = SEPARATOR + dir.getName() + SEPARATOR;
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        showDepth(depth);
                        System.out.println(path);
                        showDepth(depth + path.length());
                        System.out.println(file.getName());
                    } else {
                        printContent(file, depth + path.length());
                    }
                }
            }
        }
    }

    private void showDepth(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print(' ');
        }
    }
}
