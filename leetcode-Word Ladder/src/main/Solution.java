package main;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
	static int minStep;
	public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		
		
		
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		
		int step = 1;
		int next = 1;
		int cur = 0;
		while(!queue.isEmpty() ) {
			String temp = queue.poll();
			
			next--;
			
			for(int i = 0 ; i < temp.length(); i++) {
				char[] tempCharArr = temp.toCharArray();
				for(char c = 'a'; c <= 'z' ; c++ ) {
					if(c == tempCharArr[i])
						continue;
					tempCharArr[i] = c;
					String changed = new String(tempCharArr);
					if(changed.equals(endWord))
						return step+1;
					
					if(wordDict.contains(changed) && !visited.contains(changed)) {
						queue.add(changed);
						cur++;
						visited.add(changed);
					}
				}
				System.out.print("");
			}
			if(next == 0) {
				next = cur;
				cur = 0;
				step++;
			}
			
		}
		return 0;
    }
	
	
	static boolean changeable(String word1, String word2) {	//Assume two words share same length
		int diff = 0;
		for(int i = 0 ; i < word1.length(); i++) {
			if(word1.charAt(i) != word2.charAt(i))
				diff++;
			if(diff > 1)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dot");
		dict.add("dog");
		dict.add("hit");
		dict.add("lot");
		dict.add("log");
		
		System.out.print(ladderLength("hit", "cog", dict));
	}
}
