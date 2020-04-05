package ru.isaev.lesson09;

final class Person2 extends Human {
    Person2(String name) {
        super(name);
    }

    @Override
    public void running() {
        System.out.printf("%s побежал на работу. \n", getName());
    }

    @Override
    public void swimming() {
        System.out.printf("%s поплыл на работу. \n", getName());
    }
}
