package main;

public class Solution {
	public static int searchInsert(int[] nums, int target) {
		int begin = 0, end = nums.length-1;
		
		while(begin <= end) {
			if(nums[begin] > target)
				return begin;
			if(nums[end] < target)
				return end+1;
			int mid = (begin+end)/2;
			if(nums[mid] == target)
				return mid;
			
			if(nums[mid] < target) {
				begin = mid+1;
				continue;
			}
			else {
				end = mid-1;
				continue;
			}
		}
        
		
		return 0;
		
    }
	
	public static void main(String[] args) {
		int nums[] = {1,3,5,6};
		int target = 0;
		System.out.print(searchInsert(nums, target));
	}
	
	
}
