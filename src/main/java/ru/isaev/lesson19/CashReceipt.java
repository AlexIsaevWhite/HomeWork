package ru.isaev.lesson19;

import ru.isaev.lesson19.resources.FileReaderWriter;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Scanner;

public class CashReceipt {
    final static String SEP = File.separator;
    final Path PRODUCTS_PATH = Paths.get("src" + SEP + "main" + SEP + "resources");
    final Path TARGET_PATH = Paths.get("target" + SEP + "classes" + SEP
            + "ru" + SEP + "isaev" + SEP + "lesson19");
    final File PRODUCTS = new File(PRODUCTS_PATH.toString(), "products.txt");
    final File OUT_CHECK = new File(TARGET_PATH.toString(), "out.txt");
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
            check.format(" x %-10.3f =%8.3f %s", count, cost, System.lineSeparator());
        }
        check.format("=============================================== %s", System.lineSeparator());
        check.format("Итого:                           %14.3f", result);
        return check.toString();
    }
}
