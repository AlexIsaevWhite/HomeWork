package ru.isaev.lesson02.task01;

public class Main
{
    public static void main(String[] args)
    {
        //region Входные данные
        float literOfGasoline = 50.0f; // Количество литров бензина
        float costOfALiter = 43.0f; // Cтоимость литра бензина в рублях
        // endregion

        float result = literOfGasoline * costOfALiter; // Расчет результата

        // Вывод результата
        System.out.println("Стоимость " + literOfGasoline + " литров бензина: " + result + " рублей.");
    }
}
