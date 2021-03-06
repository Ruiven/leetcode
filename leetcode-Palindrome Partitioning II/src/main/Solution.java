package main;

public class Solution {
	
	public static int minCut(String s) {
		
		int cut[] = new int[s.length()+1];
		
		for(int i = 0 ; i <= s.length(); i++)
			cut[i] = i-1;
		
		for(int i = 0 ; i < s.length(); i++) {
			for(int j = 0 ; i-j >= 0 && i+j < s.length() && s.charAt(i-j) == s.charAt(i+j); j++) {
				cut[i+j+1] = Math.min(cut[i+j+1], cut[i-j]+1);
			}
			for (int j = 1; i-j+1 >= 0 && i+j < s.length() && s.charAt(i-j+1) == s.charAt(i+j); j++) // even length palindrome
                cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j+1]);

		}
		return cut[s.length()];
    }
	
	public static void main(String[] args) {
		System.out.print(minCut("cdd"));
	}
}
