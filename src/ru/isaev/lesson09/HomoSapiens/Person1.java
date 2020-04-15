package ru.isaev.lesson09.HomoSapiens;

public final class Person1 extends Human {
    public Person1(String name) {
        super(name);
    }

    @Override
    public void running() {
        System.out.printf("%s побежал на улицу. \n", getName());
    }

    @Override
    public void swimming() {
        System.out.printf("%s поплыл по реке. \n", getName());
    }
}
