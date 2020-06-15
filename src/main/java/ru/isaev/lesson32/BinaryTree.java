package ru.isaev.lesson32;

import org.apache.log4j.Logger;

public class BinaryTree<T extends Comparable<T>> {
    private final Node<T> root = new Node<>(null);
    private final Logger LOGGER = Logger.getLogger(this.getClass());

    public void add(T... vals) {
        for (T v : vals) {
            add(v);
        }
    }

    public void add(T val) {
        if (val == null) {
            LOGGER.warn("input value is null");
            return;
        }
        if (root.val() == null) {
            root.setVal(val);
        } else {
            add(root, val);
        }
    }

    public int countLeaves() {
        return searchLeaves(root, 0);
    }

    private void add(Node<T> root, T val) {
        if (val.compareTo(root.val()) < 0) {
            if (root.left() == null) {
                root.setLeft(new Node<>(val));
            } else {
                add(root.left(), val);
            }
        } else {
            if (root.right() == null) {
                root.setRight(new Node<>(val));
            } else {
                add(root.right(), val);
            }
        }
    }

    private int searchLeaves(Node<T> root, int leaves) {
        if (root.isLeafNode()) {
            return ++leaves;
        }
        if (root.left() != null) {
            leaves = searchLeaves(root.left(), leaves);
        }
        if (root.right() != null) {
            leaves = searchLeaves(root.right(), leaves);
        }
        return leaves;
    }
}