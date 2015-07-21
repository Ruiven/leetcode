package main;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
	public static int firstMissingPositive(int[] nums) {
		if(nums == null || nums.length == 0)
			return 1;
		Arrays.sort(nums);
		int start = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > 0) {
				start = i;
				break;
			}
				
		}
		if(nums[start] != 1)
			return 1;
		
		for(int i = start ; i < nums.length-1; i++) {
			if(nums[i+1] == nums[i])
				continue;
			if(nums[i+1] != nums[i]+1)
				return nums[i]+1;
			
		}
		
		if(nums[nums.length-1] >= 0)
			return nums[nums.length-1]+1;
		else
			return 1;
		
    }
	
	public static void main(String[] args) {
		int nums[] = {3,4,-1,1};
		System.out.print(firstMissingPositive(nums));
	}
}
