package ru.isaev.lesson08;

import java.time.LocalDateTime;

final class Act {
    final private int number;
    final private LocalDateTime date;
    final private String[] products;

    Act(int number, String[] products, LocalDateTime dateTime) {
        this.number = number;
        this.products = products;
        date = dateTime;
    }

    int getNumber() {
        return number;
    }

    LocalDateTime getDate() {
        return date;
    }

    String[] getProducts() {
        return products;
    }
}
