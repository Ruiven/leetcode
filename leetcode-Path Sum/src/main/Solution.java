package main;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        	return false;
		
		Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        stack.push(root);
        numStack.push(root.val);
        
        while(!stack.isEmpty()) {
        	TreeNode p = stack.pop();
        	int temp = numStack.pop();
        	
        	if(p.left != null) {
        		stack.push(p.left);
        		numStack.push(temp + p.left.val);
        	}
        	if(p.right != null) {
        		stack.push(p.right);
        		numStack.push(temp + p.right.val);
        	}
        	
        	if(p.left == null && p.right == null && temp == sum)
        		return true;
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(-2);
		root.left.left.left = new TreeNode(-1);
		hasPathSum(root, 2);
	}
}
