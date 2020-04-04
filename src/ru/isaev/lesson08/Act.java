package ru.isaev.lesson08;

import java.time.LocalDateTime;

final class Act {
    final private int NUMBER;
    final private LocalDateTime DATE;
    final private String[] PRODUCTS;

    Act(int number, String[] products, LocalDateTime dateTime) {
        this.NUMBER = number;
        this.PRODUCTS = products;
        DATE = dateTime;
    }

    int getNUMBER() {
        return NUMBER;
    }

    LocalDateTime getDATE() {
        return DATE;
    }

    String[] getPRODUCTS() {
        return PRODUCTS;
    }
}
