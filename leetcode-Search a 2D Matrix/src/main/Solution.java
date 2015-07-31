package main;

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
        int curRow = 0, curCol = matrix[0].length-1;
        while(matrix[curRow][curCol] != target) {
        	
        	if(target < matrix[curRow][curCol]) {
        		curCol--;
        		if(curCol < 0)
        			return false;
        	}
        		
        	else if(target > matrix[curRow][curCol]) {
        		curRow++;
        		if(curRow >= matrix.length)
        			return false;
        	}
        			
        }
        return true;
    }
}
