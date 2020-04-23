package ru.isaev.lesson09.Animals;

import ru.isaev.lesson09.Actions.Runnable;
import ru.isaev.lesson09.Actions.Swimmable;

public final class Dog extends Animal implements Runnable, Swimmable {
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

