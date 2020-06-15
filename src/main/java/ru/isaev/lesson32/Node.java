package ru.isaev.lesson32;

class Node<T extends Comparable<T>> {
    private T val;
    private Node<T> left = null;
    private Node<T> right = null;

    Node(T val) {
        this.val = val;
    }

    boolean isLeafNode() {
        return left == null && right == null;
    }

    T val() {
        return val;
    }

    void setVal(T val) {
        this.val = val;
    }

    Node<T> left() {
        return left;
    }

    void setLeft(Node<T> left) {
        this.left = left;
    }

    Node<T> right() {
        return right;
    }

    void setRight(Node<T> right) {
        this.right = right;
    }
}