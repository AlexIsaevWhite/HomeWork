package ru.isaev.lesson09.HomoSapiens;

public final class Person2 extends Human {
    public Person2(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("%s побежал на работу. \n", getName());
    }

    @Override
    public void swim() {
        System.out.printf("%s поплыл на работу. \n", getName());
    }
}
