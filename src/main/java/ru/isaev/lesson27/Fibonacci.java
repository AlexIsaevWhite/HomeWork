package ru.isaev.lesson27;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        int firstNum = 0;
        int secondNum = 1;
        int[] fibonacciArray = new int[15];
        fibonacciIteration(fibonacciArray, firstNum, secondNum);
        System.out.println(Arrays.toString(fibonacciArray));
        fibonacciRecursion(fibonacciArray, firstNum, secondNum);
        System.out.println(Arrays.toString(fibonacciArray));
    }

    static void fibonacciIteration(int[] array, int firstNum, int secondNum) {
        array[0] = firstNum;
        for (int i = 1; i < array.length; i++) {
            if (i < 2)
                array[i] = secondNum;
            else
                array[i] = array[i - 1] + array[i - 2];
        }
    }

    static void fibonacciRecursion(int[] array, int firstNum, int secondNum) {
        array[0] = firstNum;
        if (array.length != 1)
            array[1] = secondNum;
        if (array.length > 2)
            forFibonacciRecursion(array, 2);
    }

    private static void forFibonacciRecursion(int[] array, int numOfRecur) {
        int result = array[numOfRecur - 1] + array[numOfRecur - 2];
        array[numOfRecur++] = result;
        if (numOfRecur == array.length) return;
        forFibonacciRecursion(array, numOfRecur);
    }
}
