package ru.isaev.lesson09.Animals;

import ru.isaev.lesson09.Actions.Run;

public final class Cat extends Animal implements Run {
    final String NAME = "Кот";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void running() {
        System.out.printf("%s побежал. \n", NAME);
    }
}
