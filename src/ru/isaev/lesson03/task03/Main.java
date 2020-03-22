package ru.isaev.lesson03.task03;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //region Входные данные
        int seconds; // Количество секунд
        final byte secondsInMinute = 60; // Количество секунд в минуте
        final byte minutesInHour = 60; // Количество минут в часе
        Scanner input = new Scanner(System.in); // Инициализация средства приема данных с консоли
        // endregion

        //region Общение с пользователем
        System.out.println("Пожалуйста, введите количество секунд для рассчёта:");
        seconds = input.nextInt();
        //endregion

        float result = (float) seconds / (secondsInMinute * minutesInHour); // Расчет результата

        // Вывод результата
        System.out.println("В " + seconds + " секундах: " + result + " час(ов).");
    }
}
