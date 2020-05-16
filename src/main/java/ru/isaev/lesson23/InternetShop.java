package ru.isaev.lesson23;

import java.util.ArrayList;
import java.util.List;

public class InternetShop implements Basket {
    private final List<Product> PRODUCTS = new ArrayList<>();
    private final String OATMEAL = "Овсянка";
    private final String BUCKWHEAT = "Гречка";
    private final String PASTA = "Макароны";
    private final String MEET = "Мясо";

    public static void main(String[] args) {
        new InternetShop().startShopping();
    }

    public void startShopping() {
        addProducts();
        viewProducts();
        updateProducts();
        deleteProducts();
        viewProducts();
        this.clear();
        viewProducts();
    }

    public void addProducts() {
        this.addProduct(OATMEAL, 5);
        this.addProduct(BUCKWHEAT, 3);
        this.addProduct(PASTA, 3);
        this.addProduct(MEET, 1);
    }

    public void updateProducts() {
        this.updateProductQuantity(MEET, 5);
        this.updateProductQuantity(BUCKWHEAT, 1);
        System.out.println("Ассортимент обновился:");
        System.out.println(MEET + ": " + this.getProductQuantity(MEET) + " шт.");
        System.out.println(BUCKWHEAT + ": " + this.getProductQuantity(BUCKWHEAT) + " шт.");
        System.out.println();
    }

    public void deleteProducts() {
        this.removeProduct(BUCKWHEAT);
    }

    public void viewProducts() {
        List<String> strProducts = this.getProducts();
        if (!strProducts.isEmpty()) {
            for (String s : this.getProducts()) {
                System.out.println(s);
            }
            System.out.println();
        } else {
            System.out.println("Продуктов нет в корзине.");
            System.out.println();
        }
    }

    @Override
    public void addProduct(String product, int quantity) {
        PRODUCTS.add(new Product(product, quantity));
    }

    @Override
    public void removeProduct(String product) {
        PRODUCTS.remove(new Product(product));
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        int indexProduct = PRODUCTS.indexOf(new Product(product));
        PRODUCTS.get(indexProduct).setQuantity(quantity);
    }

    @Override
    public void clear() {
        PRODUCTS.clear();
    }

    @Override
    public List<String> getProducts() {
        List<String> outList = new ArrayList<>();
        for (Product p : PRODUCTS) {
            outList.add(p.toString());
        }
        return outList;
    }

    @Override
    public int getProductQuantity(String product) {
        int indexProduct = PRODUCTS.indexOf(new Product(product));
        return PRODUCTS.get(indexProduct).getQuantity();
    }
}
