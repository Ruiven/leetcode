package main;

public class Solution {
	public static int lengthOfLongestSubstring(String s) {		
		int maxLength = 0;
		int backMaxLength = 0;
		String backMaxString = "";		
		for(int i = 0; i < s.length(); i++) {
			int res = hasAppeared(backMaxString, s.charAt(i));
			if(res == -1) {
				maxLength = max(maxLength, backMaxLength+1);				
				backMaxString = s.substring(i-backMaxLength, i+1);
				backMaxLength++;
			}
			
			else {
				//res = 0;
				backMaxLength = 1 + res;
				backMaxString = s.substring(i - res, i+1);
			}			
		}
		
		return maxLength;
		
	}
	
	public static int hasAppeared(String s, char a) {
		for(int i = 0 ; i < s.length(); i++)
			if(s.charAt(i) == a) 
				return s.length() - i - 1;
		return -1;
	}
	
	public static int max(int a, int b) {
		return a>b ? a : b;
	}
	
	public static void main(String[] args) {
		
		String testString = "aa";
		int a = lengthOfLongestSubstring(testString);
		System.out.println(a);
		
	}

}
