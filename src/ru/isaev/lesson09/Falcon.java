package ru.isaev.lesson09;

final class Falcon extends Animal implements Fly {
    final String NAME = "Сокол";

    @Override
    String getName() {
        return NAME;
    }

    @Override
    public void flying() {
        System.out.printf("%s полетел. \n", NAME);
    }
}
