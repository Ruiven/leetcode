package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public static int[] twoSum(int[] numbers, int target) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i : numbers) {
        	list.add(i);
        }
       
        List<Integer> copy = new ArrayList<Integer>(list);
        
        Collections.sort(list);
        
        int lowP = 0, highP = list.size()-1;
        
        while(lowP <= highP) {
        	if(list.get(lowP) + list.get(highP) < target) {
        		lowP++;
        		continue;
        	}
        	
        	if(list.get(lowP) + list.get(highP) > target) {
        		highP--;
        		continue;
        	}
        	
        	break;
        	
        }
        
        int a = copy.indexOf(list.get(lowP));
        int b = copy.indexOf(list.get(highP));
        int low = a<b ? a : b;
        int high = a<b ? b : a;
        if(low == high){
        	copy.remove(low);
        	high = copy.indexOf(list.get(highP))+1;
        }
        
        int out[] = {low+1, high+1};
        return out;
        
    }
	
	
	public static void main(String[] args) {
		int a[] = {0,3,4,0};
		int b[] = twoSum(a, 0);
		System.out.println(b[0]);
		System.out.println(b[1]);
		
	}
}
