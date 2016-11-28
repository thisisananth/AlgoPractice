package com.ananth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ananth.BST2DLL.TreeNode;

public class BST2DLLTest {
	
	

	@Before
	public void setUp() throws Exception {
		
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testLeftSubtree(){
		
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(3);
		root.setLeft(left);
		TreeNode l1 = new TreeNode(1);
		left.setLeft(l1);
		TreeNode r = new TreeNode(2);
		l1.setRight(r);
		
		TreeNode conv = BST2DLL.convertTreeToDoublyLinkedList(root);
		
		List<Integer> order = new ArrayList<Integer>();
		
		while(conv!=null){
			order.add(conv.getData());
			conv = conv.getRight();
		}
		
		System.out.println(order);
		
		assertTrue(order.equals(Arrays.asList(1,2,3,5)));
		
		
		
	}

}
