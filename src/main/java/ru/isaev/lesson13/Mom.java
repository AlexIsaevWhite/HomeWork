package ru.isaev.lesson13;

import java.io.IOException;

public class Mom {
    public static void main(String[] args) {
        Child son = new Child(new Food[]{Food.APPLE, Food.CARROT, Food.PORRIDGE});
        for (Food f : Food.values()) {
            try {
                son.eat(f);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
