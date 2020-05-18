package ru.isaev.lesson23;

import java.util.List;

public class InternetShop {
    private final String oatmeal = "Овсянка";
    private final String buckwheat = "Гречка";
    private final String pasta = "Макароны";
    private final String meet = "Мясо";
    private final SimpleBasket simpleBaskets = new SimpleBasket() {
        {
            addProduct(oatmeal, 5);
            addProduct(buckwheat, 4);
            addProduct(pasta, 3);
            addProduct(meet, 1);
        }
    };

    public static void main(String[] args) {
        new InternetShop().startShopping();
    }

    public void startShopping() {
        viewProducts();
        updateProducts();
        viewProducts();
        simpleBaskets.removeProduct(buckwheat);
        viewProducts();
        simpleBaskets.clear();
        viewProducts();
    }

    public void updateProducts() {
        simpleBaskets.updateProductQuantity(meet, 5);
        int quantityOfPasta = simpleBaskets.getProductQuantity(pasta);
        simpleBaskets.updateProductQuantity(buckwheat, quantityOfPasta);
        System.out.println("Ассортимент обновился...");
        System.out.println();
    }

    public void viewProducts() {
        List<String> strProducts = simpleBaskets.getSimpleBaskets();
        if (!strProducts.isEmpty()) {
            for (String s : strProducts) {
                System.out.println(s);
            }
            System.out.println();
        } else {
            System.out.println("Продуктов нет в корзине.");
            System.out.println();
        }
    }
}
