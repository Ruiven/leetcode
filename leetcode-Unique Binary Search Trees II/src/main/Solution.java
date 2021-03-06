package main;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public static List<TreeNode> generateTrees(int n) {
	     return generateTreeNodes(1, n);
	}
	
	static List<TreeNode> generateTreeNodes(int left, int right) {
		List<TreeNode> res = new ArrayList<>();
		if(left > right) {
			res.add(null);
			return res;
		}
		
		for(int i = left; i <= right ; i++) {
			List<TreeNode> leftList = generateTreeNodes(left, i-1);
			List<TreeNode> rightList = generateTreeNodes(i+1,  right);
			for(int j = 0 ; j < leftList.size(); j++) {
				for(int k = 0 ; k < rightList.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = leftList.get(j);
					root.right = rightList.get(k);
					res.add(root);
				}
			}
		}
		return res;	
	}
	
	public static void main(String[] args) {
		generateTrees(1);
	}
}
