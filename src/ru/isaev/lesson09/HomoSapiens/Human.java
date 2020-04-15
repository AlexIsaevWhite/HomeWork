package ru.isaev.lesson09.HomoSapiens;

import ru.isaev.lesson09.Actions.Running;
import ru.isaev.lesson09.Actions.Swimming;

public abstract class Human implements Running, Swimming {
    private String name;

    Human(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
