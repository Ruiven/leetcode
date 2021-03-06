package main;

public class Solution {
	
	public static int[] searchRange(int[] nums, int target) {
		
		int start = 0, end = nums.length-1;
		
		while(start < end) {
			int mid = (start+end)/2;
			if(nums[mid] < target) {
				start = mid+1;
				continue;
			}
			end = mid;
		}
			
		if(nums[start] != target) {
			int res[] = {-1,-1};
			return res;
		}
		
		int low = start;
		//start++;
		end = nums.length;
		while(start < end) {
			int mid = (start+end)/2;
			if(nums[mid] > target) {
				end = mid;
				continue;
			}
			start = mid+1;
		}
		
		int high = start-1;
		int res[] = new int[2];
		
		res[0] = low;
		res[1] = high;
		return res;
	
		
	}
	public static void main(String[] args) {
		int nums[] = {2,2};
		int res[] = searchRange(nums, 2);
		System.out.println(res[0]);
		System.out.println( res[1]);
	}
}
