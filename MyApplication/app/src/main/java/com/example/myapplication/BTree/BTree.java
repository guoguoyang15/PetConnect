package com.example.myapplication.BTree;

import androidx.annotation.NonNull;

/**
 * @param <T> the generic type this BTree uses. It extends comparable
 *            which allows us to order two of the same type.
 */
public class BTree<T extends Comparable<T>> {
    /**
     * Fields of a BTree.
     */
    private final int order;          // Order of the BTree.
    private BTreeNode root;     // Root node of the BTree.

    /**
     * Constructor which sets the field 'order'
     *
     * @param order of the BTree.
     */
    public BTree(int order) {
        this.order = order;
        root = new BTreeNode();
    }

    /**
     * Adds key to the BTree.
     *
     * @param key to be inserted.
     */
    public void insert(T key) {
        root.insert(key);
        if (root.keys.size() >= order) {
            BTreeNode child = root;
            root = new BTreeNode();
            root.children.add(child);
            split(root, child);
        }
    }

    /**
     * Will conduct a split on the provided indexed child of the provided node.
     *
     * @param node         The current node whose provided child to split will be split.
     * @param childToSplit The child to split within the provided node.
     */
    private void split(BTreeNode node, BTreeNode childToSplit) {
        int medianIndex = childToSplit.keys.size() % 2 == 0 ? childToSplit.keys.size() / 2 - 1 : childToSplit.keys.size() / 2;
        T median = childToSplit.keys.get(medianIndex);
        addInOrder(node.keys, median);
        int newMedianIndex = node.keys.indexOf(median);

        LimitedArrayList<T> rightKeys = childToSplit.keys.get(medianIndex + 1, childToSplit.keys.size());
        LimitedArrayList<BTreeNode> rightChildren = new LimitedArrayList<>(order + 1);
        if (childToSplit.children.size() > 0) {
            rightChildren = childToSplit.children.get(medianIndex + 1, childToSplit.children.size());
        }

        childToSplit.keys.removeAll(rightKeys);
        childToSplit.keys.remove(median);
        childToSplit.children.removeAll(rightChildren);

        BTreeNode right = new BTreeNode();
        right.keys.addAll(rightKeys);
        right.children.addAll(rightChildren);
        node.children.add(newMedianIndex + 1, right);
    }

    /**
     * Adds element in ascending order.
     * Helper function for insert.
     *
     * @param list    to add element into.
     * @param element to add into list.
     */
    private void addInOrder(LimitedArrayList<T> list, T element) {
        // Ensure inputs are not null.
        if (list == null || element == null)
            throw new IllegalArgumentException("Input cannot be null");

        // Go through each index and check if the element being inserted is less than the current element being looked at.
        for (int i = 0; i < list.size() && i < list.getCapacity(); i++) {
            // If less, insert it at that index (pushing all other elements forward by 1).
            if (element.compareTo(list.get(i)) < 0) {
                list.add(i, element);
                return;
            }
        }
        // If nothing is greater than the element being inserted, than it must be the greatest element. Insert at end.
        list.add(element);
    }



    /**
     * @return maximum key of the BTree
     */
    public T max() {
        return root.max();
    }

    /**
     * @return minimum key of the BTree
     */
    public T min() {
        return root.min();
    }

    /**
     * Translates the class into something human readable.
     */
    @NonNull
    @Override
    public String toString() {
        return "{" +
                "order=" + order +
                ", root=" + root +
                '}';
    }

    /**
     * @return Graphical representation of the tree.
     */
    public String display() {
        return this.root.display(0);
    }

    /**
     * Defines the nodes that make up the BTree.
     */
    class BTreeNode {
        /**
         * Fields of the node class.
         */
        private final LimitedArrayList<T> keys;               // Keys held by the node.
        private final LimitedArrayList<BTreeNode> children;   // Children of the node.

        /**
         * Constructor which initialises the fields.
         */
        public BTreeNode() {
            // The limit of keys is actually 'order - 1' but at times it will go over by 1 in which we will need to split.
            this.keys = new LimitedArrayList<>(order);

            // The limit on children is actually 'order' but at times we will go over by 1 in which we will need to split.
            this.children = new LimitedArrayList<>(order + 1);
        }

        /**
         * Adds a key to the node. Splitting if necessary.
         *
         * @param key to be inserted.
         */
        private void insert(T key) {
            if (this.children.size() == 0) {
                addInOrder(this.keys, key);
            } else {
                int i = 0;
                while (i < this.keys.size() && i < this.keys.getCapacity()) {
                    if (key.compareTo(this.keys.get(i)) < 0) {
                        this.children.get(i).insert(key);
                        if (this.children.get(i).keys.size() >= order) {
                            split(this, this.children.get(i));
                        }
                        return;
                    }
                    i++;
                }
                this.children.get(i).insert(key);
                if (this.children.get(i).keys.size() >= order) {
                    split(this, this.children.get(i));
                }
            }
        }

        /**
         * @return maximum key of the BTree
         */
        public T max() {
            // Ensure that the BTreeNode is not empty (note that if there are no keys, then there can't be children).
            if (this.keys.size() == 0) {
                return null;
            }

            // Check if leaf
            if (this.children.size() == 0) {
                // Return maximum value (should be right most).
                return this.keys.get(this.keys.size() - 1);
            } else {
                // Recurse through the rightmost node.
                return this.children.get(this.children.size() - 1).max();
            }
        }

        /**
         * @return minimum key of the BTree
         */
        public T min() {
            // Ensure that the BTreeNode is not empty (note that if there are no keys, then there can't be children).
            if (this.keys.size() == 0) {
                return null;
            }

            // Check if leaf
            if (this.children.size() == 0) {
                // Return minimum value (should be left most).
                return this.keys.get(0);
            } else {
                // Recurse through the leftmost node.
                return this.children.get(0).min();
            }
        }

        /**
         * Translates the class into something human readable.
         */
        @NonNull
        @Override
        public String toString() {
            return "{" +
                    "keys=" + keys +
                    ", children=" + children +
                    '}';
        }

        /**
         * Graphically visualises the tree for human readability.
         *
         * @param tabs from the left side of the screen.
         * @return graph of the tree.
         */
        public String display(int tabs) {
            StringBuilder sb = new StringBuilder(keys.toString());
            for (BTreeNode node : children) {
                sb.append("\n").append("\t".repeat(tabs)).append("├─").append(node.display(tabs + 1));
            }
            return sb.toString();
        }
    }
}

