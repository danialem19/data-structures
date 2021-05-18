package com.personal.development.learning.linkedlist.singlylinkedlist;

/**
 * Node of a Singly linked list, which stores a reference to its
 * element and to next node in the list.
 */
public class Node<T> {
    private T data;
    private Node<T> next;
    
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
    
    public Node(T data) {
        this(data, null);
    }
    
    public T getData() {
        return data;
    }
    
    public Node<T> getNext() {
        return next;
    }
    
    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node containing: " + data;
    }
}
