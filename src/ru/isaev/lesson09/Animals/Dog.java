package ru.isaev.lesson09.Animals;

import ru.isaev.lesson09.Actions.Running;
import ru.isaev.lesson09.Actions.Swimming;

public final class Dog extends Animal implements Running, Swimming {
    private String name = "Собака";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.printf("%s побежала. \n", name);
    }

    @Override
    public void swim() {
        System.out.printf("%s поплыла. \n", name);
    }
}

