package ru.isaev.lesson13;

import java.io.IOException;

public class Mom {
    public static void main(String[] args) {
        Child son = new Child(new Food[]{Food.APPLE, Food.CARRIOT, Food.PORRIDGE});
        try {
            son.eat(Food.APPLE);
            son.eat(Food.CARRIOT);
            son.eat(Food.FISH);
            son.eat(Food.PORRIDGE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
