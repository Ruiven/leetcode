package main;

import javax.xml.stream.events.StartDocument;



public class Solution {
	public static boolean isMatch(String s, String p) {
		int spos = 0, ppos = 0;
		int lastStar = -1, lastStarMatch = -1;
		
		while(spos < s.length()) {
			if (ppos < p.length() && (s.charAt(spos) == p.charAt(ppos) || p.charAt(ppos) == '?')) {
				spos++;
				ppos++;
			}
			
			else if(ppos < p.length() && p.charAt(ppos) == '*') {
				lastStar = ppos;
				ppos++;
				lastStarMatch = spos;
			}
			
			else if(lastStar != -1) {
				ppos = lastStar + 1;
				lastStarMatch++;
				spos = lastStarMatch;
			}
			
			else
				return false;
		}
		
		while(ppos < p.length() && p.charAt(ppos) == '*')
			ppos++;
		
		return p.length() == ppos;
    }
	
	
	
	
	
	//TLE-recursion
	static boolean dp(String s, String p, int spos, int ppos) {
		if(p.length() == ppos)
			return s.length() == spos;
		
		if(p.charAt(ppos) != '*') {
			if(s.length() == spos)
				return false;
			
			
			if(p.charAt(ppos) == '?' || p.charAt(ppos) == s.charAt(spos))
				return dp(s, p, spos+1, ppos+1);
			
			else return false;
			
			
		}
		
		else {
		
			while(ppos < p.length() && p.charAt(ppos) == '*')
				ppos++;
			
			if(p.length() == ppos)
				return true;
			
			ppos--;
			
			while(s.length() > spos ) {
				
				
				
				if(dp(s, p, spos, ppos+1))
					return true;
				spos++;
			}
			
			return dp(s, p, spos, ppos+1);
					
		}
		
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a*"));
	}
}
