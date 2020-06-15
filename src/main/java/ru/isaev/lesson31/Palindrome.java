package ru.isaev.lesson31;

import org.apache.log4j.Logger;

public class Palindrome {
    private final static Logger LOGGER = Logger.getLogger(Palindrome.class);

    public static void main(String[] args) {
        String[] string = {"12121", "abba", "adidas", "madam"};
        for (String s : string) {
            System.out.println(s);
            System.out.println("isPalindrome: " + isPalindrome(s));
            System.out.println("isPalindromeStandardFunction: " + isPalindromeStandardFunction(s));
            System.out.println();
        }
    }

    static boolean isPalindrome(String input) {
        if (input == null) {
            LOGGER.warn("input is null");
            return false;
        }
        for (int begin = 0, end = input.length() - 1; begin < end; begin++, end--) {
            if (input.charAt(begin) != input.charAt(end)) return false;
        }
        return true;
    }

    static boolean isPalindromeStandardFunction(String input) {
        if (input == null) {
            LOGGER.warn("input is null");
            return false;
        }
        StringBuilder sb = new StringBuilder(input);
        String data = sb.reverse().toString();
        return input.equals(data);
    }
}
