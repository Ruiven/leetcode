package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	
	public static boolean found = false;
	public static boolean used[][];
	public static Trie tree;
	//public static List<String> out;
	public static Set<String> out = new HashSet<>();
	
	
	
	public static List<String> findWords(char[][] board, String[] words) {
		//out = new ArrayList<String>();
		used = new boolean[board.length][board[0].length];
		tree = new Trie();
		for(String s : words) {
			tree.insert(s);
		}
		
		for(int i = 0; i < board.length; i++ )
			for(int j = 0 ; j < board[0].length; j++)
				used[i][j] = false;
		
		
		
		int pos[] = new int[2];
		for(int i = 0; i < board.length; i++ )
			for(int j = 0 ; j < board[0].length; j++) {
				pos[0] = i;
				pos[1] = j;
				backtrack("", board, pos);
			}
		
		
		
		return new ArrayList<String>(out);
	}
	
	
	
	public static void backtrack(String part, char[][] board, int[] pos ) {
		
		
		if(used[pos[0]][pos[1]])
			return;
		
		part = part + board[pos[0]][pos[1]];
		
		if(!tree.startsWith(part))
			return;
		
		used[pos[0]][pos[1]] = true;
		
			
		if(tree.search(part)) {
			out.add(part);
		}
			
		
		//up
		if(pos[0] != 0) {
			pos[0]--;
			backtrack(part, board, pos);
			pos[0]++;
		}
		
		if(found)
			return;
		
		//down
		if(pos[0] != board.length-1 ) {
			pos[0]++;
			
			backtrack(part, board, pos);
			
			pos[0]--;
		}
		
		if(found)
			return;
		
		//left
		if(pos[1] != 0 ) {
			pos[1]--;
			
			backtrack(part, board, pos);
			
			pos[1]++;
		}
		
		if(found)
			return;
		
		//right
		if(pos[1] != board[0].length-1) {
			pos[1]++;
			
			backtrack(part, board, pos);
			
			pos[1]--;
		}
		
		//not right
		used[pos[0]][pos[1]] = false;
		return; 
	}

	
	public static void main(String[] args) {
		char board[][] = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
		String[] words = {"oath", "pea", "eat", "rain"};
		System.out.println(findWords(board, words));
		//System.out.println(word.substring(0,word.length()-1));
	}
}
