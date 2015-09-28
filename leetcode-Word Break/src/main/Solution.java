package main;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static boolean wordBreak(String s, Set<String> wordDict) {
        
		if(s == null)
			return false;
		if(s.length() == 0 && wordDict.size() == 0)
			return true;
		
		
		boolean res[] = new boolean[s.length()+1]; 
		res[0] = true;
		
		for(int i = 0 ; i <= s.length(); i++) {	//for each substring
			for(int j = 0; j < i; j++) {
				if(res[j] && wordDict.contains(s.substring(j, i))) {
					res[i] = true;
					break;
				}
			}
		}
				
		return res[s.length()];
		
    }
	
	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<>();
		//wordDict.add("leet");
		//wordDict.add("code");
		//wordDict.add("cosde");
		System.out.print(wordBreak("leetcosde", wordDict));
	}
}
