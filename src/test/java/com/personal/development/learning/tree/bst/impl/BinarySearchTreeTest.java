package com.personal.development.learning.tree.bst.impl;

import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
	
	@Test
	public void addTest() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		
		assertEquals(10, binarySearchTree.getRoot().getData().intValue());
		assertEquals(4,  binarySearchTree.getRoot().getLeft().getData().intValue());
		assertEquals(20,  binarySearchTree.getRoot().getRight().getData().intValue());
		assertEquals(5, binarySearchTree.size());
	}
	
	@Test
	public void getTestShouldReturnTheValue() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		
		assertEquals(10, binarySearchTree.get(10).intValue());
		assertEquals(4, binarySearchTree.get(4).intValue());
		assertEquals(20, binarySearchTree.get(20).intValue());
		assertEquals(5, binarySearchTree.get(5).intValue());
		assertEquals(11, binarySearchTree.get(11).intValue());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void getTestShouldThrowException() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		binarySearchTree.get(100).intValue();
	}
	
	@Test
	public void containsTestShouldReturnTrue() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		assertTrue(binarySearchTree.contains(10));
		assertTrue(binarySearchTree.contains(4));
		assertTrue(binarySearchTree.contains(20));
		assertTrue(binarySearchTree.contains(5));
		assertTrue(binarySearchTree.contains(11));
	}
	
	@Test
	public void containsTestShouldFalse() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		assertFalse(binarySearchTree.contains(100));
	}
	
	@Test
	public void preOrderTest() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		binarySearchTree.add(25);
		List<Integer> preOrder = binarySearchTree.preorder();
		assertEquals(10, preOrder.get(0).intValue());
		assertEquals(4, preOrder.get(1).intValue());
		assertEquals(5, preOrder.get(2).intValue());
		assertEquals(20, preOrder.get(3).intValue());
		assertEquals(11, preOrder.get(4).intValue());
		assertEquals(25, preOrder.get(5).intValue());
	}
	
	@Test
	public void postOrderTest() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		binarySearchTree.add(25);
		List<Integer> preOrder = binarySearchTree.postorder();
		assertEquals(5, preOrder.get(0).intValue());
		assertEquals(4, preOrder.get(1).intValue());
		assertEquals(11, preOrder.get(2).intValue());
		assertEquals(25, preOrder.get(3).intValue());
		assertEquals(20, preOrder.get(4).intValue());
		assertEquals(10, preOrder.get(5).intValue());
	}
	
	@Test
	public void inOrderTest() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		binarySearchTree.add(25);
		List<Integer> preOrder = binarySearchTree.inorder();
		assertEquals(4, preOrder.get(0).intValue());
		assertEquals(5, preOrder.get(1).intValue());
		assertEquals(10, preOrder.get(2).intValue());
		assertEquals(11, preOrder.get(3).intValue());
		assertEquals(20, preOrder.get(4).intValue());
		assertEquals(25, preOrder.get(5).intValue());
	}
	
	@Test
	public void levelOrderTest() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		binarySearchTree.add(25);
		List<Integer> preOrder = binarySearchTree.levelorder();
		assertEquals(10, preOrder.get(0).intValue());
		assertEquals(4, preOrder.get(1).intValue());
		assertEquals(20, preOrder.get(2).intValue());
		assertEquals(5, preOrder.get(3).intValue());
		assertEquals(11, preOrder.get(4).intValue());
		assertEquals(25, preOrder.get(5).intValue());
	}
	
	@Test
	public void heightTest() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		binarySearchTree.add(25);
		binarySearchTree.add(30);
		assertEquals(3, binarySearchTree.height());
	}
	
	@Test
	public void heightTestShouldReturnZero() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		assertEquals(0, binarySearchTree.height());
	}
	
	@Test
	public void removeShouldRemoveLeafeTest() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		binarySearchTree.add(25);
		int remove = binarySearchTree.remove(5);
		List<Integer> preOrder = binarySearchTree.inorder();
		assertEquals(5, remove);
		assertEquals(4, preOrder.get(0).intValue());
		assertEquals(10, preOrder.get(1).intValue());
		assertEquals(11, preOrder.get(2).intValue());
		assertEquals(20, preOrder.get(3).intValue());
		assertEquals(25, preOrder.get(4).intValue());
	}
	
	@Test
	public void removeShouldRemoveHasOneChildTest() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		binarySearchTree.add(25);
		binarySearchTree.add(30);
		int remove = binarySearchTree.remove(25);
		List<Integer> preOrder = binarySearchTree.inorder();
		assertEquals(25, remove);
		assertEquals(4, preOrder.get(0).intValue());
		assertEquals(5, preOrder.get(1).intValue());
		assertEquals(10, preOrder.get(2).intValue());
		assertEquals(11, preOrder.get(3).intValue());
		assertEquals(20, preOrder.get(4).intValue());
		assertEquals(30, preOrder.get(5).intValue());
	}
	
	@Test
	public void removeShouldRemoveHasTwoChildTest() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		binarySearchTree.add(12);
		binarySearchTree.add(25);
		binarySearchTree.add(30);
		int remove = binarySearchTree.remove(10);
		List<Integer> preOrder = binarySearchTree.inorder();
		assertEquals(10, remove);
		assertEquals(4, preOrder.get(0).intValue());
		assertEquals(5, preOrder.get(1).intValue());
		assertEquals(11, preOrder.get(2).intValue());
		assertEquals(12, preOrder.get(3).intValue());
		assertEquals(20, preOrder.get(4).intValue());
		assertEquals(25, preOrder.get(5).intValue());
		assertEquals(30, preOrder.get(6).intValue());
	}
	
	@Test
	public void removeShouldRemoveHasOneChildRightTest() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.add(10);
		binarySearchTree.add(4);
		binarySearchTree.add(20);
		binarySearchTree.add(5);
		binarySearchTree.add(11);
		binarySearchTree.add(12);
		binarySearchTree.add(25);
		binarySearchTree.add(30);
		int remove = binarySearchTree.remove(11);
		List<Integer> preOrder = binarySearchTree.inorder();
		assertEquals(11, remove);
		assertEquals(4, preOrder.get(0).intValue());
		assertEquals(5, preOrder.get(1).intValue());
		assertEquals(10, preOrder.get(2).intValue());
		assertEquals(12, preOrder.get(3).intValue());
		assertEquals(20, preOrder.get(4).intValue());
		assertEquals(25, preOrder.get(5).intValue());
		assertEquals(30, preOrder.get(6).intValue());
	}
}