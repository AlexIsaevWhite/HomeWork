package ru.isaev.lesson33;

import java.util.*;

public class MaxCharNum {

    public static void main(String[] args) {
        String s = "This is test message";
        findMaxNumOfChar(s);
    }

    static void findMaxNumOfChar(String inputString) {
        if (inputString != null) {
            List<Character> arr = new ArrayList<>();
            Set<Character> hs = new HashSet<>();
            char maxChar = ' ';
            int numMaxChar = 0;

            for (char c : inputString.toCharArray()) {
                arr.add(c);
                hs.add(c);
            }
            for (char c : hs) {
                int temp = Collections.frequency(arr, c);
                if (temp > numMaxChar) {
                    numMaxChar = temp;
                    maxChar = c;
                }
            }
            print(maxChar, numMaxChar);
        }
    }

    static private void print(char c, int i) {
        System.out.println("Character: " + c + " has occurred maximum times in String: " + i);
    }
}
