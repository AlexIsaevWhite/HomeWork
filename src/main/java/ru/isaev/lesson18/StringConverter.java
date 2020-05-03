package ru.isaev.lesson18;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringConverter {
    final private String SEP = File.separator;
    final private Path DEFAULT_DESTINATION = Paths.get("target" + SEP + "classes" + SEP + "ru" +
            SEP + "isaev" + SEP + "lesson18");
    final private File INPUT_FILE = new File(DEFAULT_DESTINATION.toString(), "DefaultText.txt");
    final private File OUTPUT_FILE = new File(DEFAULT_DESTINATION.toString(), "ConvertedText.txt");
    final private Charset inputCharset;
    final private Charset outputCharset;

    StringConverter(Charset in, Charset out) {
        inputCharset = in;
        outputCharset = out;
    }

    public static void main(String[] args) {
        StringConverter converter = new StringConverter(StandardCharsets.UTF_8, StandardCharsets.US_ASCII);
        converter.startWork(converter.INPUT_FILE, converter.OUTPUT_FILE);
    }

    void startWork(File inputFile, File outputFile) {
        StringBuilder stringBuilder = readFromFile(inputFile);
        String stringToWrite = convertString(stringBuilder);
        writeToFile(outputFile, stringToWrite);
    }

    private StringBuilder readFromFile(File file) {
        StringBuilder tempString = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                tempString.append((char) br.read());
            }
            System.out.println("Файл " + file.getName() + " прочтён.");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            // Создание тестового файла при его отсутствии
            String testString = "Это тестовая строка.";
            writeToFile(file, testString);
            return new StringBuilder(testString);
            //
        } catch (IOException e) {
            System.err.println("Неверный формат файла.");
        }
        return tempString;
    }

    private void writeToFile(File file, String writeString) {
        boolean isFileExists = file.exists();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            br.write(writeString);
            if (isFileExists) {
                System.out.println("Файл " + file.getName() + " заполнен.");
            } else {
                System.out.println("Файл " + file.getName() + " создан.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            System.err.println("Неверный формат файла.");
        }
    }

    private String convertString(StringBuilder inputString) {
        System.out.println("Конвертация из " + inputCharset.name() + " в " + outputCharset.name());
        byte[] tempByte = inputString.toString().getBytes(inputCharset);
        return new String(tempByte, outputCharset);
    }
}
