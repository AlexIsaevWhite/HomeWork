package ru.isaev.lesson07;

enum Drink {
    MILK("Молоко", 20),
    COFFE("Кофе", 50),
    TEA("Чай", 20),
    COCKTAIL("Коктейл", 100),
    GREEN_LUMINOUS_SLURRY("Зелёная светящиеся жижа", 200);

    private String name;
    private int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    int getCount() {
        return price;
    }
}