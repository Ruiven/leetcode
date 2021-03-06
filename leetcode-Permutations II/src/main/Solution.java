package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> solutionList = new ArrayList<>();
		if(nums.length == 0)
			return solutionList;
	    
	    Arrays.sort(nums);
	    _permute(nums, new ArrayList<Integer>(), new boolean[nums.length], solutionList);
	    return solutionList;
	}

	public static void _permute(int[] nums, ArrayList<Integer> part, boolean[] used, List<List<Integer>> solutionList) {
		if(nums.length == part.size()) {
			solutionList.add(new ArrayList<>(part));
			return;
		}
	
		for(int i = 0 ; i < nums.length; i++) {
			
			if(!used[i]) {
				if(i > 0 && nums[i] == nums[i-1] && !used[i-1])
					continue;
				part.add(nums[i]);
				used[i] = true;
				_permute(nums, part, used, solutionList);
				part.remove(part.size()-1);
				used[i] = false;
				
			}
		}
	}
	
	public static void main(String[] args) {
		int nums[] = {1,1,2};
		System.out.println(permuteUnique(nums));
	}
}
