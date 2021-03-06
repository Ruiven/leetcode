package main;

import java.util.Arrays;

public class Solution {
	public static int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        
        int begin = -1;
        for(int i = 0 ; i < nums.length; i++) {
        	if(nums[i] == val) {
        		begin = (begin == -1) ? i : begin;
        		continue;
        	}
        	if(i > 0 && nums[i-1] == val) {
        		for(int j = begin; j+i-begin < nums.length; j++ ) {
        			nums[j] = nums[j+i-begin];
        		}
        		return nums.length - i + begin;
        	}
        	
        	
        }
        
        if(begin != -1) {
        	for(int j = begin; j+nums.length-begin < nums.length; j++ ) {
    			nums[j] = nums[j+nums.length-begin];
    		}
    		return nums.length - nums.length + begin;
        }
        	
        else
			return nums.length;
		
    }
	
	public static void main(String[] args) {
		int nums[] = {4,4,3,5,5};
		int l = removeElement(nums, 5);
		for(int i = 0 ; i < l; i++) 
			System.out.print(nums[i]);
	}
}
