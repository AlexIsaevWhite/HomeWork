package ru.isaev.lesson02.task02;

public class Main
{
    public static void main(String[] args)
    {
        //region Входные данные
        int salary = 70000; // Заработная плата без учёта НДФЛ
        float personalIncomeTax = 0.13f; // НДФЛ
        // endregion

        float result = salary * (1 - personalIncomeTax); // Расчет результата

        // Вывод результата
        System.out.println("Работнику будет переведено: " + result + " рублей с учётом НДФЛ.");
    }
}
