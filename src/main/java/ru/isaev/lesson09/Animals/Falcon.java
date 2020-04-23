package ru.isaev.lesson09.Animals;

import ru.isaev.lesson09.Actions.Flyable;

public final class Falcon extends Animal implements Flyable {
    private String name = "Сокол";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void fly() {
        System.out.printf("%s полетел. \n", name);
    }
}
