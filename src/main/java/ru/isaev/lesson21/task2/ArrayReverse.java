package ru.isaev.lesson21.task2;

import java.util.Arrays;

public class ArrayReverse {

    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 15, -1, 2, -10, 9, 4};
        startWork(array);
        array = new int[]{6, 5, 1, -100, 3, -5, 9};
        startWork(array);
    }

    static void startWork(int[] array) {
        showContent(array);
        reverseArray(array);
        showContent(array);
    }

    private static void reverseArray(int[] array) {
        System.out.println("Производится перестановка элементов массива..." + System.lineSeparator());
        for (int i1 = 0, i2 = array.length - 1; i1 < i2; i1++, i2--) {
            int temp = array[i1];
            array[i1] = array[i2];
            array[i2] = temp;
        }
    }

    private static void showContent(int[] array) {
        System.out.println("Содержание массива:");
        System.out.println(Arrays.toString(array));
        System.out.println();
    }
}
