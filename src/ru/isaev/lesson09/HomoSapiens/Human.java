package ru.isaev.lesson09.HomoSapiens;

import ru.isaev.lesson09.Actions.Run;
import ru.isaev.lesson09.Actions.Swim;

public abstract class Human implements Run, Swim {
    private final String NAME;

    Human(String name) {
        NAME = name;
    }

    String getName() {
        return NAME;
    }
}
