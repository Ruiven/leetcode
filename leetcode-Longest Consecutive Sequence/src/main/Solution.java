package main;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static int longestConsecutive(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < nums.length; i++)
        	set.add(nums[i]);
        
        int max = 0;
        for(int i = 0 ; i < nums.length; i++) {
        	if(set.contains(nums[i]-1))
        		continue;
        	
        	
        	int len = 1, val = nums[i]+1;
        	while(set.contains(val)) {
        		len++;
        		val++;
        	}
        	max = (len > max) ? len : max;
        	
        	
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		int nums[] = {100, 4, 200, 1, 3, 2};
		System.out.print(longestConsecutive(nums));
		
	}
	
}
