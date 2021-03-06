package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
//	public static String getPermutation(int n, int k) {
//		List<List<Integer>> solutionList = new ArrayList<>();
//		int []nums = new int[n];
//		for(int i = 0 ; i < n; i++)
//			nums[i] = i+1;
//        
//        
//        _permute(nums, new ArrayList<Integer>(), new boolean[nums.length], solutionList);
//        List<Integer> res = solutionList.get(k-1);
//        String out = "";
//        for(Integer i : res)
//        	out = out + i;
//        return out;
//    }
//	
//	
//	public static void _permute(int[] nums, ArrayList<Integer> part, boolean[] used, List<List<Integer>> solutionList) {
//		if(nums.length == part.size()) {
//			solutionList.add(new ArrayList<>(part));
//			return;
//		}
//		
//		for(int i = 0 ; i < nums.length; i++) {
//			if(!used[i]) {
//				part.add(nums[i]);
//				used[i] = true;
//				_permute(nums, part, used, solutionList);
//				part.remove(part.size()-1);
//				used[i] = false;
//				
//			}
//		}
//	}
	
	public static String getPermutation(int n, int k) {
        String res = "";
        LinkedList<Integer> nums = new LinkedList<>();
        for(int i = 0; i <= n; i++)
        	nums.add(i+1);
        for(int i = 0; i < n; i++) {
        	int total = getPermuteNum(n-i-1);
        	int index = (k-1)/total;
        	res += nums.get(index);
        	nums.remove(index);
        	k -= (k-1)/total* total;
        }
		
		return res;
    }
	
	static int getPermuteNum(int up) {
		int numerator =1;
		for(int i = up; i >= 1; i--)
			numerator *= i;
		return numerator;
	}
	
	
	public static void main(String[] args) {
		System.out.print(getPermutation(9, 13531));
		//System.out.print(getPermuteNum(2, 4));
	}
}
