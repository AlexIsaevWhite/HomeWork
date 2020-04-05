package ru.isaev.lesson09;

abstract class Human implements Run, Swim {
    private final String NAME;

    Human(String name) {
        NAME = name;
    }

    String getName() {
        return NAME;
    }
}
