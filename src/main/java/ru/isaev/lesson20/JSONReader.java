package ru.isaev.lesson20;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;

public class JSONReader {

    public static void main(String[] args) {
        new JSONReader().startRead();
    }

    void startRead() {
        JSONObject[] jsonObjects;
        URL url;
        ObjectMapper mapper = new ObjectMapper();
        try {
            url = new URL("https://api.thecatapi.com/v1/images/search");
            jsonObjects = mapper.readValue(url, JSONObject[].class);
            for (JSONObject j : jsonObjects) {
                System.out.println(j);
            }
        } catch (UnknownHostException e) {
            System.err.println("Сайт по URL ссылке недоступен.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
