package main;

public class Solution {
	public static boolean jump(int[] nums) {
		if(nums == null || nums.length==0)
			return false;
        int curFarthest = nums.length-1;
        boolean found;
        while(curFarthest != 0) {
        	found = false;
        	for(int j = 0; j < curFarthest; j++) {
        		if(nums[j] + j >= curFarthest) {
        			curFarthest = j;
        			found = true;
        			break;
        		} 
        		
        	}
        	if(!found)
        		return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		int nums[] = {0,2,3};
		System.out.println(jump(nums));
	}
}
