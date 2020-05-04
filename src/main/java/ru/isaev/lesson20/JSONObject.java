package ru.isaev.lesson20;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

@JsonAutoDetect
public class JSONObject {
    @JsonIgnore
    private ArrayList<Object> breeds;
    @JsonIgnore
    private String id;
    private String url;
    private int width;
    private int height;

    public JSONObject() {
    }

    public JSONObject(ArrayList<Object> breeds, String id, String url, int width, int height) {
        this.breeds = breeds;
        this.id = id;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    @JsonIgnore
    public ArrayList<Object> getBreeds() {
        return breeds;
    }

    @JsonIgnore
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

