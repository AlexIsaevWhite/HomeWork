package ru.isaev.lesson09.Animals;

import ru.isaev.lesson09.Actions.Runnable;

public final class Cat extends Animal implements Runnable {
    private String name = "Кот";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.printf("%s побежал. \n", name);
    }
}
