package main;

public class Solution {
	public static void rotate(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return;
        //first swap
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i; j < matrix.length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		//second swap
		for(int i = 0; i <= (matrix.length-1)/2; i++) {
			for(int j = 0 ; j < matrix.length; j++) {
				int temp = matrix[j][i];
				matrix[j][i] = matrix[j][matrix.length-i-1];
				
				matrix[j][matrix.length-i-1] = temp;
			}
		}
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{1}};
		rotate(matrix);
		for(int i = 0 ;i < 3; i++) {
			for(int j = 0 ; j < 3; j++)
				System.out.print(matrix[i][j]);
			System.out.print("\n");
		}
	}
}
