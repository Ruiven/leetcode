package main;

public class Solution {
	public static void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return;
		
		boolean colZero = false;
        for(int i = 0 ; i < matrix.length; i++)
        	if(matrix[i][0] == 0){
        		colZero = true;
        		break;
        	}
        	
        boolean rowZero = false;
        for(int i = 0 ; i < matrix[0].length; i++)
        	if(matrix[0][i] == 0){
        		rowZero = true;
        		break;
        	}
        
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0 ; j < matrix[0].length; j++) {
        		if(matrix[i][j] == 0) {
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }
        
        for(int i = 1; i < matrix.length; i++) {
        	if(matrix[i][0] == 0) {
        		for(int j = 1 ; j < matrix[0].length; j++)
        			matrix[i][j] = 0;
        	}
        }
        
        for(int j = 1; j < matrix[0].length; j++) {
        	if(matrix[0][j] == 0) {
        		for(int i = 1 ; i < matrix.length; i++)
        			matrix[i][j] = 0;
        	}
        }
        
        if(rowZero)
        	for(int i = 0; i < matrix[0].length; i++)
        		matrix[0][i] = 0;
        if(colZero)
        	for(int i = 0 ; i < matrix.length; i++)
        		matrix[i][0] = 0;
        		
    }
	public static void main(String[] args) {
		int matrix[][] = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		setZeroes(matrix);
	}
}
