package ru.isaev.lesson30;

import java.util.ArrayList;
import java.util.Collections;

public class CharSearch {

    public static void main(String[] args) {
        String[] str = {"total", "teter", "abracadabra"};
        for (String s : str) {
            System.out.print("В слове " + s + " первая неповторимая буква: ");
            System.out.println(searchOriginality(s));
        }
    }

    static char searchOriginality(String inputString) {
        ArrayList<Character> characters = new ArrayList<>();
        for (char c : inputString.toCharArray()) {
            characters.add(c);
        }
        for (char c : characters)
            if (Collections.frequency(characters, c) == 1) return c;
        return ' ';
    }
}
