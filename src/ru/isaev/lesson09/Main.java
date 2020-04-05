package ru.isaev.lesson09;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal falcon = new Falcon();

        System.out.printf("Это: %s \n", dog.getName());
        System.out.printf("Это: %s \n", cat.getName());
        System.out.printf("Это: %s \n", falcon.getName());

        ((Run) cat).running();
        ((Run) dog).running();
        ((Swim) dog).swimming();
        ((Fly) falcon).flying();

        Human jack = new Person1("Джек");
        Human vasya = new Person2("Вася");

        jack.running();
        vasya.running();
        jack.swimming();
        vasya.swimming();
    }
}

