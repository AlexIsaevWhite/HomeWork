package ru.isaev.lesson06;

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

    /**
     * Абстрактная процедура выполнения функционала здания c принимаемыми параметрами
     *
     * @param number единица, которую необходимо добавить
     * @see House#executeFunction(int)
     * @see Bank#executeFunction(int)
     */
    abstract void executeFunction(int number);
}
