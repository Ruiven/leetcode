package main;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}


public class Solution {
	
	//Recursive Solution
//	public boolean isSymmetric(TreeNode root) {
//        if(root == null)
//        	return true;
//        return isSymmetric(root.left, root.right);
//    }
//	
//	boolean isSymmetric(TreeNode left, TreeNode right) {
//		if(left == null && right == null) {
//			return true;
//		}
//		
//		if(left != null && right == null || left == null && right != null || left.val != right.val)
//			return false;
//		
//		return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
//		
//	}
	
	//Iterative Solution
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		
		TreeNode p = root.left;
		TreeNode q = root.right;
		Stack<TreeNode> leftTree = new Stack<>();
		Stack<TreeNode> rightTree = new Stack<>();
		leftTree.push(p);
		rightTree.push(q);
		
		while(!leftTree.isEmpty() && !rightTree.isEmpty()) {
			p = leftTree.pop();
			q = rightTree.pop();
			if(p != null && q != null) {
				if(p.val != q.val)
					return false;
				leftTree.push(p.left);
				leftTree.push(p.right);
				rightTree.push(q.right);
				rightTree.push(q.left);
			}
			
			else if(p == null && q != null || p != null && q == null)
				return false;
		}
		if(!leftTree.isEmpty() || !rightTree.isEmpty())
			return false;
		
		return true;
    }






}
