package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}


public class Solution {
	public static boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		
		int prev = 0;
		boolean first = true;
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()) {
        	if(root != null) {
        		stack.push(root);
        		root = root.left;
        	}
        	else{
        		root = stack.pop();
        		if(!first && root.val <= prev) {
        			return false;
        		}
        		first = false;
        		prev = root.val;
        		root = root.right;
        	}
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(1);
		System.out.print(isValidBST(head));
	}
}
