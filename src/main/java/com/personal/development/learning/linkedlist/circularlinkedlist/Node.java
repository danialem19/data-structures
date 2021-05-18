package com.personal.development.learning.linkedlist.circularlinkedlist;

/**
 * Singly linked node, which stores a reference to its element and
 * to the subsequent node in the list.
 */
class Node<E> {
	private E element;
	
	private Node<E> next;
	
	public Node(E e, Node<E> n) {
		element = e;
		next = n;
	}
	
	public E getElement() {
		return element;
	}
	
	public Node<E> getNext() {
		return next;
	}
	
	public void setNext(Node<E> n) {
		next = n;
	}
}
