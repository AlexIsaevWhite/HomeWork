package ru.isaev.lesson02.task03;

public class Main
{
    public static void main(String[] args)
    {
        //region Входные данные
        int seconds = 3600; // Количество секунд
        final byte secondsInMinute = 60; // Количество секунд в минуте
        final byte minutesInHour = 60; // Количество минут в часе
        // endregion

        float result = (float) seconds / (secondsInMinute * minutesInHour); // Расчет результата

        // Вывод результата
        System.out.println("В " + seconds + " секундах: " + result + " час(ов).");
    }
}
