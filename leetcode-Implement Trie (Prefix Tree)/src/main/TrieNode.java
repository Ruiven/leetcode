package main;

import java.util.LinkedList;
import java.util.List;

public class TrieNode {
	
	//public char c;
	public boolean isLeaf;
	public TrieNode childrenList[];
	
	public TrieNode() {
		//c = ' ';
		isLeaf = false;
		childrenList = new TrieNode[26];		
	}

}
