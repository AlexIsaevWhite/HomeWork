package ru.isaev.lesson12;

public class HelloWorldCrash {
    public static void main(String[] args) {
        args = new String[1];
        String text = "Hello World!";
        System.out.println(text);
        try {
            text = args[0];
            char myChar = text.charAt(0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            args[1] = text;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            throw new Exception("My Exception.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}