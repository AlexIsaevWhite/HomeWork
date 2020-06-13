package ru.isaev.lesson30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharSearch {

    public static void main(String[] args) {
        String[] str = {"total", "teter", "abracadabra"};
        for (String s : str) {
            System.out.print("В слове " + s + " первая неповторимая буква: ");
            System.out.println(searchOriginality(s));
        }
    }

    static char searchOriginality(String inputString) throws NullPointerException {
        if (inputString == null) throw new NullPointerException();
        List<Character> charArr = new ArrayList<>();
        for (char c : inputString.toCharArray()) {
            charArr.add(c);
        }
        for (char c : charArr) {
            if (Collections.frequency(charArr, c) == 1) return c;
        }
        return ' ';
    }
}
