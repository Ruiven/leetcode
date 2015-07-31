package main;


public class Solution {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if(nums1 == null || nums2 == null)
			return;
        int i = 0, j = 0;
        while(i < m && j < n) {
        	if(nums1[i] < nums2[j]) {
        		i++;
        		continue;
        	}
        	
        	for(int k = m; k >= i+1; k--) {
        		nums1[k] = nums1[k-1];
        	}
        	nums1[i] = nums2[j];
        	m++;
        	j++;
        	i++;
        }
        
        while(j < n) {
        	nums1[i++] = nums2[j++];
        }
    }
	
	public static void main(String[] args) {
		int nums1[] = {0};
		int nums2[] = {1};
		merge(nums1, 0, nums2, 1);
		for(int i : nums1)
			System.out.print(i);
	}
}
