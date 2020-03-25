package ru.isaev.lesson04.task04;

import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);     // Инициализация средства приема данных с консоли
    static double number;                              // Введенное число
    static double x0;                                  // Число которое будет прогрессировать
    static double x1;                                  // Число благодаря которому будет прогрессия
    static double cycles;                              // Количество циклов прогрессии

    public static void main(String[] args)
    {
        //region Приветствие
        System.out.println("Пожалуйста, выберите какую вы хотите использовать прогрессию.");
        System.out.println("Введите 1, чтобы использовать Арифметическую");
        System.out.println("Введите 2, чтобы использовать Геометрическую");
        System.out.println("Ваш выбор:");
        //endregion

        //region Основной алгоритм
        while (true)
        {
            number = InputFromConsole();
            if (number == 1)
            {
                ArifCalculate();
                break;
            }
            else if (number == 2)
            {
                GeomCalculate();
                break;
            }
            else
            {System.out.println("Пожалуйста, выберите из доступных варантов");}
        }
        //endregion
    }

    // Прием чисел с консоли
    private static double InputFromConsole()
    {
        //region Данные метода
        String inputLine;                           // Данные введенные с консоли
        //endregion

        while (true)
        {
            inputLine = input.next();
            try
            {
                return Double.parseDouble(inputLine);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Пожалуйста введите число.");
            }
        }
    }

    // Работа с арифметическим расчетом
    private static void ArifCalculate ()
    {
        InterData();
        for (int i = 0 ; i < cycles; i++)
        {
            System.out.println(x0);
            x0 = ArifProgression(x0, x1);
        }
    }

    // Работа с геометрическим расчетом
    private static void GeomCalculate ()
    {
        InterData();
        for (int i = 0 ; i < cycles; i++)
        {
            System.out.println(x0);
            x0 = GeomProgression(x0, x1);
        }
    }

    // Ввод данных для расчета
    private static void InterData()
    {
        System.out.println("Введите число, которое хотите просчитать:");
        x0 = InputFromConsole();
        System.out.println("Введите число, с помощью которого хотите осуществить прогрессию:");
        x1 = InputFromConsole();
        System.out.println("Введите сколько раз надо осуществить прогрессию:");
        cycles = InputFromConsole();
    }

    // Арифметическая прогрессия
    private static double ArifProgression (double x, double q)
    {
        return x + q;
    }

    // Геометрическая прогрессия
    private static double GeomProgression (double x, double q)
    {
        return x * q;
    }
}