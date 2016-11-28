package com.ananth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinaryTreePathSums {
	
	
	public static void printPathWithSum(int sum,TreeNode root){
		
		
		printPathWithSum(root,sum,0,new ArrayList<BinaryTreePathSums.TreeNode>());
		
		
	}
	
	public static void printPathWithSum(TreeNode node,int sum,int current,List<TreeNode> nodes){
		
		current = current+node.data;
		
		
		if(current > sum ){
			
			//dont add this node and return  
			return;
		}else if(current < sum){
			nodes.add(node);
			
			if(node.left!=null){
				printPathWithSum(node.left,sum,current,nodes);	
			}
			
			
			if(node.right!=null){
				printPathWithSum(node.right, sum, current, nodes);
			}
			
			//add this node and continue;
			nodes.remove(node);
		}else{
			
			if(node.left==null && node.right==null){
				nodes.add(node);
				printPath(nodes);
				nodes.remove(node);
			}else{
				//reached sum before leaf, so not useful. 
				return;
			}
			
		}
	
		
		
	}
	

    
	
	
	
	public static int findMaxPathSum(TreeNode root){
	
		int maxSum =  maxPathSum(root, 0);
		
		System.out.println(maxSum);
		return maxSum;
		
	}
	
	
	public static int maxPathSum(TreeNode root,int max){
		
		
		if(root==null){
			return max;
		}else{
			
			max = maxPathSum(root.left, max);
			 
			 max = maxPathSum(root.right,max);
			 
			 int tempMax = root.data;
				
				if(root.left!=null){
					tempMax += root.left.rootSum;
				}
				
				if(root.right!=null){
					tempMax += root.right.rootSum;
				}
			
			max =	Math.max(max,tempMax);
			
			root.rootSum = Math.max(getPathSum(root.left)+root.data,getPathSum(root.right)+root.data);
			
			return max;
			
			
		}
		
		
		
	}
	
	public static int getPathSum(TreeNode root){
		
		if(root==null){
			return 0;
		}else{
			return root.rootSum;
		}
		
	}
	
	
	public static void printPath(List<TreeNode> nodes){
		for(TreeNode node:nodes){
			System.out.print(node.data);
		}
		
		System.out.println();
	}
	
	
	public static boolean isBinaryTree(TreeNode t,int min, int max){
		
		if(t==null){
			return true;
		}
		else{
		
		 if(t.data < min || t.data > max){
			 return false;
		 }
		 
		 
		 
		
		return 	isBinaryTree(t.left, min, t.data)
		
			&& isBinaryTree(t.right, t.data+1, max);
		
			
		}
		
		
	}
	
	
	public static Integer findClosest(TreeNode t, int val,Integer closest){
		
		
		
		if(t==null){
			return closest;
		}else{
			
			if(val==t.data){
				return val;
			}else{
			
				if(closest == null){
					closest = t.data;
					
				} else {

					closest = Math.abs(closest.intValue() - val) >
							Math.abs(t.data - val)  ? t.data:closest;

				}
				
				if(val < t.data){
					
					if (t.left == null) {

						return closest;

					} else {
						return findClosest(t.left, val, closest);

					}
				}else{
					
					if(t.right ==null){
						return closest;
					}else{
						return findClosest(t.right,val,closest);
					}
					
					
				}
			
				
				
				
				
			}
			
		}
		
	}
	
	
	public static boolean nodesWithSum(TreeNode root, int sum){
		
		List<Integer> list = new ArrayList<Integer>();
		getInOrder(root, list);
		
		boolean found = false;
		
		for(int i=0,j=list.size()-1;i<list.size() && j>i;){
			
			int first = list.get(i);
			
			int last = list.get(j);
			
			int currentSum = first + last;
			
			if(currentSum==sum){
				found = true;
				break;
			}else if(currentSum > sum){
				j--;
				
			}else{
				i++;
			}
			
			
		
			
			
		}
		
		
		
		
		return found;
	}
	
	
	public static void getInOrder(TreeNode root,List<Integer> out){
		
		if(root==null){
			return;
		}else{
			if(root.left!=null){
			   getInOrder(root.left, out);
			}
			
			out.add(root.data);
			
			if(root.right!=null){
				getInOrder(root.right, out);
			}
			
			
		}
		
		
	}
	
	
	
	
	static class TreeNode{
		
		int rootSum;
		
		int data;
		TreeNode left;
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

		TreeNode right;
		
		public TreeNode(int i){
			this.data = i;
		}
	}
	
	
	
}
