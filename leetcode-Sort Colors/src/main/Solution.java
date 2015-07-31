package main;

public class Solution {
	public void sortColors(int[] nums) {
		int red = 0, blue = nums.length-1;
		int i = 0;
		while(i < blue+1) {
			if(nums[i] == 0) {
				nums[i] = nums[red];
				nums[red] = 0;
				red++;
				i++;
				continue;
			}
			
			if(nums[i] == 2) {
				nums[i] = nums[blue];
				nums[blue] = 2;
				blue--;
				continue;
			}
			i++;
			
		}
    }
}
