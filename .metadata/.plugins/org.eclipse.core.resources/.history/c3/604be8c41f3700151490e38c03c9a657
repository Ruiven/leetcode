package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> sol = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		
		int up = (int) Math.pow(2, nums.length);
        
        for(int i = 0 ; i < up; i++ ) {
        	int pos = 0;
        	int copy = i;
        	while(copy != 0) {
        		if(copy % 2 == 1) 
        			sol.add(nums[pos]);
        		pos++;
        		copy /= 2;
        	}
        	Collections.sort(sol);
        	res.add(new ArrayList<Integer>(sol));
        	sol.clear();
        }
        return res;
    }
	
	public static void main(String[] args) {
		int nums[] = {1,2,3};
		List<List<Integer>> res = subsets(nums);
		for(List<Integer> list : res) {
			for(Integer i : list)
				System.out.print(i);
			System.out.print("\n");
		}
	}
}
