package ru.isaev.lesson27;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        int num = 11;
        int[] fibonacciArray = fibonacciIteration(num);
        System.out.println(Arrays.toString(fibonacciArray));
        fibonacciArray = fibonacciRecursion(num);
        System.out.println(Arrays.toString(fibonacciArray));
    }

    static int[] fibonacciIteration(int numbers) {
        int[] fibonacciArray = new int[numbers];
        for (int i = 0; i < fibonacciArray.length; i++) {
            if (i < 2)
                fibonacciArray[i] = i;
            else
                fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }
        return fibonacciArray;
    }

    static int[] fibonacciRecursion(int numbers) {
        int[] fibonacciArray = new int[numbers];
        if (fibonacciArray.length > 1)
            forFibonacciRecursion(fibonacciArray, 0);
        return fibonacciArray;
    }

    private static void forFibonacciRecursion(int[] array, int depth) {
        if (depth == array.length) return;
        if (depth < 2) {
            array[depth] = depth;
        } else {
            int result = array[depth - 1] + array[depth - 2];
            array[depth] = result;
        }
        forFibonacciRecursion(array, ++depth);
    }
}
