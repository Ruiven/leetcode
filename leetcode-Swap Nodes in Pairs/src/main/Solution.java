package main;

public class Solution {
	public static ListNode swapPairs(ListNode head) {
		
        ListNode p = head;
        if(p == null)
        	return null;
        ListNode q = p.next;
        if(q == null)
        	return head;
        ListNode r = null;
        ListNode newHead = q;
        
        while(p != null) {
        	q = p.next;
        	if(q == null)
        		break;
        	r = q.next;
        	if(r == null)
        		p.next = null;
        	else if(r.next == null) {
        		p.next = r;
        	}
        	else
        		p.next = r.next;
        	
        	q.next = p;
        	
        	p = r;
        }
		
        return newHead;
		
    }
	
	public static void node_print(ListNode l) {
    	while(l != null) {
    		System.out.println(l.val);
    		l = l.next;
    	}
    }
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		a.next.next.next.next = new ListNode(5);
		
		node_print(swapPairs(a));
		
	}
}
