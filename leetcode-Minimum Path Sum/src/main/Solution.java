package main;

public class Solution {
	public static int minPathSum(int[][] grid) {
		int [][]ways = new int[grid.length][grid[0].length];
        ways[0][0] = grid[0][0];
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0 ; j < grid[0].length; j++){
        		if(i == 0 && j == 0)
        			continue;
        		if(i == 0)
        			ways[i][j] = ways[i][j-1] + grid[i][j];
        		else if(j == 0)
        			ways[i][j] = ways[i-1][j] + grid[i][j];
        		else
        			ways[i][j] = (ways[i-1][j] < ways[i][j-1] ? ways[i-1][j] : ways[i][j-1]) + grid[i][j];
        	}
        		
        }
        
        return ways[grid.length-1][grid[0].length-1];
    }
	
	public static void main(String[] args) {
		int grid[][] = {{0,1}, {1,0}};
		System.out.println(minPathSum(grid));
	}
}
