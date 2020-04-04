package ru.isaev.lesson04.task01;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);  // Инициализация средства приема данных с консоли

    public static void main(String[] args) {
        //region Инициализация данных метода
        final byte NUMBERS = 2;                     // Сколько всего будет на прием чисел
        int[] arrNumbers = new int[NUMBERS];        // Инициализация переменной входных значений с консоли
        //endregion

        //Приветствие
        System.out.println("Добро пожаловать в программу нахождения минимального из " + NUMBERS + " чисел");

        //region Основной алгоритм
        for (int i = 0; i < NUMBERS; i++) {
            int num = i + 1;
            System.out.println("Введите " + num + " число: ");
            inputFromConsole(arrNumbers, i);
        }
        System.out.println("Самое наименьшее число: " + minimalNumber(arrNumbers));
        //endregion
    }


    // Прием чисел с консоли
    private static void inputFromConsole(int[] arrNumbers, int i) {
        //region Данные метода
        String inputLine;                           // Данные введенные с консоли
        boolean allDone = false;                    // Контроль окончания ввода чисел
        //endregion

        while (!allDone) {
            inputLine = input.next();
            try {
                arrNumbers[i] = Integer.parseInt(inputLine);
                allDone = true;
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста введите число.");
            }
        }
    }

    // Алгоритм нахождения минимального числа
    private static int minimalNumber(int[] numbers) {
        int num = numbers[0];
        for (int i : numbers) {
            num = Math.min(i, num);
        }
        return num;
    }
}
