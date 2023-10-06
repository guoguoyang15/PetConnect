package com.example.myapplication.AVLTree;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    /*
        As a result of inheritance by using 'extends BinarySearchTree<T>,
        all class fields within BinarySearchTree are also present here.
        So while not explicitly written here, this class has:
            - value
            - leftNode
            - rightNode
     */

    public AVLTree(T value) {
        super(value);
        // Set left and right children to be of EmptyAVL as opposed to EmptyBST.
        this.leftNode = new EmptyAVL<>();
        this.rightNode = new EmptyAVL<>();
    }

    public AVLTree(T value, Tree<T> leftNode, Tree<T> rightNode) {
        super(value, leftNode, rightNode);
    }

    /**
     * @return balance factor of the current node.
     */
    public int getBalanceFactor() {
        return leftNode.getHeight() - rightNode.getHeight();
    }

    @Override
    public AVLTree<T> insert(T element) {
        // Ensure input is not null.
        if (element == null)
            throw new IllegalArgumentException("Input cannot be null");

        if (element.compareTo(value) > 0) {
            AVLTree<T> newTree = new AVLTree<>(value, leftNode, rightNode.insert(element));
            if (newTree.getBalanceFactor() < -1) {
                AVLTree<T> rightSubTree = (AVLTree<T>) newTree.rightNode;
                if (rightSubTree.getBalanceFactor() < 0) {
                    newTree = newTree.leftRotate();
                } else {
                    rightSubTree = rightSubTree.rightRotate();
                    newTree = new AVLTree<>(value, leftNode, rightSubTree).leftRotate();
                }
            }
            return newTree;
        } else if (element.compareTo(value) <= 0) {
            AVLTree<T> newTree =  new AVLTree<>(value, leftNode.insert(element), rightNode);
            if (newTree.getBalanceFactor() > 1) {
                AVLTree<T> leftSubTree = (AVLTree<T>) newTree.leftNode;
                if (leftSubTree.getBalanceFactor() > 0) {
                    newTree = newTree.rightRotate();
                } else {
                    leftSubTree = leftSubTree.leftRotate();
                    newTree = new AVLTree<>(value, leftSubTree, rightNode).rightRotate();
                }
            }
            return newTree;
        }
        return this;
    }

    /**
     * Conducts a left rotation on the current node.
     *
     * @return the new 'current' or 'top' node after rotation.
     */
    public AVLTree<T> leftRotate() {
        Tree<T> newParent = this.rightNode;
        Tree<T> newRightSubTree = newParent.rightNode;
        Tree<T> newLeftSubTree = new AVLTree<>(this.value, this.leftNode, newParent.leftNode);
        return new AVLTree<>(newParent.value, newLeftSubTree, newRightSubTree);
    }

    /**
     * Conducts a right rotation on the current node.
     *
     * @return the new 'current' or 'top' node after rotation.
     */
    public AVLTree<T> rightRotate() {
        Tree<T> newParent = this.leftNode;
        Tree<T> newLeftSubTree = newParent.leftNode;
        Tree<T> newRightSubTree = new AVLTree<>(this.value, newParent.rightNode, this.rightNode);
        return new AVLTree<>(newParent.value, newLeftSubTree, newRightSubTree);
    }

    public static class EmptyAVL<T extends Comparable<T>> extends EmptyTree<T> {
        @Override
        public Tree<T> insert(T element) {
            // The creation of a new Tree, hence, return tree.
            return new AVLTree<>(element);
        }
    }
}
