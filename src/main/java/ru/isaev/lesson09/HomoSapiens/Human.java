package ru.isaev.lesson09.HomoSapiens;

import ru.isaev.lesson09.Actions.Runnable;
import ru.isaev.lesson09.Actions.Swimmable;

public abstract class Human implements Runnable, Swimmable {
    private String name;

    Human(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
