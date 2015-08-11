package main;


class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}

public class Solution {
	public static void connect(TreeLinkNode root) {
		 if(root == null){  
	            return;  
	        }  
	          
	       
	        if(root.left != null){  
	            root.left.next = root.right;  
	        }  
	          
	        if(root.right!=null && root.next!=null){  
	            root.right.next = root.next.left;  
	        }  
	          
	        connect(root.left);  
	        connect(root.right);  
        
    }
	
	public static void main(String[] args) {
		TreeLinkNode head = new TreeLinkNode(1);
		head.left = new TreeLinkNode(2);
		head.right = new TreeLinkNode(3);
		head.left.left = new TreeLinkNode(4);
		head.left.right = new TreeLinkNode(5);
		head.right.left = new TreeLinkNode(6);
		connect(head);
		System.out.print("");
		
		
	}
}
