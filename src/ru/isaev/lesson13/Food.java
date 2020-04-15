package ru.isaev.lesson13;

enum Food {
    APPLE("яблоко"),
    CARRIOT("морковь"),
    FISH("рыбу"),
    PORRIDGE("кашу");

    private String name;

    public String getName() {
        return name;
    }

    Food(String name) {
        this.name = name;
    }
}
