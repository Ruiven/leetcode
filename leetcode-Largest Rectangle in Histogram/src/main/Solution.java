package main;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
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
	
	public static void main(String[] args) {
		int height[] = {1,1};
		System.out.print(largestRectangleArea(height));
	}
}
