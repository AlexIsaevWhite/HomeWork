package ru.isaev.lesson08;

import java.time.LocalDateTime;

public class Expreriments {
    public static void main(String[] args) {
        Expreriments a = new Expreriments();
        a.startTest();
    }

    final void startTest() {
        System.out.println("Сложение");
        System.out.println(Calculator.addUp(1, 2));
        System.out.println(Calculator.addUp(1.5, 2.3));
        System.out.println("Вычитание");
        System.out.println(Calculator.subtract(5, 1));
        System.out.println(Calculator.subtract(5.6, 1.2));
        System.out.println("Умножение");
        System.out.println(Calculator.multiply(5, 2));
        System.out.println(Calculator.multiply(5.1, 1.4));
        System.out.println("Деление");
        System.out.println(Calculator.division(5, 2));
        System.out.println(Calculator.division(5.0, 2.0));
        System.out.println("Процент от остатка");
        System.out.println(Calculator.percentageOfNumber(5, 2));
        System.out.println(Calculator.percentageOfNumber(5.0, 2.0));
        System.out.println("Создание объектов");
        Objects object1 = new Objects();
        Objects.howMuchObjects();
        Objects object2 = new Objects();
        Objects.howMuchObjects();
        System.out.println("Создание договора и его конвертация в акт");
        Contract contract = new Contract(1, new String[]{"Чай", "Гречка", "Туалетная бумага"});
        Act act = Convector.convert(contract);
        System.out.println("Номер: " + act.NUMBER);
        System.out.println("Дата: " + act.DATE);
        System.out.println("Продукты:");
        for (String i : act.PRODUCTS) {
            System.out.println(i);
        }
    }
}

final class Calculator {
    static int addUp(int number1, int number2) {
        return number1 + number2;
    }

    static double addUp(double number1, double number2) {
        return number1 + number2;
    }

    static int subtract(int number1, int number2) {
        return number1 - number2;
    }

    static double subtract(double number1, double number2) {
        return number1 - number2;
    }

    static int multiply(int number1, int number2) {
        return number1 * number2;
    }

    static double multiply(double number1, double number2) {
        return number1 * number2;
    }

    static int division(int number1, int number2) {
        return number1 / number2;
    }

    static double division(double number1, double number2) {
        return number1 / number2;
    }

    static int percentageOfNumber(int number1, int number2) {
        return number1 % number2;
    }

    static double percentageOfNumber(double number1, double number2) {
        return number1 % number2;
    }
}

final class Objects {
    static int numbersOfObjects = 0;

    Objects() {
        numbersOfObjects++;
    }

    static void howMuchObjects() {
        System.out.println("Всего реализовано " + numbersOfObjects + " объектов.");
    }
}

final class Convector {
    static Act convert(Contract in) {
        return new Act(in.number, in.products, in.date);
    }
}

final class Contract {
    int number;
    LocalDateTime date;
    String[] products;

    Contract(int number, String[] products) {
        this.number = number;
        this.products = products;
        date = LocalDateTime.now();
    }
}

final class Act {
    final int NUMBER;
    final LocalDateTime DATE;
    final String[] PRODUCTS;

    Act(int number, String[] products, LocalDateTime dateTime) {
        this.NUMBER = number;
        this.PRODUCTS = products;
        DATE = dateTime;
    }
}