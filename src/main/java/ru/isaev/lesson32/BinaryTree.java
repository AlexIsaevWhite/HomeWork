package ru.isaev.lesson32;

import org.apache.log4j.Logger;

public class BinaryTree<T extends Comparable<T>> {
    private final Logger LOGGER = Logger.getLogger(this.getClass());
    private Node<T> root = null;

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
        if (root == null) {
            root = new Node<>(val);
        } else {
            add(root, val);
        }
    }

    public int countLeaves() {
        return searchLeaves(root);
    }

    private void add(Node<T> node, T val) {
        if (val.compareTo(node.val()) < 0) {
            if (node.left() == null) {
                node.setLeft(new Node<>(val));
            } else {
                add(node.left(), val);
            }
        } else {
            if (node.right() == null) {
                node.setRight(new Node<>(val));
            } else {
                add(node.right(), val);
            }
        }
    }

    private int searchLeaves(Node<T> node) {
        if (node.isLeafNode()) {
            return 1;
        }
        int leaves = 0;
        if (node.left() != null) {
            leaves += searchLeaves(node.left());
        }
        if (node.right() != null) {
            leaves += searchLeaves(node.right());
        }
        return leaves;
    }
}