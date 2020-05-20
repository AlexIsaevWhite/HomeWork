package ru.isaev.lesson25.task2;

import java.util.List;

public class InternetShop {
    private final String oatmeal = "Овсянка";
    private final String buckwheat = "Гречка";
    private final String pasta = "Макароны";
    private final String meet = "Мясо";
    private final IntrenetBasket intrenetBasket = new IntrenetBasket() {
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
        intrenetBasket.removeProduct(buckwheat);
        viewProducts();
        intrenetBasket.clear();
        viewProducts();
    }

    public void updateProducts() {
        intrenetBasket.updateProductQuantity(meet, 5);
        int quantityOfPasta = intrenetBasket.getProductQuantity(pasta);
        intrenetBasket.updateProductQuantity(buckwheat, quantityOfPasta);
        System.out.println("Ассортимент обновился...");
        System.out.println();
    }

    public void viewProducts() {
        List<String> strProducts = intrenetBasket.getProducts();
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
