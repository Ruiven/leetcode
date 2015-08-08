package main;

import java.util.ArrayList;
import java.util.List;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
        	return null;
        
        
        List<Integer> list = new ArrayList<Integer>();
        while(head != null) {
        	list.add(head.val);
        	head = head.next;
        }
        Integer nums[] = new Integer[list.size()];
        list.toArray(nums);
        return recursive(nums, 0, nums.length-1);
    }
	
	TreeNode recursive(Integer[]nums, int begin, int end) {
		if(begin > end)
			return null;
		
		int mid = (begin + end)/2;
		TreeNode head = new TreeNode(nums[mid]);
		head.left = recursive(nums, begin, mid-1);
		head.right = recursive(nums, mid+1, end);
		return head;
	}
}
