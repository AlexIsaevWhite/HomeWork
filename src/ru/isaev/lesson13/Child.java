package ru.isaev.lesson13;

import java.io.IOException;

class Child {
    private Food[] lovelyFood;

    public Child(Food[] lovelyFood) {
        this.lovelyFood = lovelyFood;
    }

    void eat(Food food) throws IOException {
        boolean noneLovelyFood = true;
        for (Food f : lovelyFood) {
            if (f == food) {
                noneLovelyFood = false;
                System.out.printf("Cъел %s за обе щеки. \n", f.getName());
                break;
            }
        }
        if (noneLovelyFood)
            throw new IOException("Не съел " + food.getName() + "." + "\nГоворит: Cпасибо, Мама.");
        System.out.println("Говорит: Cпасибо, Мама.");
    }
}
