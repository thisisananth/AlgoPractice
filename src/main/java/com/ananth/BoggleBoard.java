package com.ananth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a dictionary, a method to do lookup in dictionary 
 * and a M x N board where every cell has one character. 
 * Find all possible words that can be formed by a sequence of adjacent characters
 * Note that we can move to any of 8 adjacent characters, 
 * but a word should not have multiple instances of same cell.
 */
public class BoggleBoard {
	
	private TrieNode root = null;
	
	
	public  List<String> findPossibleWords(Character[][] board,Set<String> dict){
		
		root = buildTrie(dict);
		
		List<String> out  = new ArrayList<String>();
		Set<List<Integer>> visited = new HashSet<List<Integer>>();
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				 
				StringBuilder sb = new StringBuilder();
				
				List<Integer> key = Collections.unmodifiableList(Arrays.asList(i,j));
				sb.append(board[i][j]);
				visited.add(key);
				dfs(board,dict,out,i,j,visited,sb);
				
				visited.remove(key);
			}
		}
	  
		
		return out;
	}
	
	
	public  void dfs(Character[][] board,Set<String> dict, List<String> out,int row, int col,
			Set<List<Integer>> visited,StringBuilder sb){
		
		   for(int i=-1;i<=1;i++){
			   int r = row+i;
			   for(int j=-1;j<=1;j++){
				   int c = col+j;
				   
				    if(i==0 && j==0){
				    	continue;
				    }else if(r>=0 && r<board.length && c>=0 && c<board[0].length){
				    	if(!visited.contains(Collections.unmodifiableList(Arrays.asList(r,c)))){
				    		sb.append(board[r][c]);
				    		
				    		if(isValidString(sb, root)){
				    			String word = sb.toString();
				    			if(dict.contains(word)){
				    				out.add(word);
				    			}
				    			
				    			List<Integer> key = Collections.unmodifiableList(Arrays.asList(r,c));
					    		visited.add(key);
					    		dfs(board,dict,out,r,c,visited,sb);
					    		visited.remove(key);
				    		}
				    		
				    		sb.deleteCharAt(sb.length()-1);
				    		
				    		
				    	}
				    }
				   
			   }
		   }
		
		
		
		
	}
	
    
	
	public static TrieNode buildTrie(Set<String> dict){
		
		TrieNode root = new TrieNode();
		
		
		
		for(String s:dict){
			
			TrieNode child = root;
			
			for(int i=0;i<s.length();i++){
				
				char c = s.charAt(i);
				
				int trieIndex = c -'A';
				
				TrieNode[] children = child.children;
				
				if(children[trieIndex]==null){
					child.childCount++;
					child = new TrieNode();
					
					children[trieIndex ] = child;
				}else{
					child = children[trieIndex];
					
				}
					
				
			}
			
		}
		
		return root;
		
	}
	
	public  boolean isValidString(StringBuilder sb,TrieNode root){
		
		System.out.println("checking"+sb.toString());
		
		TrieNode trie = root;
		int i=0;
		
		while(i<sb.length()){
			char c = sb.charAt(i);
			
			if(trie!=null && trie.childCount>0){
				trie = trie.children[c-'A'];
				if(trie==null){
					return false;
				}
				i++;
			}else{
				return false;
			}
				
			
		}
		
		return true;
		
	}
	

	
	
	

}
