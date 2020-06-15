package ru.isaev.lesson32;

public class TreeLeaves {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5, 35, 1, 20, 4, 17, 31, 99, 18, 19);
        System.out.println(tree.countLeaves() + " шт. листьев");
        tree.add(3);
        System.out.println(tree.countLeaves() + " шт. листьев");
    }
}