package ru.isaev.lesson23;

import java.util.ArrayList;
import java.util.List;

class SimpleBasket implements Basket {
    private ArrayList<String> productsName = new ArrayList<>();
    private ArrayList<Integer> productsQuantity = new ArrayList<>();

    SimpleBasket(String[] name, int[] quantity) {
        for (int i = 0; i < name.length; i++) {
            productsName.add(name[i]);
            productsQuantity.add(quantity[i]);
        }
    }

    @Override
    public void addProduct(String product, int quantity) {
        int indexOfProduct = productsName.indexOf(product);
        if (indexOfProduct == -1) {
            productsName.add(product);
            productsQuantity.add(quantity);
        } else {
            int oldQuantity = productsQuantity.get(indexOfProduct);
            productsQuantity.set(indexOfProduct, oldQuantity + quantity);
        }
    }

    @Override
    public void removeProduct(String product) {
        productsQuantity.remove(productsName.indexOf(product));
        productsName.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        int indexOfProduct = productsName.indexOf(product);
        if (indexOfProduct == -1) {
            addProduct(product, quantity);
        } else {
            productsQuantity.set(indexOfProduct, quantity);
        }
    }

    @Override
    public void clear() {
        productsName.clear();
        productsQuantity.clear();
    }

    @Override
    public List<String> getSimpleBaskets() {
        List<String> outList = new ArrayList<>();
        for (int i = 0; i < productsName.size(); i++) {
            outList.add("Название: " + productsName.get(i) + "\t количество: " + productsQuantity.get(i) + " шт.");
        }
        return outList;
    }

    @Override
    public int getProductQuantity(String product) {
        int indexOfProduct = productsName.indexOf(product);
        return productsQuantity.get(indexOfProduct);
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof SimpleBasket) {
            SimpleBasket simpleBasket = (SimpleBasket) o;
            return name.equals(simpleBasket.name);
        } else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, name);
    }
     */
}
