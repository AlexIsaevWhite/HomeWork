package ru.isaev.lesson09;

final class Dog extends Animal implements Run, Swim {
    final String NAME = "Собака";

    @Override
    String getName() {
        return NAME;
    }

    @Override
    public void running() {
        System.out.printf("%s побежала. \n", NAME);
    }

    @Override
    public void swimming() {
        System.out.printf("%s поплыла. \n", NAME);
    }
}

