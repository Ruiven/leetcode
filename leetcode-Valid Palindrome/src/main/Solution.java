package main;

public class Solution {
	public boolean isPalindrome(String s) {
        if(s == null)
        	return false;
        if(s.length() == 0)
        	return true;
        
        int p = 0, q = s.length()-1;
        s = s.toLowerCase();
        
        while(p < q) {
        	if(!(s.charAt(p) <= 'z' && s.charAt(p) >= 'a' || s.charAt(p) <= '9' && s.charAt(p) >= '0')) {
        		p++;
        		continue;
        	}
        	if(!(s.charAt(q) <= 'z' && s.charAt(q) >= 'a' || s.charAt(q) <= '9' && s.charAt(q) >= '0')) {
        		q--;
        		continue;
        	}
        		
        	if(s.charAt(p) != s.charAt(q))
        		return false;
        	
        	p++;
        	q--;
        }
        return true;
        
    }
}
