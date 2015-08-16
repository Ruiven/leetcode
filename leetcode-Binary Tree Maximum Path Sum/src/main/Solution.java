package main;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	static int max;
	public static int maxPathSum(TreeNode root) {
		if(root == null)
			return 0;
		max = root.val;
        recursive(root);
        return max;
    }
	
	static int recursive(TreeNode root) {
		if(root == null)
			return 0;
		
		int leftMax = recursive(root.left);
		int rightMax = recursive(root.right);
		
		int notUp = leftMax + root.val + rightMax;
		
		int up = Math.max(root.val , Math.max(leftMax, rightMax) + root.val);
		
		max = Math.max(max, Math.max(up,  notUp));
		
		return up;
		
	}
	
	public static void main(String[] args) {
		maxPathSum(new TreeNode(-3));
	}
}
