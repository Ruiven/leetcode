package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public static List<List<Integer>> threeSum(int[] nums) {
		if(nums.length < 3)
			return new ArrayList<List<Integer>>();
		
		List<Integer> list = new ArrayList<Integer>();
        for(int i : nums) {
        	list.add(i);
        }        
        Collections.sort(list);
        List<List<Integer>> solList = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<>();
        
        for(int i = 0 ; i < list.size(); i++) {
        	if(i > 0 && list.get(i) == list.get(i-1))
        		continue;
        	int target = -list.get(i);
	        int lowP = i+1, highP = list.size()-1;
	        
	        while(lowP < highP ) {        	
	        	if(list.get(lowP) + list.get(highP) < target) {
	        		lowP++;	        		
	        	}
	        	
	        	else if(list.get(lowP) + list.get(highP) > target) {
	        		highP--;	        	
	        	}
	        	
	        	else {        		
	        		sol.add(list.get(i));
		        	sol.add(list.get(lowP));
		        	sol.add(list.get(highP));
		        	Collections.sort(sol);
		        	solList.add(sol);
		        	sol = new ArrayList<>();
		        	lowP++;
		        	highP--;
		        	
		        	while(lowP < highP && list.get(lowP) == list.get(lowP-1))
		        		lowP++;
		        	while(lowP < highP && list.get(highP) == list.get(highP+1))
		        		highP--;		        		        		
	        	}	        	
	        }
	        

	        
        }
        return solList;
    }

	
	
	
	public static void main(String[] args) {
		int nums[] = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		System.out.println(threeSum(nums));
	}
}
