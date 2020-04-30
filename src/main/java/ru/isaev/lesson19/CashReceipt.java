package ru.isaev.lesson19;

import ru.isaev.lesson19.resources.FileReaderWriter;

import java.io.File;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Scanner;

public class CashReceipt {
    final static String SEPARATOR = File.separator + File.separator;
    final File PROJECT_PATH = new File("src" + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR
            + "ru" + SEPARATOR + "isaev" + SEPARATOR + "lesson19");
    final File TARGET_PATH = new File("target" + SEPARATOR + "classes" + SEPARATOR
            + "ru" + SEPARATOR + "isaev" + SEPARATOR + "lesson19");
    final File PRODUCTS = new File(PROJECT_PATH, "products.txt");
    final File OUT_CHECK = new File(TARGET_PATH, "out.txt");
    final File ZIP = new File(TARGET_PATH, "Zip.zip");
    String name;
    double amount;
    double count;
    double cost;
    double result;

    public static void main(String[] args) {
        new CashReceipt().startWork();
    }

    void startWork() {
        String strFromFile = FileReaderWriter.readTextFile(PRODUCTS);
        String check = formatInCheck(strFromFile);
        System.out.println(check);
        FileReaderWriter.writeTextFile(OUT_CHECK, check);
        FileReaderWriter.writeZipFile(ZIP, OUT_CHECK);
    }

    private String formatInCheck(String text) {
        Scanner scanner = new Scanner(text);
        Formatter check = new Formatter();
        Calendar cal = Calendar.getInstance();
        check.format("%tH:%tM                             %ta %td.%tm.%tY %s",
                cal, cal, cal, cal, cal, cal, System.lineSeparator());
        check.format("Наименование        Цена   Кол-во     Стоимость %s", System.lineSeparator());
        check.format("=============================================== %s", System.lineSeparator());
        result = 0;
        while (scanner.hasNextLine()) {
            name = scanner.nextLine();
            count = Double.parseDouble(scanner.nextLine());
            amount = Double.parseDouble(scanner.nextLine());
            cost = amount * count;
            result += cost;
            check.format("%-15s %8.2f", name, amount);
            check.format(" x %-10.3f =%8.2f %s", count, cost, System.lineSeparator());
        }
        check.format("=============================================== %s", System.lineSeparator());
        check.format("Итого:                           %14.2f", result);
        return check.toString();
    }
}
