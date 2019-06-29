package io.github.cd871127.conceal.tree;

public class AVLTree {
    private Integer data = null;
    private int leftHeight = 0;
    private int rightHeight = 0;
    private AVLTree leftChild = null;
    private AVLTree rightChild = null;

    private void leftRotate() {

    }

    private void rightRotate() {
    }

    public void insert(int data) {

    }

    public boolean search(int data) {
        return false;
    }

    public boolean remove(int data) {
        return false;
    }

    public void print() {

    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        int[] arr = {5, 2, 7, 9, 1, 0, 11, 3, 1};
        for (int i = 0; i != arr.length; ++i) {
            tree.insert(arr[i]);
        }


    }
}
