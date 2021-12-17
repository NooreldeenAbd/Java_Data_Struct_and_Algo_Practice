package com.company;

import java.util.ArrayList;

public class Tree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node (int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return "Node=" + value;
        }
    }

    private Node root;


    public void insert(int value) {

        var node = new Node(value);
        if (root == null){
            root = node;
            return;
        }

        var current = root;
        while (true){
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }

            else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }

    }


    public boolean find(int value){

        var current = root;
        while (current != null){

            if (value < current.value)
                current = current.leftChild;

            else if (value > current.value)
                current = current.rightChild;

            else
                return true;
        }

        return false;
    }


    public void traversePreOrder(){
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }


    public void traverseInOrder(){
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }


    public void traversePostOrder(){
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }


    public int height(){
        return height(root);
    }
    private int  height(Node root){
        if (root == null)
            return -1;
        if (isLeaf(root))
            return 0;
        return 1+Math.max(
                height(root.leftChild),
                height(root.rightChild));
    }


    public int min(){
        return min(root);
    }
    private int min(Node root){
        // Finding the min in a binary tree: O(n)
        if (root == null)
            return -1;

        if (isLeaf(root))
            return root.value;

       var left = min(root.leftChild);
       var right = min(root.rightChild);
       return Math.min(root.value, Math.min(left, right));
    }


    public int binarySearchMin(){
        // Finding the min in a binary search tree: O(log n)
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var lasst = current;
        while (current != null){
            lasst = current;
            current = current.leftChild;
        }
        return lasst.value;
    }


    public boolean equals(Tree other){
        if (other == null)
            return false;
        return equals(root, other.root);
    }
    private boolean equals (Node first, Node second){
        if (first == null && second == null)
            return true;

        if(first != null && second != null){
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }
        return false;
    }


    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root,
                Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node root, int min, int max){
        if (root == null)
            return true;

        return min < root.value && root.value < max
                && isBinarySearchTree(root.rightChild, root.value ,max)
                && isBinarySearchTree(root.leftChild,min, root.value);
    }
    public void swapRoot(){
        // For testing "isBinarySearchTree"
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }


    public ArrayList<Integer> getNodeAtDistance(int dist){
        var list = new ArrayList<Integer>();
        getNodeAtDistance(root, dist, list);
        return list;
    }
    private void getNodeAtDistance(Node root, int dist, ArrayList<Integer> list){
        if (root == null)
            return;
        if (dist == 0) {
            list.add(root.value);
            return;
        }
        getNodeAtDistance(root.leftChild, dist-1, list);
        getNodeAtDistance(root.rightChild, dist-1, list);

    }


    public void traverseLevelOrder(){
        for(var i = 0; i<= height(); i++){
            System.out.println("Level "+i);
            for(var value: getNodeAtDistance(i))
                System.out.println(value);
        }
    }


    private boolean isLeaf (Node node){
        return  (node.rightChild == null && node.rightChild == null);
    }
}
