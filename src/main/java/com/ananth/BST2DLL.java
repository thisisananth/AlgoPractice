package com.ananth;

import java.util.ArrayList;
import java.util.List;

public class BST2DLL {

	public static TreeNode convertTreeToDoublyLinkedList(TreeNode root) {

	
		TreeNode head = convertToLL(root);
		
		while(head.left!=null){
			head =head.left;
		}


		return head;

	}

	static TreeNode convertToLL(TreeNode node) {

		if (node == null) {
			return node;
		} else {

			if (node.left != null) {
				TreeNode left = convertToLL(node.left);
				for (; left.right != null; left = left.right)
					;

				left.right = node;

				node.left = left;

			}

			if (node.right != null) {
				TreeNode right = convertToLL(node.right);
				for (; right.left != null; right = right.left)
					;

				right.left = node;
				node.right = right;

			}

			return node;

		}

	}

	static class TreeNode {

		TreeNode(int in) {
			this.data = in;
		}

		private int data;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		private TreeNode left;
		private TreeNode right;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(3);
		root.setLeft(left);
		TreeNode l1 = new TreeNode(1);
		left.setLeft(l1);
		TreeNode r = new TreeNode(2);
		l1.setRight(r);

		TreeNode conv = BST2DLL.convertTreeToDoublyLinkedList(root);
		
	
		List<Integer> order = new ArrayList<Integer>();

		while (conv != null) {
			order.add(conv.getData());
			conv = conv.getRight();
		}

		System.out.println(order);
	}

}
