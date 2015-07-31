package main;

public class Solution {
	public static int removeDuplicates(int[] nums) {
		int res = nums.length;
		int lastRepeatedLength = 0;
        for(int i = 0 ; i < res; i++) {
        	if(i > 0 && nums[i] == nums[i-1]) {
        		lastRepeatedLength++;
        		continue;
        	}
        	if(lastRepeatedLength > 1) {
        		lastRepeatedLength--;
        		for(int j = i-lastRepeatedLength; j < nums.length - lastRepeatedLength; j++ )
        			nums[j] = nums[j+lastRepeatedLength];
        		res -= lastRepeatedLength;
        		i -= lastRepeatedLength;
        		lastRepeatedLength = 0;
        		
        	}
        	if(lastRepeatedLength != 0)
        		lastRepeatedLength = 0;
        	     	
        }
        
        if(lastRepeatedLength > 1)
        	res -= lastRepeatedLength-1;
        return res;
    }
	
	public static void main(String[] args) {
		int nums[] = {1,1,1};
		System.out.print(removeDuplicates(nums));
		System.out.print("\n");
		for(int i : nums)
			System.out.print(i);
	}
}
