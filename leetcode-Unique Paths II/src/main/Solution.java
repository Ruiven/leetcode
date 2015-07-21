package main;

public class Solution {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid[0][0] == 1)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int [][]ways = new int[m][n];
        ways[0][0] = 1;
        for(int i = 0; i < m; i++) {
        	for(int j = 0 ; j < n; j++){
        		if(i == 0 && j == 0)
        			continue;
        		if(obstacleGrid[i][j] == 1)
        			continue;
        		if(i == 0 || obstacleGrid[i-1][j] == 1) {
        			if(j == 0)
        				ways[i][j] = 0;
        			else
        				ways[i][j] = ways[i][j-1];
					
        		}
        			
        		else if(j == 0 || obstacleGrid[i][j-1] == 1) {
        			if(i == 0)
        				ways[i][j] = 0;
        			else
        				ways[i][j] = ways[i-1][j];
        		}
        			
        		else
        			ways[i][j] = ways[i-1][j] + ways[i][j-1];
        	}
        		
        }
        
        return ways[m-1][n-1];
    }
	
	public static void main(String[] args) {
		int obstacleGrid[][] = {{1}, {0}};
		uniquePathsWithObstacles(obstacleGrid);
	}
}
