package ru.isaev.lesson07;

enum MachineMenu {
    MILK("Молоко", 20),
    COFFE("Кофе", 50),
    TEA("Чай", 20),
    COCKTAIL("Коктейл", 100),
    GREEN_LUMINOUS_SLURRY("Зелёная светящиеся жижа", 200);

    private String name;
    private int count;

    MachineMenu(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    int getCount() {
        return count;
    }
}
