package ru.isaev.lesson08;

import java.time.LocalDateTime;

final class Contract {
    private int number;
    private LocalDateTime date;
    private String[] products;

    Contract(int number, String[] products) {
        this.number = number;
        this.products = products;
        date = LocalDateTime.now();
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
