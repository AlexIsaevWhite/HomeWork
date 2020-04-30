package ru.isaev.lesson19.resources;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public abstract class FileReaderWriter {

    /**
     * Чтение текста из файла
     *
     * @param file файл, с которого осуществляется чтение
     * @return текст из файла
     */
    public static String readTextFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                stringBuilder.append(br.readLine());
                stringBuilder.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(stringBuilder);
    }

    /**
     * Запись текста в файл
     *
     * @param file файл, в который записывается текст
     * @param text текст для записи
     */
    public static void writeTextFile(File file, String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Создание и заполнение архива формата Zip
     *
     * @param zipFile Zip файл, который будет создан или заполнен
     * @param file    файл, который будет заархивирован
     */
    public static void writeZipFile(File zipFile, File file) {
        byte[] buffer = new byte[0];
        ArrayList<FileFromZip> filesFromZip = new ArrayList<>();
        if (file != null)
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                buffer = bis.readAllBytes();
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        if (zipFile.exists())
            filesFromZip = readZipFile(zipFile);
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipFile))) {
            ZipEntry entry;
            for (FileFromZip f : filesFromZip) {
                if (file == null || !f.NAME.equals(file.getName())) {
                    entry = new ZipEntry(f.NAME);
                    zout.putNextEntry(entry);
                    zout.write(f.BODY);
                    zout.closeEntry();
                }
            }
            if (file != null) {
                entry = new ZipEntry(file.getName());
                zout.putNextEntry(entry);
                zout.write(buffer);
                zout.closeEntry();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<FileFromZip> readZipFile(File zipFile) {
        ArrayList<FileFromZip> arrayFiles = new ArrayList<>();
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry inputEntry;
            byte[] buffer;
            while ((inputEntry = zis.getNextEntry()) != null) {
                buffer = zis.readAllBytes();
                arrayFiles.add(new FileFromZip(inputEntry.getName(), buffer));
                zis.closeEntry();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayFiles;
    }
}
