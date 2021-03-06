package main;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public static int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
        
		int min = 0;
		boolean found = false;
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> depthStack = new Stack<>();
        stack.push(root);
        depthStack.push(1);
        while(!stack.isEmpty()) {
        	TreeNode p = stack.pop();
        	int depth = depthStack.pop();
        	
        	if(p.left != null) {
        		stack.push(p.left);
        		depthStack.push(depth+1);
        	}
        	
        	if(p.right != null) {
        		stack.push(p.right);
        		depthStack.push(depth+1);
        	}
        	
        	if(p.left == null && p.right == null) {
        		if(!found) {
        			min = depth;
        			found = true;
        		}
        		else
        			min = depth < min ? depth : min;
        		
        	}
        }
        
        return min;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		minDepth(root);
	}
}
