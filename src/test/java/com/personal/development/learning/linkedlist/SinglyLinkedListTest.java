package com.personal.development.learning.linkedlist;

import com.personal.development.learning.linkedlist.singlylinkedlist.SinglyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {
	@Test
	public void addToFrontTest() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.addToFront(3);
		assertEquals(3, (int)singlyLinkedList.get(0));
		assertEquals(2, (int)singlyLinkedList.get(1));
	}
	
	@Test
	public void addToBackTest() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToBack(2);
		singlyLinkedList.addToBack(3);
		assertEquals(2, (int)singlyLinkedList.get(0));
		assertEquals(3, (int)singlyLinkedList.get(1));
	}
	
	@Test
	public void addAtIndexTest() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.addToFront(3);
		singlyLinkedList.addAtIndex(1, 0);
		assertEquals(3, (int)singlyLinkedList.get(0));
		assertEquals(0, (int)singlyLinkedList.get(1));
		assertEquals(2, (int)singlyLinkedList.get(2));
	}
	
	@Test
	public void addAtIndexAfterLastElementTest() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.addToFront(3);
		singlyLinkedList.addAtIndex(2, 0);
		assertEquals(3, (int)singlyLinkedList.get(0));
		assertEquals(2, (int)singlyLinkedList.get(1));
		assertEquals(0, (int)singlyLinkedList.get(2));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void addAtNegativeIndexIndexOutOfBoundsExceptionTest() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.addToFront(3);
		singlyLinkedList.addAtIndex(-1, 0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void addAtPosetiveIndexIndexOutOfBoundsExceptionTest() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.addToFront(3);
		singlyLinkedList.addAtIndex(3, 0);
	}
	
	@Test
	public void removeFromFrontOneElement() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.removeFromFront();
		assertEquals(0, singlyLinkedList.size());
		assertEquals(null, singlyLinkedList.getHead());
		assertEquals(null, singlyLinkedList.getTail());
	}
	
	@Test
	public void removeFromFrontTwoElement() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.addToFront(3);
		singlyLinkedList.removeFromFront();
		assertEquals(1, singlyLinkedList.size());
		assertEquals(2, (int)singlyLinkedList.getHead().getData());
		assertEquals(2, (int)singlyLinkedList.getTail().getData());
	}
	
	@Test
	public void removeFromBackOneElement() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.removeFromBack();
		assertEquals(0, singlyLinkedList.size());
		assertEquals(null, singlyLinkedList.getHead());
		assertEquals(null, singlyLinkedList.getTail());
	}
	
	@Test
	public void removeFromBackTwoElement() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.addToFront(3);
		singlyLinkedList.removeFromBack();
		assertEquals(1, singlyLinkedList.size());
		assertEquals(3, (int)singlyLinkedList.getHead().getData());
		assertEquals(3, (int)singlyLinkedList.getTail().getData());
	}
	
	@Test
	public void removeAtIndexFront() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.addToFront(3);
		singlyLinkedList.removeAtIndex(0);
		assertEquals(1, singlyLinkedList.size());
		assertEquals(2, (int)singlyLinkedList.getHead().getData());
		assertEquals(2, (int)singlyLinkedList.getTail().getData());
	}
	
	@Test
	public void removeAtIndexFrontOneElement() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.removeAtIndex(0);
		assertEquals(0, singlyLinkedList.size());
		assertEquals(null, singlyLinkedList.getHead());
		assertEquals(null, singlyLinkedList.getTail());
	}
	
	@Test
	public void removeAtIndexMultipleElement() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.addToFront(4);
		singlyLinkedList.addToFront(3);
		singlyLinkedList.addToFront(5);
		singlyLinkedList.removeAtIndex(2);
		assertEquals(3, singlyLinkedList.size());
		assertEquals(5, (int)singlyLinkedList.getHead().getData());
		assertEquals(2, (int)singlyLinkedList.getTail().getData());
	}
	
	@Test
	public void removeFirstOccurrenceBackElement() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.addToFront(4);
		singlyLinkedList.addToFront(3);
		singlyLinkedList.addToFront(5);
		singlyLinkedList.removeFirstOccurrence(2);
		assertEquals(3, singlyLinkedList.size());
		assertEquals(5, (int)singlyLinkedList.getHead().getData());
		assertEquals(4, (int)singlyLinkedList.getTail().getData());
	}
	
	@Test
	public void removeFirstOccurrenceFrontElement() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.addToFront(4);
		singlyLinkedList.addToFront(3);
		singlyLinkedList.addToFront(5);
		singlyLinkedList.removeFirstOccurrence(5);
		assertEquals(3, singlyLinkedList.size());
		assertEquals(3, (int)singlyLinkedList.getHead().getData());
		assertEquals(2, (int)singlyLinkedList.getTail().getData());
	}
	
	@Test
	public void removeFirstOccurrenceMiddleElement() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.addToFront(2);
		singlyLinkedList.addToFront(4);
		singlyLinkedList.addToFront(3);
		singlyLinkedList.addToFront(5);
		singlyLinkedList.removeFirstOccurrence(4);
		assertEquals(3, singlyLinkedList.size());
		assertEquals(5, (int)singlyLinkedList.getHead().getData());
		assertEquals(2, (int)singlyLinkedList.getTail().getData());
	}
	
	@Test
	public void singlyLinkedListInitializedWithData() {
		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList(2);
		singlyLinkedList.addToFront(4);
		singlyLinkedList.addToFront(3);
		singlyLinkedList.addToFront(5);
		singlyLinkedList.removeFirstOccurrence(4);
		assertEquals(3, singlyLinkedList.size());
		assertEquals(5, (int)singlyLinkedList.getHead().getData());
		assertEquals(2, (int)singlyLinkedList.getTail().getData());
	}
	
}