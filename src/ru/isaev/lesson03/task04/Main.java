package ru.isaev.lesson03.task04;

import java.util.Random;
import java.util.Scanner;

public class Main {
    final static byte MAX_VALUE = 100;
    final static Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        final byte randomNumber;                    // Загаданное программой число, которое необходимо отгадать
        byte lastInputNumber = 0;                   // Последнее введеное число игроком
        String inputLine;                           // Инициализация переменной входных значений с консоли
        byte number;

        {
            Random rand = new Random();
            randomNumber = (byte) rand.nextInt(MAX_VALUE + 1);
        }

        //region Приветствие игрока и правила игры
        System.out.println("Добро пожаловать в игру \"горячо\", \"холодно\".");
        System.out.println("Приложение загадало число от 0 до " + MAX_VALUE + ". Отгадайте какое число было загадано.");
        System.out.print("Чтобы выйти из игры введите \"exit\". Введите ваш ответ:");
        //endregion

        while (true) {
            inputLine = INPUT.next();

            try {
                if (Integer.parseInt(inputLine) >= 0) {
                    number = (byte) Integer.parseInt(inputLine);
                    if (number == lastInputNumber)
                        System.out.println("Вы уже вводили это число.");
                } else {
                    number = lastInputNumber;
                    System.out.println("Введите положительное число.");
                }
            } catch (NumberFormatException e) {
                number = 0;
                lastInputNumber = 0;
            }

            if (inputLine.equals("exit") || inputLine.equals("Exit")) {
                System.out.println("Выход из игры");
                break;
            }

            if (number > lastInputNumber && number < randomNumber) {
                System.out.println("Горячо");
                lastInputNumber = number;
            } else if (number < lastInputNumber && number < randomNumber) {
                System.out.println("Холодно");
                lastInputNumber = number;
            } else if (number > lastInputNumber && number > randomNumber) {
                System.out.println("Холодно");
                lastInputNumber = number;
            } else if (number < lastInputNumber && number > randomNumber) {
                System.out.println("Горячо");
                lastInputNumber = number;
            } else if (number == randomNumber) {
                System.out.println("Вы выиграли");
                break;
            }
        }
        System.out.print("Благодарим за игру");
    }
}
