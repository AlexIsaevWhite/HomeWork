package ru.isaev.lesson13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Child {
    private ArrayList<Food> lovelyFood;

    public Child(Food[] lovelyFood) {
        this.lovelyFood = new ArrayList<>(Arrays.asList(lovelyFood));
    }

    void eat(Food food) throws IOException {
        String thanksMom = "Говорит: Спасибо, Мама.";

        if (lovelyFood.contains(food))
            System.out.printf("Съел %s за обе щеки. %s%s%s", food.getName(), System.lineSeparator(), thanksMom, System.lineSeparator());
        else
            throw new IOException("Не съел " + food.getName() + "." + System.lineSeparator() + thanksMom);
    }
}
