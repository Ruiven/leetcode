package main;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public void recoverTree(TreeNode root) {
        TreeNode f1 = null, f2 = null;
        TreeNode cur, pre, parent = null;
        
        if(root == null)
        	return;
        
        boolean found = false;
        cur = root;
        
        while(cur != null) {
        	if(cur.left == null) {
        		if(parent != null && parent.val > cur.val) {
        			if(!found) {
        				f1 = parent;
        				found = true;
        			}
        			f2 = cur;
        		}
        		parent = cur;
        		cur = cur.right;
        	}
        	else {
        		pre = cur.left;
        		while(pre.right != null && pre.right != cur) {
        			pre = pre.right;
        		}
        		if(pre.right == null) {
        			pre.right = cur;
        			cur = cur.left;
        		}
        		else {
        			pre.right = null;
        			if(parent.val > cur.val){
        				if(!found) {
            				f1 = parent;
            				found = true;
            			}
            			f2 = cur;
        			}
        			parent = cur;
        			cur = cur.right;
        		}
        	}
        }
       if(f1 != null && f2 != null) {
    	   int temp = f1.val;
    	   f1.val = f2.val;
    	   f2.val = temp;
       }
    }
}
