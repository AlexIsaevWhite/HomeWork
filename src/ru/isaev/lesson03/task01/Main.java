package ru.isaev.lesson03.task01;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //region Входные данные
        float literOfGasoline;                  // Количество литров бензина
        float costOfALiter;                     // Cтоимость литра бензина в рублях
        Scanner input = new Scanner(System.in); // Инициализация средства приема данных с консоли
        // endregion

        //region Общение с пользователем
        System.out.println("Пожалуйста, введите стоимость 1 литра бензина в рублях:");
        costOfALiter = input.nextFloat();

        System.out.println("Пожалуйста, введите необходимое количество бензина в литрах:");
        literOfGasoline = input.nextFloat();
        //endregion

        float result = literOfGasoline * costOfALiter; // Расчет результата

        // Вывод результата
        System.out.println("Стоимость " + literOfGasoline + " литров бензина: " + result + " рублей.");
    }
}
