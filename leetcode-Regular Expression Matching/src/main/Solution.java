package main;

public class Solution {
	
	
	public static boolean isMatch(String s, String p) {
        
		return dp(s, p, 0, 0);
		
		
    }
	
	public static boolean dp(String s, String pattern, int spos, int ppos) {
		
		if(pattern.length() == ppos) {
			
			return s.length() == spos;
		}
			
		
		if(pattern.length()-1 == ppos || pattern.charAt(ppos + 1) != '*') {
			if(s.length() == spos)
				return false;
			
			if(pattern.charAt(ppos) != '.' ) {	//two letters
				if( pattern.charAt(ppos) != s.charAt(spos)  )
					return false;
				else
					return dp(s, pattern, spos+1, ppos+1);
			}
			else
				return dp(s, pattern, spos+1, ppos+1);	//one dot, one letter
									
		}
				
		else {
			while(spos < s.length() && (pattern.charAt(ppos) == '.' || pattern.charAt(ppos) == s.charAt(spos))) {
				if(dp(s, pattern, spos, ppos+2))
					return true;
				spos++;
			}
			//if this letter does not exist
			return dp(s, pattern, spos, ppos+2);
			
		}
			
	}
	
	public static void main(String[] args) {
		String s = "";
		String p = "..ac";
		System.out.println(isMatch(s, p));
	}
}
