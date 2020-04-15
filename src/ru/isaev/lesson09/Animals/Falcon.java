package ru.isaev.lesson09.Animals;

import ru.isaev.lesson09.Actions.Fly;

public final class Falcon extends Animal implements Fly {
    final String NAME = "Сокол";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void flying() {
        System.out.printf("%s полетел. \n", NAME);
    }
}
