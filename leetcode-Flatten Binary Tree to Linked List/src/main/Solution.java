package main;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public static void flatten(TreeNode root) {		
		dfs(root);
    }
	
	public static void dfs(TreeNode node) {
		if(node == null)
			return;
		dfs(node.left);
		dfs(node.right);
		TreeNode leftRightNode;
		if(node.left != null) {
			leftRightNode = node.left;
			while(leftRightNode.right != null)
				leftRightNode = leftRightNode.right;
			leftRightNode.right = node.right;
			node.right = node.left;
			node.left = null;
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.left.left = new TreeNode(3);
		head.left.right = new TreeNode(4);
		head.right = new TreeNode(5);
		head.right.right = new TreeNode(6);
	
		flatten(head);
	}
	
	
}
