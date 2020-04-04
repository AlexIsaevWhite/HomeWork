package ru.isaev.lesson08;

import java.time.LocalDateTime;

final class Contract {
    int number;
    LocalDateTime date;
    String[] products;

    Contract(int number, String[] products) {
        this.number = number;
        this.products = products;
        date = LocalDateTime.now();
    }
}
