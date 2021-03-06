package main;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}



public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode temp;
		ListNode p = l1, q = l2;
		
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		ListNode newHead = l1.val < l2.val ? l1 : l2;
		
		while(p != null && q != null) {
			if(p.val < q.val) {
				while(p.next != null && p.next.val < q.val)
					p = p.next;
				
				temp = p.next;
				p.next = q;
				p = temp;
			}
			
			else{
				while(q.next != null && q.next.val <= p.val)
					q = q.next;
				
				temp = q.next;
				q.next = p;
				q = temp;				
			}
		}
		
		return newHead;
		
		
		
        
    }
}
