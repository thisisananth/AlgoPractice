package com.ananth;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoggleBoardTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testFindPossibleWords() {
		BoggleBoard bb = new BoggleBoard();
		
		Character[][] board = new Character[][]{{'G','I','Z'},{'U','E','K'},{'Q','S','E'}};
		
		Set<String> dict = new HashSet<String>();
		
		dict.add("GEEKS");
		dict.add("FOR");
		dict.add("QUIZ");
		dict.add("GO");
		
		
		
	List<String> out =	bb.findPossibleWords(board,dict);
	System.out.println(out);
	
	org.junit.Assert.assertTrue("Expected 2 actual:",out.size()==2);
	
	}
	@Test
	public final void testBuildTrie(){
		BoggleBoard bb = new BoggleBoard();
Set<String> dict = new HashSet<String>();
		
		dict.add("GEEKS");
		dict.add("FOR");
		dict.add("QUIZ");
		dict.add("GO");
		
		TrieNode t = bb.buildTrie(dict);
		
		assertTrue(bb.isValidString(new StringBuilder("GEEKSU"), t)==false);
		
	}
}
