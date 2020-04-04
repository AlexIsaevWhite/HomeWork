package ru.isaev.lesson03.task02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //region Входные данные
        float salary; // Заработная плата без учёта НДФЛ
        float personalIncomeTax; // НДФЛ
        Scanner input = new Scanner(System.in); // Инициализация средства приема данных с консоли
        // endregion

        //region Общение с пользователем
        System.out.println("Пожалуйста, введите сколько сейчас процентов НДФЛ, %:");
        personalIncomeTax = input.nextFloat() / 100;

        System.out.println("Пожалуйста, введите свою заработную плату в рублях:");
        salary = input.nextFloat();
        //endregion

        float result = salary * (1 - personalIncomeTax); // Расчет результата

        // Вывод результата
        System.out.println("Работнику будет переведено: " + result + " рублей с учётом НДФЛ.");
    }
}
