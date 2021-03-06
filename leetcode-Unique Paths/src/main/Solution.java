package main;

public class Solution {
	public static int uniquePaths(int m, int n) {
        int [][]ways = new int[m][n];
        ways[0][0] = 1;
        for(int i = 0; i < m; i++) {
        	for(int j = 0 ; j < n; j++){
        		if(i == 0 && j == 0)
        			continue;
        		if(i == 0)
        			ways[i][j] = ways[i][j-1];
        		else if(j == 0)
        			ways[i][j] = ways[i-1][j];
        		else
        			ways[i][j] = ways[i-1][j] + ways[i][j-1];
        	}
        		
        }
        
        return ways[m-1][n-1];
    }
	
	public static void main(String[] args) {
		uniquePaths(1, 2);
	}
}
