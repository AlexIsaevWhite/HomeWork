package ru.isaev.lesson23;

import java.util.Objects;

class Product {
    private int quantity;
    private String name;

    Product(String name) {
        this.name = name;
        quantity = 0;
    }

    Product(String name, int quantity) {
        this.quantity = quantity;
        this.name = name;
    }

    int getQuantity() {
        return quantity;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Product) {
            Product product = (Product) o;
            return name.equals(product.name);
        } else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, name);
    }

    @Override
    public String toString() {
        return "Название: " + name + "\t количество: " + quantity + " шт.";
    }
}
