package ru.isaev.lesson20;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class JSONObject {
    private Object[] breeds;
    private Object[] categories;
    private String id;
    private String url;
    private int width;
    private int height;

    public JSONObject() {
    }

    public JSONObject(Object[] breeds, Object[] categories, String id, String url, int width, int height) {
        this.breeds = breeds;
        this.categories = categories;
        this.id = id;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public Object[] getBreeds() {
        return breeds;
    }

    public Object[] getCategories() {
        return categories;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "URL картинка: " + url + System.lineSeparator() + "Wight: " + width
                + System.lineSeparator() + "Height: " + height;
    }
}

