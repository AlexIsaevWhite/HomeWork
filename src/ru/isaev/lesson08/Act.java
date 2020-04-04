package ru.isaev.lesson08;

import java.time.LocalDateTime;

final class Act {
    final int NUMBER;
    final LocalDateTime DATE;
    final String[] PRODUCTS;

    Act(int number, String[] products, LocalDateTime dateTime) {
        this.NUMBER = number;
        this.PRODUCTS = products;
        DATE = dateTime;
    }
}
