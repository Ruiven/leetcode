package main;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(n == 0 || head == null)
			return head;
		
		
		ListNode p = head, q = head;
		for(int i = 0 ; i < n; i++)
			q = q.next;
		
		if(q == null)
			return head.next;
		
		while(q.next != null) {
			p = p.next;
			q = q.next;
		}
		
		
			
		
		p.next = p.next.next;
		return head;
        
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		removeNthFromEnd(head, 0);
	}
}
