package ru.isaev.lesson08;

public class Expreriments {
    public static void main(String[] args) {
        Expreriments a = new Expreriments();
        a.startTest();
    }

    final void startTest() {
        System.out.println("Сложение");
        System.out.println(Calculator.addUp(1, 2));
        System.out.println(Calculator.addUp(1.5, 2.3));
        System.out.println("Вычитание");
        System.out.println(Calculator.subtract(5, 1));
        System.out.println(Calculator.subtract(5.6, 1.2));
        System.out.println("Умножение");
        System.out.println(Calculator.multiply(5, 2));
        System.out.println(Calculator.multiply(5.1, 1.4));
        System.out.println("Деление");
        System.out.println(Calculator.division(5, 2));
        System.out.println(Calculator.division(5.0, 2.0));
        System.out.println("Процент от числа");
        System.out.println(Calculator.percentageOfNumber(5, 0.55));
        System.out.println("Создание объектов");
        new Objects();
        System.out.println("Всего реализовано " + Objects.getNubersOfObjects() + " объектов.");
        new Objects();
        System.out.println("Всего реализовано " + Objects.getNubersOfObjects() + " объектов.");
        System.out.println("Создание договора и его конвертация в акт");
        Contract contract = new Contract(1, new String[]{"Чай", "Гречка", "Туалетная бумага"});
        Act act = Convector.convert(contract);
        System.out.println("Номер: " + act.getNumber());
        System.out.println("Дата: " + act.getDate());
        System.out.println("Продукты:");
        for (String i : act.getProducts()) {
            System.out.println(i);
        }
    }
}

