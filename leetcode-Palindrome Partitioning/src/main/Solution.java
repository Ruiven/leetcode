package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static boolean isPalindrome(String s) {
        if(s == null)
        	return false;
        if(s.length() == 0)
        	return true;
        
        int p = 0, q = s.length()-1;
        while(p < q) {
        	if(s.charAt(p) != s.charAt(q))
        		return false;
        	p++;
        	q--;
        }
        return true;
    }
	
	
	public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0)
			return res;
        List<String> sol = new ArrayList<>();
        backtrack(s, res, sol);
        return res;
        
    }
	
	static void backtrack(String left, List<List<String>> res, List<String> sol) {
		if(left == null || left.length() == 0) {
			res.add(new ArrayList<String>(sol));
			return;
		}
			
		for(int i = 0 ; i < left.length(); i++) {
			if(isPalindrome(left.substring(0, i+1))) {
				sol.add(left.substring(0, i+1));
				backtrack(left.substring(i+1), res, sol);
				sol.remove(sol.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		List<List<String>> res = partition("aab");
		for(int i = 0; i < res.size(); i++) {
			for(int j = 0 ; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) + ",");
			}
			System.out.print("\n");
		}
	}
}
