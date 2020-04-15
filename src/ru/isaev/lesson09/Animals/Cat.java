package ru.isaev.lesson09.Animals;

import ru.isaev.lesson09.Actions.Running;

public final class Cat extends Animal implements Running {
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
