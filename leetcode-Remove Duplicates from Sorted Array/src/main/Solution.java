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
        	if(lastRepeatedLength != 0) {
        		for(int j = i-lastRepeatedLength; j < nums.length - lastRepeatedLength; j++ )
        			nums[j] = nums[j+lastRepeatedLength];
        		res -= lastRepeatedLength;
        		i -= lastRepeatedLength;
        		lastRepeatedLength = 0;
        		
        	}
        	     	
        }
        
        if(lastRepeatedLength != 0)
        	res -= lastRepeatedLength;
        return res;
    }
	
	public static void main(String[] args) {
		int nums[] = {1,1,1,1,1, 2, 2,2, 3,3,3};
		int l = removeDuplicates(nums);
		for(int i = 0 ; i < l; i++)
			System.out.print(nums[i]);
	}
}
