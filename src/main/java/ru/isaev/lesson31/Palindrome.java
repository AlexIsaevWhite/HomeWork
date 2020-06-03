package ru.isaev.lesson31;

public class Palindrome {

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
        boolean isPalindrome;
        if (input != null) {
            isPalindrome = true;
            char[] chars = input.toCharArray();
            for (int begin = 0, end = chars.length - 1; begin < end; begin++, end--) {
                if (chars[begin] != chars[end]) {
                    isPalindrome = false;
                    break;
                }
            }
        } else isPalindrome = false;
        return isPalindrome;
    }

    static boolean isPalindromeStandardFunction(String input) {
        StringBuilder buffer = new StringBuilder(input);
        buffer.reverse();
        String data = buffer.toString();
        return input.equals(data);
    }
}
