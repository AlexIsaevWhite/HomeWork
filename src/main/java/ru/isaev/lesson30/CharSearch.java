package ru.isaev.lesson30;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharSearch {
    private final static Logger LOGGER = Logger.getLogger(CharSearch.class);

    public static void main(String[] args) {
        String[] str = {"total", "teter", "abracadabra"};
        for (String s : str) {
            System.out.print("В слове " + s + " первая неповторимая буква: ");
            System.out.println(searchOriginality(s));
        }
    }

    static char searchOriginality(String inputString) {
        if (inputString != null) {
            List<Character> charArr = new ArrayList<>();
            for (char c : inputString.toCharArray()) {
                charArr.add(c);
            }
            for (char c : charArr) {
                if (Collections.frequency(charArr, c) == 1) return c;
            }
        } else LOGGER.warn("inputString is null");
        return ' ';
    }
}
