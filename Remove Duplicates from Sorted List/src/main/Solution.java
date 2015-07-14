package main;

import java.util.List;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public static ListNode deleteDuplicates(ListNode head) {
		
		ListNode prev = head;
		ListNode t = head;
        while(t != null && t.next != null) {
        	if(t.val == t.next.val) {
        		prev = t;
        		do{
        			t = t.next;
        		}while(t.next != null && t.val == t.next.val);
        		
        		prev.next = t.next;
        		
        	}
        	
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
