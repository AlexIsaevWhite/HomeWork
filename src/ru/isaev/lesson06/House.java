package ru.isaev.lesson06;

final class House extends Building {

    private Inhabitant[] inhabitants;

    /**
     * Конструктор класса жилого дома
     *
     * @param street              адрес жилого дома
     * @param numberOfInhabitants количество постояльцев
     */
    protected House(String street, int numberOfInhabitants) {
        inhabitants = new Inhabitant[numberOfInhabitants];
        for (int i = 0; i < inhabitants.length; i++) {
            inhabitants[i] = new Inhabitant(this);
        }
        address = street;
        id = this.hashCode();
    }

    /**
     * Вывод информации о здании в консоль
     *
     * @see Building#executeFunction()
     */
    @Override
    void executeFunction() {
        System.out.println("В здании по адресу: " + address + " начали отдыхать " + inhabitants.length + " постояльцев.");
    }

    @Override
    void executeFunction(int number) {
        whereLiveInhabitant(number);
    }

    /**
     * Вывод информации где живет постоялец в консоль
     *
     * @param numberOfInhabitant номер постояльца
     */
    void whereLiveInhabitant(int numberOfInhabitant) {
        System.out.println("Житель №" + numberOfInhabitant + " живет по адресу: " + inhabitants[--numberOfInhabitant].getPlace());
    }
}
