package ru.isaev.lesson33;

import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxCharNum {
    private final static Logger LOGGER = Logger.getLogger(MaxCharNum.class);

    public static void main(String[] args) {
        String s = "This is test message: ttt";
        maxCountChar(s);
        maxCountChar(null);
    }

    static void maxCountChar(String inputString) {
        if (inputString == null) {
            LOGGER.warn("inputString is null");
            return;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        putNumChar(charMap, inputString);
        printMax(charMap, Collections.max(charMap.values()));
    }

    static private void putNumChar(Map<Character, Integer> charMap, String string) {
        int numChar;
        for (char c : string.toCharArray()) {
            numChar = charMap.getOrDefault(c, 0);
            charMap.put(c, ++numChar);
        }
    }

    static private void printMax(Map<Character, Integer> charMap, int maxCount) {
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() == maxCount)
                System.out.println("Character: " + entry.getKey() + " has occurred maximum times in String: "
                        + entry.getValue());
        }
    }
}