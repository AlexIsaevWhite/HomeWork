package ru.isaev.lesson21.task1;

public class ActionWithArray {
    private final int[] FOR_ARRAY = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final int[][] ARRAY = {FOR_ARRAY.clone(), FOR_ARRAY.clone(), FOR_ARRAY.clone()};

    public static void main(String[] args) {
        new ActionWithArray().toLeft();
    }

    public void toLeft() {
        for (int[] a : ARRAY) {
            for (int b = 0; b < a.length; b++) {
                if (b != a.length - 1) {
                    a[b] = a[b + 1];
                } else {
                    a[b] = 0;
                }
                System.out.printf("%d, ", a[b]);
            }
            System.out.println();
        }
    }
}
