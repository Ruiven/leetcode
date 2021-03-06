package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<List<Integer>> combine(int n, int k) {
        
        List<Integer> sol = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n == 0 || k == 0)
        	return res;
       backtrack(1, 0, n, k, sol, res);
       return res;
    }
	
	static void backtrack(int i, int count, int n, int k, List<Integer> sol, List<List<Integer>> res) {
		if(count == k) {
			res.add(new ArrayList<Integer>(sol));
			return;
		}
		if (i > n)
			return;
		
		backtrack(i+1, count, n, k, sol, res);
		sol.add(i);
		backtrack(i+1, count+1, n, k, sol, res);
		sol.remove(sol.size()-1);
		
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res = combine(4, 2);
		for(List<Integer> list : res) {
			for(Integer i : list)
				System.out.print(i);
			System.out.print("\n");
		}
	}
}
