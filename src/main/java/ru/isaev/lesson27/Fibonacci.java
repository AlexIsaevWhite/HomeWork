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
        int zero = 0;
        int number = 1;
        fibonacciArray[zero] = zero;
        if (fibonacciArray.length != number)
            fibonacciArray[number] = number++;
        if (fibonacciArray.length > number)
            forFibonacciRecursion(fibonacciArray, number);
        return fibonacciArray;
    }

    private static void forFibonacciRecursion(int[] array, int numOfRecur) {
        int result = array[numOfRecur - 1] + array[numOfRecur - 2];
        array[numOfRecur++] = result;
        if (numOfRecur == array.length) return;
        forFibonacciRecursion(array, numOfRecur);
    }
}
