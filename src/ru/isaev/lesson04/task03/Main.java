package ru.isaev.lesson04.task03;

public class Main {
    public static void main(String[] args) {
        //region Инициализация данных
        final byte MIN_NUM = 1;                                     // Начальное число
        final byte MAX_NUM = 10;                                     // Конечное число
        byte[] numbers = new byte[MAX_NUM];                          // Массив всех чисел
        //endregion

        //region Основной алгоритм
        createNum(MIN_NUM, MAX_NUM, numbers);
        multiTable(numbers);
        //endregion
    }

    // Заполнение массива
    private static void createNum(byte minNum, byte maxNum, byte[] numbers) {
        byte n = 0;
        for (byte i = minNum; i <= maxNum; i++) {
            numbers[n] = i;
            n++;
        }
    }

    // Вывод таблицы умножения на экран
    private static void multiTable(byte[] numbers) {
        for (byte i : numbers) {
            for (byte j : numbers) {
                byte result = (byte) (i * j);
                System.out.println(i + " * " + j + " = " + result);
            }
        }
    }
}
