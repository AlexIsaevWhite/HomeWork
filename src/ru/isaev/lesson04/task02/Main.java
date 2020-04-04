package ru.isaev.lesson04.task02;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);  // Инициализация средства приема данных с консоли

    public static void main(String[] args) {
        //region Инициализация данных
        int number;                                 // Число, которое необходимо определить
        //endregion

        //Приветствие
        System.out.println("Добро пожаловать в программу описания введенного числа");
        System.out.print("Пожалуйста, введите число: ");

        //region Основной алгоритм
        number = InputFromConsole();
        WhatIsIt(number);
        //endregion
    }

    // Прием чисел с консоли
    private static int InputFromConsole() {
        //region Данные метода
        String inputLine;                           // Данные введенные с консоли
        //endregion

        while (true) {
            inputLine = input.next();
            try {
                return Integer.parseInt(inputLine);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста введите число.");
            }
        }
    }

    // Определение введенного числа
    private static void WhatIsIt(int number) {
        if (number == 0) {
            System.out.println("Введенное число равно нулю");
        } else if (number > 0) {
            System.out.println("Введенное число положительное");
        } else {
            System.out.println("Введенное число отрицательное");
        }

        if (number != 0) {
            if (number % 2 == 0) {
                System.out.println("Оно чётное");
            } else {
                System.out.println("Оно нечётное");
            }
        }
    }
}
