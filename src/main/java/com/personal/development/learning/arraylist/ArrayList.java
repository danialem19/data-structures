package com.personal.development.learning.arraylist;

/**
 * Implementation of an ArrayList.
 *
 * @author DANIEL TADESSE
 */
public class ArrayList<T> {
    private T[] backingArray;
    private int size;
    private int INITIAL_CAPACITY = 10;


    public ArrayList() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }
    
    private void increaseBackingArray() {
        if (size == backingArray.length) {
            T[] newArray = (T[]) new Object[2 * backingArray.length];
            for (int i = 0; i < backingArray.length; i++) {
                newArray[i] = backingArray[i];
            }
            backingArray = newArray;
        }
    }

    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("ERROR due to index < 0 or index > size.");
        }
        if (data == null) {
            throw new IllegalArgumentException("ERROR: Data value cannot be Empty/Null");
        }
        increaseBackingArray();
        for (int i = size; i > index; i--) {
            backingArray[i] = backingArray[i - 1];
        }
        backingArray[index] = data;
        size++;
    }


    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("ERROR: Data value cannot be Empty/Null");
        }
        increaseBackingArray();
        for (int i = size; i > 0; i--) {
            backingArray[i] = backingArray[i - 1];
        }
        backingArray[0] = data;
        size++;
    }


    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("ERROR: Data value cannot be Empty/Null");
        }
        increaseBackingArray();
        backingArray[size] = data;
        size++;
    }


    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("ERROR due to index < 0 or index >= size.");
        }
        T theRemoved = backingArray[index];
        if (index != size - 1) {
            for (int i = index; i < size - 1; i++) {
                    backingArray[i] = backingArray[i + 1];
            }
        }
        backingArray[size - 1] = null;
        size--;
        return theRemoved;
    }


    public T removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        T theRemoved = backingArray[0];
        for (int i = 1; i < size; i++) {
            backingArray[i - 1] = backingArray[i];
        }
        backingArray[size - 1] = null;
        size--;
        return theRemoved;
    }


    public T removeFromBack() {
        if (isEmpty()) {
            return null;
        }
        T theRemoved = backingArray[size - 1];
        backingArray[size - 1] = null;
        size--;
        return  theRemoved;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("ERROR due to index < 0 or index >= size.");
        }
        return backingArray[index];
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public void clear() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }


    public Object[] getBackingArray() {
        return backingArray;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result = result + ",";
            }
            T item = backingArray[i];
            result = result + item;
        }
        result = result + "]";
        return result;
    }
}
