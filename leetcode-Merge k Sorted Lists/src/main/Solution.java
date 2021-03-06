package main;


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	
	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) {
			return null;			
		}
		return mergeKLists(lists,0, lists.length);        
    }
	
	static ListNode mergeKLists(ListNode[] lists, int begin, int end) {
		if(end-begin > 2) {
			ListNode node1 = mergeKLists(lists, begin, (begin+end)/2);
			ListNode node2 = mergeKLists(lists, (begin+end)/2, end);
			return mergeTwoLists(node1, node2);
		}
		
		if(end - begin == 2) {
			return mergeTwoLists(lists[begin], lists[end-1]);
		}
		
		if(end - begin == 1)
			return lists[begin];
		
		else
			return null;
	}
	
	
	
	static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

	
	static ListNode generateLinked(int []nums) {
		ListNode head = null;
		ListNode prev = null, t;
		for(int i = 0; i < nums.length; i++) {
			t = new ListNode(nums[i]);
			if(prev != null){
				prev.next = t;
				prev = t;
			}
			else {
				head = t;
				prev = t;
			}
			
		
		}
		return head;
	}
	
	public static void main(String[] args) {
		int num[] = {1,2,3};
		int num2[] = {4,5,6};
		int num3[] = {7,8,9};
		ListNode node1 = generateLinked(num);
		ListNode node2 = generateLinked(num2);
		ListNode node3 = generateLinked(num3);
		//ListNode nodelist[] = {node1, node2, node3};
		
		mergeKLists(null);
;		
	}
	
}
