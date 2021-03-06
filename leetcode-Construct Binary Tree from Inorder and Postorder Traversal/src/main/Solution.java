package main;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder == null || postorder.length == 0)
        	return null;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < inorder.length; i++)
        	map.put(inorder[i], i);
        
        return recursive(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
	
	
	static TreeNode recursive(int[] inorder, int il, int ir, int[] postorder, int pl, int pr, Map<Integer, Integer> map) {
		if(pl > pr || il > ir)
			return null;
		
		if(pl == pr)
			return new TreeNode(postorder[pr]);
		
		TreeNode head = new TreeNode(postorder[pr]);
		
		int i = map.get(postorder[pr]);
		head.left = recursive(inorder, il, i-1, postorder, pl, pl+i-il-1, map);
		head.right = recursive(inorder, i+1, ir, postorder, pl+i-il, pr-1, map);
		return head;
	}
	
	public static void main(String[] args) {
		int []inorder = {1,2};
		int []postorder = {2,1};
		TreeNode node = buildTree(inorder, postorder);
		System.out.print(node);
	}
}
