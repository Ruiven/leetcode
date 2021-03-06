package main;

public class Trie {

	TrieNode root;
	
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {	
		TrieNode t = root;
		for(int i = 0 ; i < word.length(); i++ ) {
			if(t.childrenList[word.charAt(i)-'a'] == null) {
				t.childrenList[word.charAt(i)-'a'] = new TrieNode();;
			}
			t = t.childrenList[word.charAt(i)-'a'];
		}
		t.isLeaf = true;
	}
	
	public boolean search(String word) {
		
		TrieNode t = root;
		for(int i = 0 ; i < word.length(); i++ ) {
			if(t.childrenList[word.charAt(i)-'a'] == null) {
				return false;
			}
			t = t.childrenList[word.charAt(i)-'a'];
		}
		
		if(!t.isLeaf)
			return false;
		
		return true;
	}
	
	public boolean startsWith(String prefix) {
		TrieNode t = root;
		for(int i = 0 ; i < prefix.length(); i++ ) {
			if(t.childrenList[prefix.charAt(i)-'a'] == null) {
				return false;
			}
			t = t.childrenList[prefix.charAt(i)-'a'];
		}
		
		return true;
	}
	
	
	
}
