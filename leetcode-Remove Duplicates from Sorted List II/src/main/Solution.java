package main;

import java.util.List;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public static ListNode deleteDuplicates(ListNode head) {
		
		ListNode prev = null;
		ListNode t = head;
        while(t != null && t.next != null) {
        	if(t.val == t.next.val) {
        		do{
        			t = t.next;
        		}while(t.next != null && t.val == t.next.val);
        		if(prev != null)
        			prev.next = t.next;
        		else {
        			head = t.next;
        		}
        	}
        	else
        		prev = t;
        	t = t.next;        	
        }
		
		return head;
		
		
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		deleteDuplicates(head);
		
	}
}
