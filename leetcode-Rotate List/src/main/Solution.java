package main;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	}


public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		
		if(head == null)
			return head;
		
		
		int len = 0;
		ListNode q = head;
		while(q != null) {
			q = q.next;
			len++;
		}
		
		k %= len;
		
		if(k == 0 )
			return head;
		
        ListNode newHead = head, p = head;
        for(int i = 0; i < k-1; i++)
        	p = p.next;
        
        if(p.next == null)
        	return head;
        
        while(p.next !=  null) {
        	p = p.next;
        	newHead = newHead.next;
        }
        
        p.next = head;
        while(head.next != newHead)
        	head = head.next;
        head.next = null;
        return newHead;
    }
}
