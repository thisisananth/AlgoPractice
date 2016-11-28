package com.ananth;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ananth.BinaryTreePathSums.TreeNode;



public class BinaryTreePathSumsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testPrintPathWithSumIntTreeNode() {
		TreeNode root = new TreeNode(5);
		TreeNode one = new TreeNode(3);
		root.setLeft(one);
		
		TreeNode two = new TreeNode(7);
		root.setRight(two);
		
		
		TreeNode three = new TreeNode(1);
		one.setLeft(three);
		
		TreeNode four = new TreeNode(4);
		one.setRight(four);
		
		TreeNode five = new TreeNode(6);
		two.setLeft(five);
		
		TreeNode six = new TreeNode(9);
		two.setRight(six);
		
		TreeNode r = new TreeNode(21);
		six.setRight(r);	
		
		
		
		BinaryTreePathSums.printPathWithSum(27, root);
	
	}
	
	@Test
	public final void testIsBinaryTree() {
		TreeNode root = new TreeNode(5);
		TreeNode one = new TreeNode(3);
		root.setLeft(one);
		
		TreeNode two = new TreeNode(7);
		root.setRight(two);
		
		
		TreeNode three = new TreeNode(1);
		one.setLeft(three);
		
		TreeNode four = new TreeNode(4);
		one.setRight(four);
		
		TreeNode five = new TreeNode(6);
		two.setLeft(five);
		
		TreeNode six = new TreeNode(9);
		two.setRight(six);
		
		
	
		assertTrue(BinaryTreePathSums.isBinaryTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
		
	
	
	}
	
	@Test
	public final void testFindClosest(){

		TreeNode root = new TreeNode(5);
		TreeNode one = new TreeNode(3);
		root.setLeft(one);
		
		TreeNode two = new TreeNode(7);
		root.setRight(two);
		
		
		TreeNode three = new TreeNode(1);
		one.setLeft(three);
		
		TreeNode four = new TreeNode(4);
		one.setRight(four);
		
		TreeNode five = new TreeNode(6);
		two.setLeft(five);
		
		TreeNode six = new TreeNode(9);
		two.setRight(six);
		
		TreeNode r = new TreeNode(2);
		three.setRight(r);
	/*	
		TreeNode seven = new TreeNode(1);
		one.setLeft(seven);
		*/
		int closest = BinaryTreePathSums.findClosest(root, 8, null);
		System.out.println(closest);
		assertTrue(closest==7);
			
	}
	
	

	@Test
	public final void testNodesWithSum(){

		TreeNode root = new TreeNode(5);
		TreeNode one = new TreeNode(3);
		root.setLeft(one);
		
		TreeNode two = new TreeNode(7);
		root.setRight(two);
		
		
		TreeNode three = new TreeNode(1);
		one.setLeft(three);
		
		TreeNode four = new TreeNode(4);
		one.setRight(four);
		
		TreeNode five = new TreeNode(6);
		two.setLeft(five);
		
		TreeNode six = new TreeNode(9);
		two.setRight(six);
		
		TreeNode r = new TreeNode(2);
		three.setRight(r);
	/*	
		TreeNode seven = new TreeNode(1);
		one.setLeft(seven);
		*/
	
		assertTrue(BinaryTreePathSums.nodesWithSum(root, 10));
		
		assertTrue(BinaryTreePathSums.nodesWithSum(root, 16));
			
		assertFalse(BinaryTreePathSums.nodesWithSum(root, 2));
		
		assertFalse(BinaryTreePathSums.nodesWithSum(root, 17));
	}

	
	@Test
	public final void testMaxPathSum(){
		

		TreeNode root = new TreeNode(5);
		TreeNode one = new TreeNode(3);
		root.setLeft(one);
		
		TreeNode two = new TreeNode(7);
		root.setRight(two);
		
		
		TreeNode three = new TreeNode(1);
		one.setLeft(three);
		
		TreeNode four = new TreeNode(4);
		one.setRight(four);
		
		TreeNode five = new TreeNode(6);
		two.setLeft(five);
		
		TreeNode six = new TreeNode(9);
		two.setRight(six);
		
		TreeNode r = new TreeNode(21);
		six.setRight(r);
		
		TreeNode seven = new TreeNode(6);
		five.setLeft(seven);
		
		TreeNode eight = new TreeNode(7);
		seven.setLeft(eight);
		
		
		
		assertTrue(BinaryTreePathSums.findMaxPathSum(root)==56);
		assertFalse(BinaryTreePathSums.findMaxPathSum(root)==27);
	}
	

	
	
	
	
}
