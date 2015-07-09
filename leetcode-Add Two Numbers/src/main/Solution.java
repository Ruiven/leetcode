package main;



public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	ListNode out = new ListNode(0);
    	ListNode begin = out;
    	ListNode prev = null;
    	while(l1 != null && l2 != null) {
    		if(out == null) {
    			out = new ListNode(0);
    			if(prev != null)
    				prev.next = out;
    		}
        	int bit = l1.val + l2.val;
        	out.val += bit;      	
        	
        	if(out.val >= 10) {
        		out.next = new ListNode(0);
        		out.next.val = 1;
        	}
        	
        	out.val %= 10;
        	
        	prev = out;
        	out = out.next;
        	l1 = l1.next;
        	l2 = l2.next;
        	
        } 
    	
    	while(l1 != null) {
    		if(out == null) {
    			out = new ListNode(0);
    			if(prev != null)
    				prev.next = out;
    		}
    		int bit = l1.val;
    		out.val += bit;

    		
    		if(out.val >= 10) {
    			out.next = new ListNode(0);
    			out.next.val = 1;
    		}
    		out.val %= 10;
    		
    		prev = out;
    		out = out.next;
    		l1 = l1.next;
    	}
    	
    	while(l2 != null) {
    		if(out == null) {
    			out = new ListNode(0);
    			if(prev != null)
    				prev.next = out;
    		}
    		int bit = l2.val;
    		out.val += bit;

    		
    		if(out.val >= 10) {
    			out.next = new ListNode(0);
    			out.next.val = 1;
    		}
    		out.val %= 10;
    		
    		prev = out;
    		out = out.next;
    		l2 = l2.next;
    	}
    	
    	return begin;
    	
    }
    
    public static void node_print(ListNode l) {
    	while(l != null) {
    		System.out.println(l.val);
    		l = l.next;
    	}
    }
    
    public static void main(String[] args) {
		ListNode a = new ListNode(5);
		//a.next = new ListNode(9);
		//a.next.next = new ListNode(3);
		
		ListNode b = new ListNode(5);
		//b.next = new ListNode(5);
		//b.next.next = new ListNode(6);
		
		node_print(addTwoNumbers(a, b));
		
	}
}