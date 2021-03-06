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
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()) {
        	if(root != null) {
        		stack.push(root);
        		root = root.left;
        	}
        	else{
        		root = stack.pop();
        		res.add(root.val);
        		root = root.right;
        	}
        }
        
        return res;
    }
}
