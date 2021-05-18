package com.personal.development.learning.linkedlist.singlylinkedlist;

/**
 * Implementation of a SinglyLinkedList
 *
 * @author DANIEL TADESSE
 */
public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public SinglyLinkedList () {
        head = new Node<>(null);
        tail = head;
        size = 0;
    }
    
    public SinglyLinkedList (T data) {
        head = new Node<>(data);
        tail = head;
        size = 1;
    }
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Error due to Null Data Value");
        }
        Node<T> newHead = new Node(data);
        if (isEmpty()) {
            head = newHead;
            tail = head;
        } else {
            newHead.setNext(head);
            head = newHead;
        }
        size++;
    }
    
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Error due to Null Data Value");
        }
        Node<T> newTail = new Node(data);
        if (isEmpty()) {
            head = newTail;
        } else {
            tail.setNext(newTail);
        }
        tail = newTail;
        size++;
    }
    
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is negative or index >= size");
        }
        if (data == null) {
            throw new IllegalArgumentException("Error due to Null Data Value");
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            addToFront(data);
        } else if (index == size) {
            addToBack(data);
        } else {
            Node<T> currentNode = head;
            Node<T> previousNode = null;
            for (int i = 0; i < index; i++) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            previousNode.setNext(newNode);
            newNode.setNext(currentNode);
            size++;
        }
       
    }
    
    public T removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        T removedData = head.getData();
        head = head.getNext();
        if (size == 1) {
            tail = head;
        }
        size--;
        return removedData;
    }
    
    public T removeFromBack() {
        if (isEmpty()) {
            return null;
        }
        Node<T> currentNode = head;
        Node<T> previousNode = null;
        while (currentNode.getNext() != null) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (size == 1) {
            head = null;
            tail = head;
        } else {
            tail = previousNode;
            previousNode.setNext(null);
        }
        size--;
        return currentNode.getData();
    }

    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is negative or index >= size");
        }
        if (isEmpty()) {
            return null;
        }
        Node<T> currentNode = head;
        Node<T> previousNode = null;
        for (int i = 0; i < index; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (index == 0) {
            return removeFromFront();
        } else if (index == size - 1) {
            return removeFromBack();
        } else {
            previousNode.setNext(currentNode.getNext());
            size--;
        }
        return currentNode.getData();
    }

    public T removeFirstOccurrence(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Error due to Null Data Value");
        }
        Node<T> currentNode = head;
        Node<T> previousNode = null;

        for (int i = 0; i < size; i++) {
            if (currentNode.getData().equals(data)) {
                if (i == 0) {
                    return removeFromFront();
                }
                if (i == size - 1) {
                     return removeFromBack();
                }
                previousNode.setNext(currentNode.getNext());
                size--;
                return currentNode.getData();
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        throw new java.util.NoSuchElementException("Data value is not found");
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is negative or index >= size");
        }
        if (index == 0) {
            return head.getData();
        }
        if (index == size - 1) {
            return tail.getData();
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }
    
    public Object[] toArray() {
        Node<T> position = head;
        Object[] myArray = new Object[size];
        for (int i = 0; i < size; i++) {
            myArray[i] = position.getData();
            position = position.getNext();
        }
        return myArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }

    public void clear() {
        if (size != 0) {
            head = null;
            tail = null;
            size = 0;
        }
    }
    
    public Node<T> getHead() {
        return head;
    }
    
    public Node<T> getTail() {
        return tail;
    }
    
    @Override
    public String toString() {
        Node<T> position = head;
        String string = "[";
        while (position != null) {
            string = string + position.getData();
            position = position.getNext();
        }
        string = string + "]";
        return string;
    }
}
