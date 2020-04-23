package ru.isaev.lesson06;

public class Main {

    /**
     * Проверка работы классов.
     */
    public static void main(String[] args) {
        Building house = new House("ул. Советская д.100", 100);
        Building bank = new Bank("ул. Советская д.200", 30);
        bank.executeFunction();
        bank.executeFunction(5);
        bank.executeFunction();
        bank.executeFunction(7);
        bank.executeFunction();
        house.executeFunction();
        house.executeFunction(1);
        house.executeFunction(100);
        System.out.println("id банка " + bank.id);
        System.out.println("id дома " + house.id);
    }
}