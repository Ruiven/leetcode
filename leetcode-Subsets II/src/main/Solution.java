package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
        	return res;
        Arrays.sort(nums);
        
        List<Integer> sub = new ArrayList<>();
        res.add(new ArrayList<>(sub));
        int start = 0;
        for(int i = 0; i < nums.length; i++) {
        	
        		
        	int l = res.size();
        	for(int j = start; j < l; j++) {
        		List<Integer> addedList = new ArrayList<Integer>(res.get(j));
        		addedList.add(nums[i]);
        		res.add(addedList);
        	}
        	
        	if(i < nums.length-1 && nums[i] == nums[i+1])
        		start = l;
        	else
        		start = 0;
        }
        return res;
    }
	
	public static void main(String[] args) {
		int nums[] = {5,5,5,5};
		List<List<Integer>> res = subsetsWithDup(nums);
		for(List<Integer> list : res )
			System.out.print(list);
	}
}
