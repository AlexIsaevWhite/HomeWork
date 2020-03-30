package ru.isaev.lesson06;

public class Main {

    /**
     * Проверка работы классов.
     */
    public static void main(String[] args) {
        House house = new House("ул. Советская д.100", 100);
        Bank bank = new Bank("ул. Советская д.200", 30);
        bank.executeFunction();
        bank.addBankomate(5);
        bank.executeFunction();
        bank.addBankomate(7);
        bank.executeFunction();
        house.executeFunction();
        house.whereLiveInhabitant(1);
        house.whereLiveInhabitant(100);
        System.out.println("id банка " + bank.id);
        System.out.println("id дома " + house.id);
    }
}

/**
 * Абстрактный класс здания
 *
 * @author Alexander Isaev
 */
abstract class Building {

    protected int id;
    protected String address;

    /**
     * Абстрактная процедура выполнения функционала здания
     *
     * @see House#executeFunction()
     * @see Bank#executeFunction()
     */
    abstract void executeFunction();
}

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
     * Процедура определения где живет постоялец
     *
     * @param numberOfInhabitant номер постояльца
     */
    void whereLiveInhabitant(int numberOfInhabitant) {
        System.out.println("Житель №" + numberOfInhabitant + " живет по адресу: " + inhabitants[--numberOfInhabitant].getPlace());
    }
}

class Inhabitant {
    private House placeOfResidence;

    Inhabitant(House placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    String getPlace() {
        return placeOfResidence.address;
    }
}

final class Bank extends Building {

    private int numberOfWorker;
    private int numberOfBankomate;

    /**
     * Конструктор класса банк
     *
     * @param street         адрес банка
     * @param numberOfWorker количество рабочих банка
     */
    protected Bank(String street, int numberOfWorker) {
        this.numberOfWorker = numberOfWorker;
        numberOfBankomate = 0;
        super.address = street;
        super.id = this.hashCode();
    }

    /**
     * Процедура добавления определенного количества банкоматов
     *
     * @param number количество добавляемых банкоматов
     */
    protected void addBankomate(int number) {
        this.numberOfBankomate += number;
    }

    /**
     * Процедура выполнения функций банка
     *
     * @see Building#executeFunction()
     */
    @Override
    void executeFunction() {
        System.out.println("В банке по адресу: " + address + " начали работать " + numberOfWorker + " рабочих и " + numberOfBankomate + " банкоматов.");
    }
}