package ru.isaev.lesson25.task2;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InternetBasket implements ru.isaev.lesson25.task2.Basket {
    private final Logger LOGGER = Logger.getLogger(this.getClass());
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
        if (products.replace(product, quantity) == null) {
            LOGGER.debug(product + " отсутствует.");
        }
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        return new ArrayList<>(products.keySet());
    }

    @Override
    public int getProductQuantity(String product) {
        return products.get(product);
    }
}
