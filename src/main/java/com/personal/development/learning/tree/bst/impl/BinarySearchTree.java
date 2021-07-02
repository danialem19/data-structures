package com.personal.development.learning.tree.bst.impl;

import com.personal.development.learning.tree.bst.BSTInterface;

import java.util.*;

/**
 * Your implementation of a binary search tree.
 *
 * @author DANIEL TADESSE
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements BSTInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private Node<T> root;
    private int size;

    /**
     * A no argument constructor that should initialize an empty BST.
     * YOU DO NOT NEED TO IMPLEMENT THIS CONSTRUCTOR!
     *
     */
    public BinarySearchTree() {
        size = 0;
    }

    /**
     * Initializes the BST with the data in the Collection. The data in the BST
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public BinarySearchTree(Collection<T> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Empty Collection used or null");
        }
        for (T i : data) {
            if (data == null) {
                throw new IllegalArgumentException("Data value in your collection");
            }
            add(i);
        }
    }

    @Override
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null data value");
        }
        Node<T> newNode = new Node<>(data);
        if (size != 0) {
            addNewNode(newNode, root);
            return;
        }
        root = newNode;
        size++;
    }

    /**
     * Compares the data value in the new node with an existing node in the tree
     * . Performs recursive comparison the value of the new node with the
     * existing nodes in the tree. If the value of the new node is less, then
     * the comparison goes to the left child. if the value of the new node is
     * more, then the comparison goes to the right child. It is added when null
     * leaf node is reached.
     * @param newNode the new node to be added
     * @param existingNode the existing node in the tree
     */
    private void addNewNode(Node<T> newNode, Node<T> existingNode) {
        int comp = newNode.getData().compareTo(existingNode.getData());
        if (comp < 0) {
            if (existingNode.getLeft() != null) {
                addNewNode(newNode, existingNode.getLeft());
                return;
            }
            existingNode.setLeft(newNode);
            size++;
        } else if (comp > 0) {
            if (existingNode.getRight() != null) {
                addNewNode(newNode, existingNode.getRight());
                return;
            }
            existingNode.setRight(newNode);
            size++;
        }
    }
    
    @Override
    public T get(T data) {
        Node<T> nodeLocator = findData(data, root);
        if (nodeLocator == null) {
            throw new java.util.NoSuchElementException("Data is not found");
        }
        return nodeLocator.getData();
    }
    
    /**
     *
     * @param data The data value to be checked for existence in the tree.
     * @param nodeLocator The node location where the value is located
     * @return The location of the node that is found or null if not found
     */
    private Node<T> findData(T data, Node<T> nodeLocator) {
        if (data == null) {
            throw new IllegalArgumentException("Null data value");
        }
        
        if (nodeLocator == null) {
            return null;
        }
        
        int comp = data.compareTo(nodeLocator.getData());
        if (comp < 0) {
            return findData(data, nodeLocator.getLeft());
        }
        
        if (comp > 0) {
            return findData(data, nodeLocator.getRight());
        }
        return nodeLocator;
    }

    @Override
    public boolean contains(T data) {
        return (findData(data, root) == null) ? false : true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<T> preorder() {
        List<T> lst = new ArrayList<>();
        preOrderHelper(this.root, lst);
        return lst;
    }

    /**
     *
     * @param node The next node to be traversed on the binary tree
     * @param lst The list containing the traversal results
     * @return The Pre-order in list data structure
     */
    private void preOrderHelper(Node<T> node, List<T> lst) {
        if (node == null) {
            return;
        }
        lst.add(node.getData());
        preOrderHelper(node.getLeft(), lst);
        preOrderHelper(node.getRight(), lst);
    }

    @Override
    public List<T> postorder() {
        List<T> lst = new java.util.ArrayList<>();
        postOrderHelper(root, lst);
        return lst;
    }

    /**
     *
     * @param node The next node to be traversed on the binary tree
     * @param lst The list containing the traversal results
     * @return The Post-order in List Data Sturacture
     */
    private void postOrderHelper(Node<T> node, List<T> lst) {
        if (node == null) {
          return;
        }
        postOrderHelper(node.getLeft(), lst);
        postOrderHelper(node.getRight(), lst);
        lst.add(node.getData());
    }

    @Override
    public List<T> inorder() {
        List<T> lst = new java.util.ArrayList<>();
        inorderHelper(root, lst);
        return lst;
    }

    /**
     *
     * @param node The next node to be traversed on the binary tree
     * @param lst The list containing the traversal results
     * @return the inorder traversal inside List data structure
     */
    private void inorderHelper(Node<T> node, List<T> lst) {
        if (node == null) {
            return;
        }
        inorderHelper(node.getLeft(), lst);
        lst.add(node.getData());
        inorderHelper(node.getRight(), lst);
    }

    @Override
    public List<T> levelorder() {
        List<T> lst = new java.util.ArrayList<>();
        if (size == 0) {
            return lst;
        }
        Queue<Node<T>> qq = new LinkedList<>();
        qq.add(root);
        while (!qq.isEmpty()) {
            Node<T> level = qq.poll();
            lst.add(level.getData());
            if (level.getLeft() != null) {
                qq.add(level.getLeft());
            }
            if (level.getRight() != null) {
                qq.add(level.getRight());
            }
        }
        return lst;
    }
    

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public int height() {
        if (size == 0) {
            return -1;
        }
        return heightHelper(root);
    }

    /**
     *
     * @param start the starting node which is the root
     * @return The height of the root node
     */
    private int heightHelper(Node<T> start) {
        int right;
        int left;
        if (start == null) {
            return -1;
        }
        right = heightHelper(start.getRight());
        left = heightHelper(start.getLeft());
        return Math.max(right + 1, left + 1);
    }

    @Override
    public Node<T> getRoot() {
        return root;
    }
    
    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null data value is used");
        }
        return getRemovedData(data, root, root, false);
    }
    
    /**
     *
     * @param data the data value to be removed
     * @param parent the parent node of the node to be removed
     * @param current the node value to be removed
     * @return the parent node of the node to be removed.
     */
    private T getRemovedData(T data, Node<T> parent, Node<T> current, boolean isLeft) {
        if (current == null) {
            throw new NoSuchElementException("Data value not found");
        }
        int comp = data.compareTo(current.getData());
        if (comp == 0) {
            T val = current.getData();
            if (current.getRight() == null && current.getLeft() == null) {
                if (current == root) {
                    root = null;
                } else if (isLeft) {
                    parent.setLeft(current.getLeft());
                } else {
                    parent.setRight(current.getRight());
                }
            } else if (current.getLeft() == null) {
                if (current == root) {
                    root = null;
                } else if (isLeft) {
                    parent.setLeft(current.getRight());
                } else {
                    parent.setRight(current.getRight());
                }
            } else if (current.getRight() == null) {
                if (current == root) {
                    root = null;
                } else if (isLeft) {
                    parent.setLeft(current.getLeft());
                } else {
                    parent.setRight(current.getLeft());
                }
            } else {
                Node<T> successorParent = current;
                Node<T> successor = current.getRight();
                while (successor.getLeft() != null) {
                    successorParent = successor;
                    successor = successor.getLeft();
                }
                current.setData(successor.getData());
                if (successorParent.equals(current)) {
                    successorParent.setRight(successor.getRight());
                } else {
                    successorParent.setLeft(successor.getRight());
                }
            }
            size--;
            return val;
        } else if (comp > 0) {
            return getRemovedData(data, current, current.getRight(), false);
        } else {
            return getRemovedData(data, current, current.getLeft(), true);
        }
    }
}
