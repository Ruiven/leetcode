package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solutionList = new ArrayList<>();
		if(nums.length == 0)
			return solutionList;
        
        
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
				part.add(nums[i]);
				used[i] = true;
				_permute(nums, part, used, solutionList);
				part.remove(part.size()-1);
				used[i] = false;
				
			}
		}
	}
	
	public static void main(String[] args) {
		int nums[] = {1,2,3};
		System.out.println(permute(nums));
		
	}
}
