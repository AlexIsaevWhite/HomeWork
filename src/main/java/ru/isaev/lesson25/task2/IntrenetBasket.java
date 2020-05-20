package ru.isaev.lesson25.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class IntrenetBasket implements ru.isaev.lesson25.task2.Basket {
    private Map<String, Integer> products = new HashMap<>();

    @Override
    public void addProduct(String product, int quantity) {
        products.put(product, quantity);
    }

    @Override
    public void removeProduct(String product) {
        products.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (products.containsKey(product)) {
            products.put(product, quantity);
        } else {
            System.out.println("Данный продукт отсутствует.");
        }
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        List<String> outList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            outList.add("Название: " + entry.getKey() + "\t количество: " + entry.getValue() + " шт.");
        }
        return outList;
    }

    @Override
    public int getProductQuantity(String product) {
        return products.get(product);
    }
}
