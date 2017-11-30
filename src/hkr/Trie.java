package hkr;

import java.util.Scanner;

public class Trie {

	private static class Node {
		private Node[] arr = new Node[26];
		// private boolean isWord = false;
		private int count = 0;
	}

	private static Node root = new Node();

	public static void add(String word) {

		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			Character currentChar = word.charAt(i);
			int index = currentChar - 'a';
			if (node.arr[index] == null) {
				Node temp = new Node();
				temp.count = 1;
				node.arr[index] = temp;
				node = temp;
			} else {
				
				node = node.arr[index];
				node.count++;
			}
			// node.isWord = true;
		}
	}

	public static int find(String word) {
		int count = 0;
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			Character currentChar = word.charAt(i);
			int index = currentChar - 'a';
			if (node.arr[index] == null) {
				return 0;
			} else {
				node = node.arr[index];
			}
			count = node.count;
		}
		return count;
	}

	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        for(int a0 = 0; a0 < n; a0++){
	            String op = in.next();
	            String contact = in.next();
	            if(op.equals("add")){
		            	add(contact);
		            }else if(op.equals("find")){
		            	System.out.println(find(contact));
		            }
	        }
	}

}
