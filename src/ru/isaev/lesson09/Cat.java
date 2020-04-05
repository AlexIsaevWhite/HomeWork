package ru.isaev.lesson09;

final class Cat extends Animal implements Run {
    final String NAME = "Кот";

    @Override
    String getName() {
        return NAME;
    }

    @Override
    public void running() {
        System.out.printf("%s побежал. \n", NAME);
    }
}
