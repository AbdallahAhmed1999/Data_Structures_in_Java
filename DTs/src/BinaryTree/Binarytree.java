package BinaryTree;

import java.util.Map;

public class Binarytree<E> {

    private Node root;

    public void preorderTraversal(Node node){
        if (node == null) {
            return ;
        }
        System.out.print(" "+node.getData());
        preorderTraversal(node.getLeft());
        preorderTraversal(node.getRight());
    }

    public void inorderTraversal(Node node){
        if (node == null) {
            return ;
        }
        inorderTraversal(node.getLeft());
        System.out.print(" "+node.getData());
        inorderTraversal(node.getRight());
    }

    public void postorderTraversal(Node node){
        if (node == null) {
            return ;
        }
        postorderTraversal(node.getLeft());
        postorderTraversal(node.getRight());
        System.out.print(" "+node.getData());

    }

    private class Node<E>{
        private E data;
        private Node left;
        private Node right;

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}