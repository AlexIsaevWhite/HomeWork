package ru.isaev.lesson21.task1;

import java.util.Arrays;

public class ActionWithArray {

    public static void main(String[] args) {
        int[] forArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] array = {forArray.clone(), forArray.clone(), forArray};
        showArray(array);
        toLeft(array);
        showArray(array);
    }

    static void toLeft(int[][] array) {
        for (int[] a : array) {
            for (int b = 0; b < a.length; b++) {
                if (b != a.length - 1) {
                    a[b] = a[b + 1];
                } else {
                    a[b] = 0;
                }
            }
        }
    }

    static void showArray(int[][] array) {
        for (int[] i : array) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }
}
