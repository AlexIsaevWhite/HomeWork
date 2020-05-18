package ru.isaev.lesson23;

import java.util.List;

public class InternetShop {
    private final String oatmeal = "Овсянка";
    private final String buckwheat = "Гречка";
    private final String pasta = "Макароны";
    private final String meet = "Мясо";
    private final SimpleBasket simpleBaskets =
            new SimpleBasket(new String[]{meet, buckwheat}, new int[]{1, 3});

    public static void main(String[] args) {
        new InternetShop().startShopping();
    }

    public void startShopping() {
        addProducts();
        viewProducts();
        updateProducts();
        deleteProducts();
        viewProducts();
        simpleBaskets.clear();
        viewProducts();
    }

    public void addProducts() {
        simpleBaskets.addProduct(oatmeal, 5);
        simpleBaskets.addProduct(pasta, 3);
    }

    public void updateProducts() {
        simpleBaskets.updateProductQuantity(meet, 5);
        simpleBaskets.updateProductQuantity(buckwheat, 1);
        System.out.println("Ассортимент обновился:");
        System.out.println(meet + ": " + simpleBaskets.getProductQuantity(meet) + " шт.");
        System.out.println(buckwheat + ": " + simpleBaskets.getProductQuantity(buckwheat) + " шт.");
        System.out.println();
    }

    public void deleteProducts() {
        simpleBaskets.removeProduct(buckwheat);
    }

    public void viewProducts() {
        List<String> strProducts = simpleBaskets.getSimpleBaskets();
        if (!strProducts.isEmpty()) {
            for (String s : simpleBaskets.getSimpleBaskets()) {
                System.out.println(s);
            }
            System.out.println();
        } else {
            System.out.println("Продуктов нет в корзине.");
            System.out.println();
        }
    }
}
