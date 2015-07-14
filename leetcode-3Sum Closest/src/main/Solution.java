package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public static int threeSumClosest(int[] nums, int target) {
        int i = 0;
        while(true) {
        	if(threeSum(nums, target+i))
        		return target+i;
        	if(threeSum(nums, target-i))
        		return target-i;
        	i++;
        }
    }
	
	
	public static boolean threeSum(int[] nums, int sum) {
		if(nums.length < 3)
			return false;
		
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
        	int target = sum -list.get(i);
	        int lowP = i+1, highP = list.size()-1;
	        
	        while(lowP < highP ) {        	
	        	if(list.get(lowP) + list.get(highP) < target) {
	        		lowP++;	        		
	        	}
	        	
	        	else if(list.get(lowP) + list.get(highP) > target) {
	        		highP--;	        	
	        	}
	        	
	        	else {        		
	        		return true;		        		        		
	        	}	        	
	        }
	        

	        
        }
        return false;
    }
	
	public static void main(String[] args) {
		int nums[] = {-1,2,1,-4};
		int target = 1;
		System.out.println(threeSumClosest(nums, target));
	}
}
