package ru.isaev.lesson11;

import java.util.Scanner;

public class Censor {
    static final String[] BAD_WORDS = {"бяка", "Бяка", "бякой", "Бякой", "бяку", "Бяку"};
    static final String CENSURE = "<вырезано цензурой>";
    static Scanner input = new Scanner(System.in);
    static String out;

    public static void main(String[] args) {
        System.out.println("Введите предложение:");
        out = censor(input.nextLine());
        System.out.println(out);
    }

    static String censor(String input) {
        for (String i : BAD_WORDS) {
            input = input.replaceAll(i, CENSURE);
        }
        return input;
    }
}
