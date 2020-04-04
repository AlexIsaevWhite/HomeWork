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
        super.address = street;
        super.id = this.hashCode();
    }

    /**
     * Процедура выполнения функций жилого дома
     *
     * @see Building#executeFunction()
     */
    @Override
    void executeFunction() {
        System.out.println("В здании по адресу: " + address + " начали отдыхать " + inhabitants.length + " постояльцев.");
    }

    /**
     * Процедура выполнения функций жилого дома с принимаемыми параметрами
     *
     * @param number единица, которую необходимо добавить
     * @see Building#executeFunction(int)
     */
    @Override
    void executeFunction(int number) {
        whereLiveInhabitant(number);
    }

    /**
     * Процедура определения где живет постоялец
     *
     * @param numberOfInhabitant номер постояльца
     */
    void whereLiveInhabitant(int numberOfInhabitant) {
        System.out.println("Житель №" + numberOfInhabitant + " живет по адресу: " + inhabitants[--numberOfInhabitant].getPlace());
    }
}
