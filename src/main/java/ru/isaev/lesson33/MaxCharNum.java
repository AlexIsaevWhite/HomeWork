package ru.isaev.lesson33;

import java.util.*;

public class MaxCharNum {

    public static void main(String[] args) {
        String s = "This is test message";
        findMaxNumOfChar(s);
    }

    static void findMaxNumOfChar(String inputString) throws NullPointerException {
        if (inputString == null) throw new NullPointerException();
        List<Character> arr = new ArrayList<>();
        Set<Character> hs = new HashSet<>();
        int numMaxChar = 0;
        char maxChar = 0;

        inputString.chars().forEach((i) -> {
            arr.add((char) i);
            hs.add((char) i);
        });
        for (char c : hs) {
            int temp = Collections.frequency(arr, c);
            if (temp > numMaxChar) {
                numMaxChar = temp;
                maxChar = c;
            }
        }
        print(maxChar, numMaxChar);
    }

    static private void print(char c, int i) {
        System.out.println("Character: " + c + " has occurred maximum times in String: " + i);
    }
}