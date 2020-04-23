package ru.isaev.lesson06;

abstract class Building {

    protected int id;
    protected String address;

    /**
     * Абстрактный метод выполнения функционала здания
     *
     * @see House#executeFunction()
     * @see Bank#executeFunction()
     */
    abstract void executeFunction();

    /**
     * Абстрактный метод выполнения функционала здания c принимаемыми параметрами
     *
     * @param number единица, которую необходимо добавить
     * @see House#executeFunction(int)
     * @see Bank#executeFunction(int)
     */
    abstract void executeFunction(int number);
}
