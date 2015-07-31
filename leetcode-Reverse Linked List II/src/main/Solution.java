package main;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}


public class Solution {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode p = head;
        ListNode leftTail = null, leftHead = null, rightTail = null, rightHead = null;
        ListNode prev = head;
        while(p != null) {
        	if(i == m-1) {
        		leftHead = p;
        	}
        	
        	if(i == m) {
        		prev = p;
        		rightHead = p;
        	}
        		
        	if(i == n) {
        		leftTail = p;
        	}
        	
        	if(i == n+1) {
        		rightTail = p;
        	}
        	
        	if(i > m && i <= n) {
        		ListNode next = p.next;
        		p.next = prev;
        		prev = p;
        		p = next;
        		i++;
        		continue;
        		
        	}
        	p = p.next;
        	i++;
        	
        }
        if(m > 1) {
        	leftHead.next = leftTail;
        	rightHead.next = rightTail;
        	return head;
        }
        else {
        	rightHead.next = rightTail;
        	return leftTail;
        }
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		reverseBetween(head, 2, 2);
	}
}
