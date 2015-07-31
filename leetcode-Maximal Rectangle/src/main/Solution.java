package main;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
	public static int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length==0)
			return 0;
		int height[] = new int[matrix[0].length];
		int max = 0;
        for(int i = 0 ; i < matrix.length; i++) {
        	for(int j = 0 ; j < matrix[0].length; j++) 
        		height[j] = matrix[i][j] == '0' ? 0 : height[j]+1;
        	
        	int temp = largestRectangleArea(height);
        	max = Math.max(temp, max);
        		
        	
        }
        return max;
    }
	
	public static int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int copy[] = new int[height.length+1];
        copy = Arrays.copyOf(height, height.length+1);
        int maxArea = 0;
        int i = 0;
        while(i < copy.length) {
        	if(stack.isEmpty() || copy[stack.peek()] <= copy[i]) {
        		stack.push(i++);
        	}
        	
        	else{
        		int temp = stack.pop();
        		if(stack.isEmpty()) {
        			maxArea = copy[temp]*i > maxArea ? copy[temp]*i : maxArea;
        		}
        		else{
        			maxArea = copy[temp]*(i-1-stack.peek()) > maxArea ? copy[temp]*(i-1-stack.peek()): maxArea;
        		}
        		
        	}
        }
        return maxArea;
    }
}
