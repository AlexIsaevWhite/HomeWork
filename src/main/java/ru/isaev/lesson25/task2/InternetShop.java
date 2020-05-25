package ru.isaev.lesson25.task2;

import java.util.List;

public class InternetShop {
    private final String oatmeal = "Овсянка";
    private final String buckwheat = "Гречка";
    private final String pasta = "Макароны";
    private final String meet = "Мясо";
    private final InternetBasket internetBasket = new InternetBasket() {
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
        internetBasket.removeProduct(buckwheat);
        viewProducts();
        internetBasket.clear();
        viewProducts();
    }

    public void updateProducts() {
        internetBasket.updateProductQuantity(meet, 5);
        int quantityOfPasta = internetBasket.getProductQuantity(pasta);
        internetBasket.updateProductQuantity(buckwheat, quantityOfPasta);
        System.out.println("Ассортимент обновился...");
        System.out.println();
    }

    public void viewProducts() {
        List<String> strProducts = internetBasket.getProducts();
        if (!strProducts.isEmpty()) {
            for (String s : strProducts) {
                System.out.println(s + " " + internetBasket.getProductQuantity(s) + " шт.");
            }
        } else {
            System.out.println("Продуктов нет в корзине.");
        }
        System.out.println();
    }
}
