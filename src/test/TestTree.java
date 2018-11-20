package test;

import java.util.ArrayList;
import java.util.List;

public class TestTree {

	public class Node {
		private Node left;
		private Node right;
		private int data;
	}

	Node node;

	public void insert(int data) {
		node = insert(node, data);
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			Node newNode = new Node();
			newNode.data = data;
			return newNode;
		}
		if (data < node.data) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		return node;
	}

	public void inorder() {
		inorder(this.node);
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.println(node.data);
		inorder(node.right);
	}

	public void preorder() {
		preorder(this.node);
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preorder(node.left);
		preorder(node.right);
	}

	@Override
	public String toString() {
		preorder();
		return super.toString();
	}

	public boolean isBST() {
		return isBST(node, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	private boolean isBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (min < root.data || max > root.data) {
			return false;
		}

		return (isBST(root.left, root.data, max) && isBST(root.right, min, root.data));
	}

	public Node leastCommonAncestor(int num1, int num2) {
		Node retNode = leastCommonAncestor(node, num1, num2);
		return retNode;
	}

	private Node leastCommonAncestor(Node root, int num1, int num2) {
		if (root == null) {
			return null;
		}
		if (num1 < root.data && num2 < root.data) {
			root = leastCommonAncestor(root.left, num1, num2);
			return root;
		}
		if (num1 > root.data && num2 > root.data) {
			root = leastCommonAncestor(root.right, num1, num2);
			return root;
		}
		return root;
	}

	public int distanceFromRoot(int n) {
		return distanceFromRoot(this.node, n, 0);
	}

	private int distanceFromRoot(Node root, int n, int dist) {
		if (root == null) {
			return -1;
		}
		// int len = 0;
		if (root.data == n) {
			return dist;
		}
		if (n < root.data)
			return distanceFromRoot(root.left, n, dist + 1);
		else {
			return distanceFromRoot(root.right, n, dist + 1);
		}
		// return len;
	}

	private int distanceFromRoot(Node root, int num) {
		if (root == null) {
			return -1;
		}
		int dist = 0;
		while (root.data != num) {
			if (num < root.data) {
				root = root.left;
			} else {
				root = root.right;
			}
			dist += 1;
		}
		return dist;
	}

	public int distanceBetweenNodes(int n1, int n2) {
		Node lca = leastCommonAncestor(n1, n2);
		// find distance of n1 from lca
		int d1 = distanceBetweenNodes(lca, n1, 0);
		// find distance of n2 from lca
		int d2 = distanceBetweenNodes(lca, n2, 0);

		return d1 + d2;
	}

	private int distanceBetweenNodes(Node root, int n1, int len) {
		if (null == root) {
			return -1;
		}
		if (root.data == n1) {
			return len;
		}
		int dist = distanceBetweenNodes(root.left, n1, len + 1);
		if (dist == -1) {
			return distanceBetweenNodes(root.right, n1, len + 1);
		}
		return dist;
	}

	// private List<String> path = new ArrayList<>();
	public List<String> printPathFromRoot(int num) {
		return printPathFromRoot(num, this.node, new ArrayList<>());
	}

	private List<String> printPathFromRoot(int num, Node root, ArrayList<String> pathList) {
		if (root == null) {
			return null;
		}

		pathList.add(new Integer(root.data).toString());
		if (num == root.data) {
			return pathList;
		}
		if (num < root.data) {
			return printPathFromRoot(num, root.left, pathList);
		} else {
			return printPathFromRoot(num, root.right, pathList);
		}

		// return pathList;

	}

	boolean checkBST(Node root) {
		return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean checkBSTHelper(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.data > min || root.data < max) {
			return false;
		}
		return checkBSTHelper(root.left, root.data, max) && checkBSTHelper(root.right, min, root.data);
	}

	public static void main(String[] args) {
		TestTree tree = new TestTree();
		tree.insert(6);
		tree.insert(2);
		tree.insert(8);
		tree.insert(0);
		tree.insert(4);
		tree.insert(7);
		tree.insert(9);

		// tree.preorder();
		// System.out.println(tree.isBST());
		// tree.node = tree.leastCommonAncestor(2, 4);
		// System.out.println(tree.node.data);
		//
		// System.out.println("Distance between node : " +
		// tree.distanceBetweenNodes(2, 4));

		// System.out.println("distance from root :" +
		// tree.distanceFromRoot(9));
		List<String> path = tree.printPathFromRoot(12);
		System.out.println(path);
	}
}
