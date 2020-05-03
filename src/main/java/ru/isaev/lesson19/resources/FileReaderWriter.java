package ru.isaev.lesson19.resources;

import java.io.*;

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
}
