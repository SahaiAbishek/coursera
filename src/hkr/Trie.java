package hkr;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Trie {

	private class Node {
		private Map<Character, Node> children = new HashMap<>();
		private boolean isCompleteWord = false;
	}

	private Node node;

	public void add(Character c) {
		if (node == null) {
			node = new Node();
			node.children.put(c, node);
		} else {
			node.children.put(c, node);
		}
	}

	@Override
	public String toString() {
		Map<Character, Node> map = node.children;
		Iterator<Entry<Character, Node>> itr = map.entrySet().iterator();
		while(itr.hasNext()){
			Entry<Character, Node> entry = itr.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		return super.toString();
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		String str = "hack";
		for (int i = 0; i < str.length(); i++) {
			trie.add(str.charAt(i));
		}

		System.out.println(trie);

	}

}
