package ru.isaev.lesson31;

public class Palindrome {

    public static void main(String[] args) {
        String[] string = {"12121", "abba", "addidas"};
        for (String s : string) {
            System.out.println(s);
            System.out.println("isPolidrome: " + isPolidrome(s));
            System.out.println("isPolidromeStandartFunction: " + isPolidromeStandartFunction(s));
            System.out.println();
        }
    }

    static boolean isPolidrome(String input) {
        boolean isPolidrome;
        if (input != null) {
            isPolidrome = true;
            char[] chars = input.toCharArray();
            for (int begin = 0, end = chars.length - 1; begin < end; begin++, end--) {
                if (chars[begin] != chars[end]) {
                    isPolidrome = false;
                    break;
                }
            }
        } else isPolidrome = false;
        return isPolidrome;
    }

    static boolean isPolidromeStandartFunction(String input) {
        StringBuilder buffer = new StringBuilder(input);
        buffer.reverse();
        String data = buffer.toString();
        return input.equals(data);
    }
}
