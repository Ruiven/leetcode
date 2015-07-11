package main;


public class Solution {
	
	public int maxArea(int[] height) {
		int i = 0, j = height.length-1;
		
		int maxArea = 0;
		int area;
		while(i < j) {
			int min = height[i] < height[j] ? height[i] : height[j];
			area = min * (j-i);
			maxArea = area > maxArea ? area : maxArea;
			
			if(height[i] < height[j])
				i++;
			
			else
				j--;			
		}
		
		
        return maxArea;
    }
	
	
	
}
