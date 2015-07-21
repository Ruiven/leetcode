package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static int[][] generateMatrix(int n) {
		int [][]matrix = new int[n][n];
        int dir = 0; //right
        
        if(matrix == null || matrix.length == 0)
        	return matrix;
        
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        int r = 0, c = 0;
        int i = 1;
        while(i <= matrix.length * matrix[0].length) {
        	matrix[r][c] = i;
        	visited[r][c] = true;
        	switch (dir % 4) {
			case 0:
				if(c == n-1 || visited[r][c+1]) {
					dir++;
					r++;
					break;
				}
				
				c++;
				break;
			case 1:
				if(r == n-1 || visited[r+1][c]) {
					dir++;
					c--;
					break;
				}
				r++;
				break;
			case 2:
				if(c == 0 || visited[r][c-1]) {
					dir++;
					r--;
					break;
				}
				c--;
				break;
			case 3:
				
				if(r == 0 || visited[r-1][c]) {
					dir++;
					c++;
					break;
				}
				r--;
				break;
			
			}
        	i++;
        	
        }
        
        return matrix;
    }
	
	public static void main(String[] args) {
		
		int res[][] = generateMatrix(3);
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0 ; j < 3; j++)
				System.out.print(res[i][j]);
			System.out.print("\n");
		}
	}
}
