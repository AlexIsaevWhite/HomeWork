package ru.isaev.lesson09;

import ru.isaev.lesson09.Actions.Fly;
import ru.isaev.lesson09.Actions.Run;
import ru.isaev.lesson09.Actions.Swim;
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

