package main;

public class Solution {
	public static int numTrees(int n) {		
		int sol[] = new int[n+1];
		sol[0] = sol[1] = 1;
		for(int i = 2; i <= n; i++) {			
			for(int j = 0; j < i; j++)
				sol[i] += sol[j] * sol[i-1-j]; 
			
		}
        return sol[n];
    }
	
	public static void main(String[] args) {
		System.out.print(numTrees(3));
	}
	
	
}
