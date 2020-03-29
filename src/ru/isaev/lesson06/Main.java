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
        bank.addBankomate(5);
        bank.executeFunction();
        house.executeFunction();
        System.out.println(bank.id); // id банка
        System.out.println(house.id); // id дома
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

/**
 * Класс жилого дома
 *
 * @author Alexander Isaev
 */
final class House extends Building {

    private int numberOfInhabitants;

    /**
     * Конструктор класса жилого дома
     *
     * @param street              адрес жилого дома
     * @param numberOfInhabitants количество постояльцев
     */
    protected House(String street, int numberOfInhabitants) {
        this.numberOfInhabitants = numberOfInhabitants;
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
        System.out.println("В здании по адресу: " + address + " начали отдыхать " + numberOfInhabitants + " постояльцев.");
    }
}

/**
 * Класс банка
 *
 * @author Alexander Isaev
 */
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