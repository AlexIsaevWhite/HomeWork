package ru.isaev.lesson03.task04;

import java.util.Random;
import java.util.Scanner;

public class Main {
    final static int MAX_VALUE = 100;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int randomNumber;
        int lastInputNumber = 0;
        String inputLine;
        int number;

        {
            Random rand = new Random();
            randomNumber = rand.nextInt(MAX_VALUE + 1);
        }

        System.out.println("Добро пожаловать в игру \"горячо\", \"холодно\".");
        System.out.println("Приложение загадало число от 0 до " + MAX_VALUE + ". Отгадайте какое число было загадано.");
        System.out.print("Чтобы выйти из игры введите \"exit\". Введите ваш ответ:");

        while (true) {
            inputLine = scanner.next();

            try {
                if (Integer.parseInt(inputLine) >= 0) {
                    number = Integer.parseInt(inputLine);
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
