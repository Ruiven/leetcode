package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};


public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null)
			return null;
		
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		Stack<UndirectedGraphNode> stack = new Stack<>();
		
		stack.push(node);
		UndirectedGraphNode resNode = new UndirectedGraphNode(node.label);
		
		map.put(node, resNode);
		
		while(!stack.empty()) {
			UndirectedGraphNode temp = stack.pop();
			
			for(UndirectedGraphNode i : temp.neighbors) {
				if(map.get(i) == null) {
					UndirectedGraphNode resNei = new UndirectedGraphNode(i.label);
					map.put(i, resNei);
					map.get(temp).neighbors.add(resNei);
					stack.push(i);
				}
				
				else {
					map.get(temp).neighbors.add(map.get(i));
				}
				
			}
		}
		return resNode;
    }
}
