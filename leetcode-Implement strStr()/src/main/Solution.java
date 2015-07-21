package main;

public class Solution {
	public static int strStr(String haystack, String needle) {
		if(haystack.equals(needle))
			return 0;
		
        for(int i = 0; i < haystack.length(); i++) {
        	
        	if(i + needle.length() > haystack.length())
        		return -1;
        	
        	if(haystack.substring(i, i+ needle.length()).equals(needle))
        		return i;
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		System.out.print(strStr("", ""));
	
	}
}
