package main;

public class Solution {
//	public static int jump(int[] nums) {
//		if(nums == null || nums.length==0)
//			return 0;
//        int curFarthest = nums.length-1;
//        int res = 0;
//        while(curFarthest != 0) {
//        	for(int j = 0; j < nums.length; j++)
//        		if(nums[j] + j >= curFarthest) {
//        			curFarthest = j;
//        			res++;
//        			break;
//        		}       	
//        }
//        return res;
//    }
	
	public static int jump(int[] nums) {
		if(nums == null || nums.length==0)
			return 0;
        int begin = 0, end = 0, count = 0;
        if(nums.length == 1)
        	return 0;
        while(end < nums.length) {
        	count ++;
        	int max = 0;
        	for(int i = begin; i <= end; i++) {
        		if(nums[i] + i >= nums.length-1)
        			return count;
        		if(nums[i] + i >= max)
        			max = nums[i] + i;
        	}
        	begin = end+1;
        	end = max;
        	
        }
        
        return 0;
    }
	
	public static void main(String[] args) {
		int nums[] = {2,3,1,1,4};
		System.out.print(jump(nums));
	}
}
