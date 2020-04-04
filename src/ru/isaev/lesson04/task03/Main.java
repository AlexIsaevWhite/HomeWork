package ru.isaev.lesson04.task03;

public class Main {
    public static void main(String[] args) {
        //region Инициализация данных
        final byte minNum = 1;                                      // Начальное число
        final byte maxNum = 10;                                     // Конечное число
        byte[] numbers = new byte[maxNum];                          // Массив всех чисел
        //endregion

        //region Основной алгоритм
        CreateNum(minNum, maxNum, numbers);
        MultiTable(numbers);
        //endregion
    }

    // Заполнение массива
    private static void CreateNum(byte minNum, byte maxNum, byte[] numbers) {
        byte n = 0;
        for (byte i = minNum; i <= maxNum; i++) {
            numbers[n] = i;
            n++;
        }
    }

    // Вывод таблицы умножения на экран
    private static void MultiTable(byte[] numbers) {
        for (byte i : numbers) {
            for (byte j : numbers) {
                byte result = (byte) (i * j);
                System.out.println(i + " * " + j + " = " + result);
            }
        }
    }
}
