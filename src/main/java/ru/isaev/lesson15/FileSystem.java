package ru.isaev.lesson15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileSystem {
    final private static String SEPARATOR = File.separator + File.separator;

    public static void main(String[] args) {
        new FileSystem().startWork();
    }

    void startWork() {
        File dir = new File("target" + SEPARATOR + "classes" + SEPARATOR + "ru" + SEPARATOR + "isaev"
                + SEPARATOR + "lesson15" + SEPARATOR + "test");
        File dir2 = new File(dir, "new");
        File newFile1 = new File(dir, "MyObject.obj");
        File newFile2 = new File(dir2, "MyObject2.obj");
        File renamedFile = new File(dir, "RenamedMyObject.obj");
        File duplicateFile = new File(dir, "DuplicateMyObject.obj");

        if (createDir(dir2) && createFile(newFile1)) {
            copy(newFile1, duplicateFile);
            rename(duplicateFile, renamedFile);
            copy(newFile1, duplicateFile);
            delete(newFile1);
            createFile(newFile2);
        }
        recursion(dir, "");
    }

    private boolean createFile(File newFile) {
        try {
            if (newFile.createNewFile()) {
                System.out.println("Файл " + newFile.getName() + " создан.");
                return true;
            } else
                return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean createDir(File dir) {
        if (dir.mkdirs()) {
            System.out.println("Директория " + dir.getAbsolutePath() + " создана");
            return true;
        } else
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
        if (file.renameTo(renamedFile))
            System.out.println("Файл " + file.getName() + " переименован в " + renamedFile.getName());
    }

    private void delete(File file) {
        try {
            Files.delete(file.toPath());
            System.out.println("Файл " + file.getName() + " удален.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void recursion(File dir, String depth) {
        if (dir.exists()) {
            File[] files = dir.listFiles();
            String path = depth + File.separator + dir.getName() + File.separator;
            depth = new String(new char[path.length()]);
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(path);
                        System.out.println(depth + file.getName());
                    } else
                        recursion(file, depth);
                }
            }
        }
    }
}
