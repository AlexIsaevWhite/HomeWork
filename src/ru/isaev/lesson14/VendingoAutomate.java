package ru.isaev.lesson14;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class VendingoAutomate {
    private final static Logger LOGGER = Logger.getLogger(VendingoAutomate.class);
    private final static Scanner INPUT = new Scanner(System.in);
    private static boolean endChoise = false;
    private static Drink[] assortment = Drink.values();
    private static int money = 0;

    public static void main(String[] args) {
        startWork();
    }

    static void startWork() {
        LOGGER.debug("Приложение начало работу.");
        greeting();
        while (!endChoise) {
            LOGGER.debug("Вход пользователя в меню выбора.");
            switch (INPUT.nextInt()) {
                case 1:
                    if (money == 0) {
                        LOGGER.warn("money = 0.");
                        System.out.println("Внесите деньги на счёт.");
                    } else {
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
                    LOGGER.debug("Пользователь выбрал выход из меню.");
                    endChoise = true;
                    break;
                default:
                    LOGGER.info("Пользователь не умеет читать.");
                    System.out.println("Пожалуйста выберите один из пунктов меню.");
                    greeting();
                    break;
            }
            System.out.println("На счету: " + money + " руб.");
        }
        LOGGER.debug("Приложение закончило работу.");
    }

    static void greeting() {
        LOGGER.info("Вывод пользователю информации главного меню на консоль.");
        System.out.println("Чтобы купить напиток - нажмите 1.");
        System.out.println("Чтобы посмотреть меню напитков - нажмите 2.");
        System.out.println("Чтобы внести деньги на внутренний счёт - нажмите 3.");
        System.out.println("Чтобы выйти - нажмите 4.");
    }

    static void choiseProduct() {
        LOGGER.debug("Вход в метод choiseProduct.");
        while (!endChoise) {
            textMenuOfChoiseProduct();
            int choiseOfPerson = INPUT.nextInt();
            try {
                if (choiseOfPerson == assortment.length)
                    break;
                for (int i = 0; i < assortment.length; i++) {
                    if (choiseOfPerson == i) {
                        buyProduct(choiseOfPerson);
                        endChoise = true;
                        break;
                    }
                }
            } catch (NullPointerException e) {
                LOGGER.error(e.getMessage(), e);
                endChoise = true;
            } finally {
                if (!endChoise)
                    System.out.println("Пожалуйста сделайте выбор.");
            }
        }
        LOGGER.debug("Выход из метода choiseProduct.");
    }

    static void textMenuOfChoiseProduct() {
        LOGGER.debug("Вход в метод textMenuOfChoiseProduct.");
        System.out.println("Выберите один из продуктов:");
        try {
            for (int i = 0; i < assortment.length; i++) {
                System.out.println(i + ". " + assortment[i].getName());
            }
            System.out.println(assortment.length + ". Выйти");
        } catch (NullPointerException e) {
            LOGGER.error(e.getMessage(), e);
            System.out.println("Ассортимент пуст.\n0. Выход.");
        } finally {
            LOGGER.debug("Выход из метода textMenuOfChoiseProduct.");

        }
    }

    static void buyProduct(int number) {
        LOGGER.debug("Вход в метод buyProduct.");
        if (money >= assortment[number].getCount()) {
            LOGGER.info("Пользователь совершил покупку.");
            money -= assortment[number].getCount();
            System.out.println("Благодарим за покупку.");
        } else {
            LOGGER.info("У пользователя недостаточно средств.");
            System.out.println("На вашем счёте недостаточно средств.");
        }
        LOGGER.debug("Выход из метода buyProduct.");
    }

    static void viewMenu() {
        LOGGER.debug("Вход в метод viewMenu.");
        System.out.println("В ассортименте имеется:");
        try {
            for (Drink i : assortment) {
                System.out.println(i.getName() + " стоимостью: " + i.getCount() + " руб.");
            }
        } catch (NullPointerException e) {
            LOGGER.error(e.getMessage(), e);
            System.out.println("Ассортимент пуст.\n0. Выход.");
        } finally {
            LOGGER.debug("Выход из метода viewMenu.");
        }
    }

    static void enterMoney() {
        LOGGER.debug("Вход в метод enterMoney.");
        System.out.println("Введите сколько хотите внести денег:");
        int enteringMoney = INPUT.nextInt();
        if (enteringMoney >= 0) {
            LOGGER.info("Пользователь внёс деньги.");
            money += enteringMoney;
        } else {
            LOGGER.warn("enteringMoney < 0.");
            System.out.println("Вы не можете взять деньги с автомата.");
        }
        LOGGER.debug("Выход из метода enterMoney.");
    }
}

