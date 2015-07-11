package main;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.kerberos.KerberosKey;

public class WordDictionary {

	TrieNode root;
	
	
	public WordDictionary() {
		root = new TrieNode();
	}
	
	
	// Adds a word into the data structure.
    public void addWord(String word) {
    	
    	TrieNode t = root;
		for(int i = 0 ; i < word.length(); i++ ) {
			if(t.childrenList[word.charAt(i)-'a'] == null) {
				t.childrenList[word.charAt(i)-'a'] = new TrieNode();;
			}
			t = t.childrenList[word.charAt(i)-'a'];
		}
		t.isLeaf = true;
        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	
    	List<TrieNode> list = new ArrayList<TrieNode>();
    	
    	TrieNode t = root;
    	list.add(t);
		for(int i = 0 ; i < word.length(); i++ ) {
			
			List<TrieNode> list2 = new ArrayList<TrieNode>();
			
			if(word.charAt(i) == '.') {	
				for(TrieNode node : list) {
					for(int k = 0 ; k < 26; k++) {
						if(node.childrenList[k] != null) {
							list2.add(node.childrenList[k]);
						}
					}
				}
			}
			
			else {
				for(TrieNode node : list) {
					if(node.childrenList[word.charAt(i)-'a'] != null)
						list2.add(node.childrenList[word.charAt(i)-'a']);
				}
			}
			
			list.clear();
			list = list2;
			
			if(list.isEmpty())
				return false;		
		}
		
		for(TrieNode node : list)
			if(node.isLeaf)
				return true;
		
		return false;
        
    }
}
