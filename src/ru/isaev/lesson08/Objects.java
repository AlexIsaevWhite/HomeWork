package ru.isaev.lesson08;

final class Objects {
    static private int numbersOfObjects = 0;

    Objects() {
        numbersOfObjects++;
    }

    static int getNubersOfObjects() {
        return numbersOfObjects;
    }
}
