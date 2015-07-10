package main;

public class Test {

	
	public static void main(String[] args) {
		Trie tree = new Trie();
		tree.insert("test");
		tree.insert("hello");
		System.out.print(tree.search("hellosfsd"));
		System.out.print(tree.startsWith("hell"));
	}
}
