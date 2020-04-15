package ru.isaev.lesson11;

import java.util.Scanner;

public class Censor {
    static final String[] BAD_WORDS = {"бяка", "Бяка", "бякой", "Бякой", "бяку", "Бяку"};
    static final String CENSURE = "<вырезано цензурой>";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String out;
        System.out.println("Введите предложение:");
        out = censor(scanner.nextLine());
        System.out.println(out);
    }

    static String censor(String input) {
        for (String i : BAD_WORDS) {
            input = input.replaceAll(i, CENSURE);
        }
        return input;
    }
}
