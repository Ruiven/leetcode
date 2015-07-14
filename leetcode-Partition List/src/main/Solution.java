package main;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}


public class Solution {
	public static ListNode partition(ListNode head, int x) {
		if(head == null)
			return null;
		
        ListNode t = head;
        ListNode smallHead = null, bigHead = null;
        ListNode smallNode = null, bigNode = null;
        ListNode smallPrev = null, bigPrev = null;
        boolean smallFirst = true, bigFirst = true;
        while(t != null) {
        	if(t.val < x) {
        		smallNode  = new ListNode(t.val);      		
        		if(smallFirst) {
        			smallHead = smallNode;
        			smallFirst = false;
        		}
        		else
        			smallPrev.next = smallNode;
        		smallPrev = smallNode;
        		smallNode = smallNode.next;
        	}
        	else {
        		
        		bigNode = new ListNode(t.val); 		
        		if(bigFirst) {
        			bigHead = bigNode;
        			bigFirst = false;
        		}
        		else
        			bigPrev.next = bigNode;
        		bigPrev = bigNode;
        		bigNode = bigNode.next;
        	}
        	t = t.next;
        }
		if(smallHead == null)
			return bigHead;
        smallPrev.next = bigHead;	
		return smallHead;
    }
	
	public static void main(String[] args) {
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(4);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(2);
		
		ListNode head = new ListNode(1);
	
		ListNode t = partition(head, 0);
		while(t != null) {
			System.out.println(t.val);
			t = t.next;
		}
		
		
	}
}
