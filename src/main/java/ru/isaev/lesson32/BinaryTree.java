package ru.isaev.lesson32;

class BinaryTree<T extends Comparable<T>> {
    private T val;
    private BinaryTree<T> parent;
    private BinaryTree<T> left = null;
    private BinaryTree<T> right = null;

    public BinaryTree() {
        this.val = null;
        this.parent = null;
    }

    private BinaryTree(T val, BinaryTree<T> parent) {
        this.val = val;
        this.parent = parent;
    }

    public BinaryTree<T> left() {
        return left;
    }

    public BinaryTree<T> right() {
        return right;
    }

    public void add(T... vals) {
        for (T v : vals) {
            add(v);
        }
    }

    public void add(T val) {
        if (this.val == null) {
            this.val = val;
        } else if (val.compareTo(this.val) < 0) {
            if (this.left == null) {
                this.left = new BinaryTree<>(val, this);
            } else this.left.add(val);
        } else {
            if (this.right == null) {
                this.right = new BinaryTree<>(val, this);
            } else this.right.add(val);
        }
    }
}
