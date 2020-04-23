package ru.isaev.lesson09;

import ru.isaev.lesson09.Actions.Flyable;
import ru.isaev.lesson09.Actions.Runnable;
import ru.isaev.lesson09.Actions.Swimmable;
import ru.isaev.lesson09.Animals.Animal;
import ru.isaev.lesson09.Animals.Cat;
import ru.isaev.lesson09.Animals.Dog;
import ru.isaev.lesson09.Animals.Falcon;
import ru.isaev.lesson09.HomoSapiens.Human;
import ru.isaev.lesson09.HomoSapiens.Person1;
import ru.isaev.lesson09.HomoSapiens.Person2;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal falcon = new Falcon();

        System.out.printf("Это: %s \n", dog.getName());
        System.out.printf("Это: %s \n", cat.getName());
        System.out.printf("Это: %s \n", falcon.getName());

        ((Runnable) cat).run();
        ((Runnable) dog).run();
        ((Swimmable) dog).swim();
        ((Flyable) falcon).fly();

        Human jack = new Person1("Джек");
        Human vasya = new Person2("Вася");

        jack.run();
        vasya.run();
        jack.swim();
        vasya.swim();
    }
}

