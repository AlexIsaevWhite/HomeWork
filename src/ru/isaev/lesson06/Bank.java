package ru.isaev.lesson06;

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
     * Процедура выполнения функций банка
     *
     * @see Building#executeFunction()
     */
    @Override
    void executeFunction() {
        System.out.println("В банке по адресу: " + address + " начали работать " + numberOfWorker + " рабочих и " + numberOfBankomate + " банкоматов.");
    }

    /**
     * Процедура добавления определенного количества банкоматов
     *
     * @param number количество добавляемых банкоматов
     * @see Building#executeFunction(int)
     */
    @Override
    protected void executeFunction(int number) {
        this.numberOfBankomate += number;
    }
}
