package com.ananth;


public class BinaryTreePostOrder {
	
	
	public static boolean isBTPostOrder(int[] input){
		
		
		
		
		return checkPostOrder(input,0,input.length-1);
	}
	
	
	public static boolean checkPostOrder(int[] in, int from , int to){
		
		
		if(from==to  || to == from+1){
			//System.out.println("Returning:" + true + "for from::to"+ from +"::"+ to);
			return true;
		}
		
		int root = in[to];
		
		int leftTo =-1;
		
		
		
		for(int i=from;i<=to-1;i++){
		
			if(in[i] < root){
				continue;
			}else{
				leftTo=i;
				break;
			}
		 
		}
		
		if(leftTo!=-1){
			for(int i=leftTo+1;i<to-1;i++){
				if(in[i] > root){
					continue;
				}else{
					//System.out.println("Returning:" + false + "for from::to"+ from +"::"+ to);
					return false;
				}
			}
		}
		
		
		boolean valid = false;
		
		if(leftTo!=-1){
			 valid =  checkPostOrder(in, from, leftTo-1) && checkPostOrder(in, leftTo, to-1);
		}else{
			valid = checkPostOrder(in, from, to-1);
		}
		
		
		
		//System.out.println("Returning:" + valid + "for from::to"+ from +"::"+ to);
		
		return valid;
	
	}
	
	public static void main(String[] args) {
		System.out.println(isBTPostOrder(new int[]{2,1,4,3,6,7,9,5}));
	}

}
