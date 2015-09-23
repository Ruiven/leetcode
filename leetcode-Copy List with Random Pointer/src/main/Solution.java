package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};

public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return null;
	
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		
		RandomListNode origin = head;
		
		RandomListNode dummyCopyHead = new RandomListNode(0);
		RandomListNode copyTail = dummyCopyHead;
		
		while(origin != null) {
			RandomListNode copy = new RandomListNode(origin.label);
			copyTail.next = copy;
			copyTail = copyTail.next;
			map.put(origin, copy);
			
			origin = origin.next;
		}
		
		origin = head;
		
		while(origin != null) {
			if(origin.random != null) {
				map.get(origin).random = map.get(origin.random);
			}
			origin = origin.next;
		}
		
		return dummyCopyHead.next;
		
    }
}
