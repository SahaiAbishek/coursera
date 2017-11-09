package coursera;

import java.util.ArrayList;
import java.util.List;

public class MyTree {

	private List<Integer> lst = new ArrayList<>();

	private class Node {
		private Node left, right;
		private int value;
	}

	private Node node;

	public void insert(int value) {
		node = insert(node, value);
	}

	public Node insert(Node node, int value) {
		if (node == null) {
			node = new Node();
			node.value = value;
			return node;
		}
		if (value < node.value) {
			node.left = insert(node.left, value);
		} else if (value > node.value) {
			node.right = insert(node.right, value);
		}
		return node;
	}

	public void inorder() {
		inorder(node);
	}

	public void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		lst.add(node.value);
		inorder(node.right);
	}

	@Override
	public String toString() {
		inorder();
		return lst.toString();
	}

	public int size() {
		inorder();
		return lst.size();
	}

	public int maxDepth() {
		return maxDepth(node);
	}

	private int maxDepth(Node node) {
		if (node == null) {
			return 0;
		}
		return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
	}

	public int min() throws Exception {
		return min(node);
	}

	private int min(Node node) throws Exception {
		if (node == null) {
			throw new Exception("No values in node");
		}
		while (node.left != null) {
			node = node.left;
		}

		return node.value;
	}

	// private Node min(Node node) throws Exception {
	// if (node == null) {
	// return null;
	// }
	// Node minNode = min(node.left);
	//
	// return minNode;
	// }

	public int floor(int num) {
		Node x = floor(node, num);
		if (x == null) {
			return 0;
		}

		return x.value;
	}

	private Node floor(Node node, int num) {
		if (node == null) {
			return null;
		}

		if (num == node.value) {
			return node;
		}

		if (num < node.value) {
			return floor(node.left, num);
		}

		Node tmp = floor(node.right, num);
		if (tmp != null) {
			return tmp;
		} else {
			return node;
		}

	}

	public static void main(String[] args) throws Exception {
		MyTree tree = new MyTree();
		tree.insert(50);
		tree.insert(40);
		tree.insert(30);
		tree.insert(60);
		tree.insert(70);
		tree.insert(45);
		tree.insert(55);
		tree.insert(80);
		tree.insert(90);

		System.out.println("Size : " + tree.size());
		System.out.println("Depth : " + tree.maxDepth());
		System.out.println("Min : " + tree.min());
		System.out.println("Floor  : " + tree.floor(65));
	}

}
