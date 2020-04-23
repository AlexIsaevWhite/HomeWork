package ru.isaev.lesson07;

import java.util.Scanner;

public class VendingoAutomate {
    private static Scanner input = new Scanner(System.in);
    private static boolean endChoise = false;
    private static Drink[] assortment = Drink.values();
    private static int money = 0;

    public static void main(String[] args) {
        startWork();
    }

    static void startWork() {
        greeting();
        while (!endChoise) {
            switch (input.nextInt()) {
                case 1:
                    if (money == 0)
                        System.out.println("Внесите деньги на счёт.");
                    else {
                        choiseProduct();
                        endChoise = false;
                    }
                    greeting();
                    break;
                case 2:
                    viewMenu();
                    break;
                case 3:
                    enterMoney();
                    greeting();
                    break;
                case 4:
                    endChoise = true;
                    break;
                default:
                    System.out.println("Пожалуйста выберите один из пунктов меню.");
                    greeting();
                    break;
            }
            System.out.println("На счету: " + money + " руб.");
        }
    }

    static void greeting() {
        System.out.println("Чтобы купить напиток - нажмите 1.");
        System.out.println("Чтобы посмотреть меню напитков - нажмите 2.");
        System.out.println("Чтобы внести деньги на внутренний счёт - нажмите 3.");
        System.out.println("Чтобы выйти - нажмите 4.");
    }

    static void choiseProduct() {
        while (true) {
            textMenuOfChoiseProduct();
            int choiseOfPerson = input.nextInt();
            if (choiseOfPerson == assortment.length)
                break;
            for (int i = 0; i < assortment.length; i++) {
                if (choiseOfPerson == i) {
                    buyProduct(choiseOfPerson);
                    endChoise = true;
                    break;
                }
            }
            if (endChoise)
                break;
            else
                System.out.println("Пожалуйста сделайте выбор.");
        }
    }

    static void textMenuOfChoiseProduct() {
        System.out.println("Выберите один из продуктов:");
        for (int i = 0; i < assortment.length; i++) {
            System.out.println(i + ". " + assortment[i].getName());
        }
        System.out.println(assortment.length + ". Выйти");
    }

    static void buyProduct(int number) {
        if (money >= assortment[number].getCount()) {
            money -= assortment[number].getCount();
            System.out.println("Благодарим за покупку.");
        } else
            System.out.println("На вашем счёте недостаточно средств.");
    }

    static void viewMenu() {
        System.out.println("В ассортименте имеется:");
        for (Drink i : assortment) {
            System.out.println(i.getName() + " стоимостью: " + i.getCount() + " руб.");
        }
    }

    static void enterMoney() {
        System.out.println("Введите сколько хотите внести денег:");
        int enteringMoney = input.nextInt();
        if (enteringMoney >= 0)
            money += input.nextInt();
        else
            System.out.println("Вы не можете взять деньги с автомата.");
    }


}

