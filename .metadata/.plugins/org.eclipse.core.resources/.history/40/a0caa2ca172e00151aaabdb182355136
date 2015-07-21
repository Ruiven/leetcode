package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<Integer> spiralOrder(int[][] matrix) {
        int dir = 0; //right
        int i = 0;
        
        List<Integer> res = new ArrayList<Integer>();
        
        if(matrix == null || matrix.length == 0)
        	return res;
        
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        int r = 0, c = 0;
        while(i < matrix.length * matrix[0].length) {
        	res.add(matrix[r][c]);
        	visited[r][c] = true;
        	switch (dir % 4) {
			case 0:
				if(c == matrix[0].length-1 || visited[r][c+1]) {
					dir++;
					r++;
					break;
				}
				
				c++;
				break;
			case 1:
				if(r == matrix.length-1 || visited[r+1][c]) {
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
        
        return res;
    }
	
	public static void main(String[] args) {
		int nums[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
		System.out.println(spiralOrder(nums));
	}
}
