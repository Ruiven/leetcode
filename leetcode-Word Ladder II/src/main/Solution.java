package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordDict) {
		List<List<String>> res = new ArrayList<>();
		List<String> part = new ArrayList<>();
		part.add(beginWord);
		
		Set<String> visited = new HashSet<>();
				
		backtrack(beginWord, endWord, wordDict, visited, part, res);
		
		return res;
		
    }
	
	static void backtrack(String tempWord, String endWord, Set<String> wordDict, Set<String> visited, List<String> part, List<List<String>> res) {
		
		for(int i = 0; i < tempWord.length(); i++) {
			char[] tempCharArr = tempWord.toCharArray();
			for(char c = 'a'; c <= 'z' ; c++ ) {
				if(c == tempCharArr[i])
					continue;
				tempCharArr[i] = c;
				String changed = new String(tempCharArr);
				if(changed.equals(endWord)) {
					part.add(endWord);
					res.add(new ArrayList<String>(part));
					part.remove(part.size()-1);
					continue;
				}
				
				if(wordDict.contains(changed) && !visited.contains(changed)) {
					visited.add(changed);
					part.add(changed);
					backtrack(changed, endWord, wordDict, visited, part, res);
					part.remove(part.size()-1);
					visited.remove(changed);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<>();
		String[] strArr = {"hot","dot","dog","lot","log"};
		for(String s : strArr)
			wordDict.add(s);
		
		List<List<String>> res = findLadders("hit", "cog", wordDict);
		for(List<String> list : res) {
			for(String s : list)
				System.out.print(s);
			
			System.out.print("\n");
		}
		
	}
}
