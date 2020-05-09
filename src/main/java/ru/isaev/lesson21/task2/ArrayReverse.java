package ru.isaev.lesson21.task2;

import java.util.Scanner;

public class ArrayReverse {
    int[] array;

    public static void main(String[] args) {
        new ArrayReverse().startWork();
    }

    void startWork() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        array = new int[scan.nextInt()];
        System.out.println("Введите значения массива:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        showContent(array);
        reverseArray(array);
        showContent(array);
    }

    private void reverseArray(int[] array) {
        System.out.println("Производится перестановка элементов массива...");
        for (int i1 = 0, i2 = array.length - 1; i1 < i2; i1++, i2--) {
            int temp = array[i1];
            array[i1] = array[i2];
            array[i2] = temp;
        }
    }

    private void showContent(int[] array) {
        System.out.println("Содержание массива:");
        for (int i : array) {
            System.out.printf("%d, ", i);
        }
        System.out.println();
    }
}
