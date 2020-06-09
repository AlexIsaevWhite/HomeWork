package ru.isaev.lesson32;

public class TreeLeaves {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5, 35, 1, 20, 4, 17, 31, 99, 18, 19);
        System.out.println(howMuchLeaves(tree) + " шт. листьев");
        tree.add(3);
        System.out.println(howMuchLeaves(tree) + " шт. листьев");
    }

    static int howMuchLeaves(BinaryTree binaryTree) {
        return searchLeaves(binaryTree, 0);
    }

    private static int searchLeaves(BinaryTree binaryTree, int leaves) {
        if (binaryTree.left() != null) {
            leaves = searchLeaves(binaryTree.left(), leaves);
        }
        if (binaryTree.right() != null) {
            leaves = searchLeaves(binaryTree.right(), leaves);
        }
        if (binaryTree.left() == null && binaryTree.right() == null) {
            leaves++;
        }
        return leaves;
    }
}

