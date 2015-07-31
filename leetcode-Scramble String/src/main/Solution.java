package main;

public class Solution {
	public static boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		boolean scramble[][][] = new boolean[s1.length()][s1.length()][s1.length()+1];
		
		for(int i = 0 ; i < s1.length(); i++) {
			for(int j = 0 ; j < s2.length(); j++) {
				scramble[i][j][1] = s1.charAt(i) == s2.charAt(j);
			}
		}
		
		for(int len = 2; len <= s1.length(); len++) {
			for(int i = 0 ; i+len <= s1.length(); i++) {
				for(int j = 0 ; j + len <= s2.length(); j++) {
					for(int k = 1; k < len; k++) {
						scramble[i][j][len] |= scramble[i][j][k] && scramble[i+k][j+k][len-k] || scramble[i][j+len-k][k] && scramble[i+k][j][len-k];
					}
					
				}
			}
		}
		return scramble[0][0][s1.length()];
	}
	
	public static void main(String[] args) {
		System.out.print(isScramble("rgtae", "great"));
	}
}
