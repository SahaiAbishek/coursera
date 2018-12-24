package practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MyPracticeTree {

	private class Node {
		private int data;
		private Node left, right;

		@SuppressWarnings("unused")
		public Node() {
		}

		public Node(int data) {
			this.data = data;
		}
	}

	private Node node = null;
	private Map<Integer, List<Integer>> elemMap = new HashMap<>();

	public Map<Integer, List<Integer>> getElemMap() {
		return elemMap;
	}

	public void setElemMap(Map<Integer, List<Integer>> elemMap) {
		this.elemMap = elemMap;
	}

	public void insert(int num) {
		node = insert(node, num);
	}

	private Node insert(Node head, int num) {
		if (head == null) {
			head = new Node(num);
			return head;
		}

		if (head.data > num) {
			head.left = insert(head.left, num);
		} else {
			head.right = insert(head.right, num);
		}
		return head;
	}

	public void preorder() {
		preorder(this.node);
	}

	private void preorder(Node head) {
		if (head == null)
			return;
		preorder(head.left);
		System.out.println(head.data);
		preorder(head.right);
	}

	public void ineorder() {
		inorder(this.node);
	}

	private void inorder(Node head) {
		if (head == null)
			return;
		System.out.print("  " + head.data);
		inorder(head.left);
		inorder(head.right);
	}

	public void printBFS() {
		bfs(this.node);
		;
	}

	private void bfs(Node head) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(head);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			System.out.print(" " + n.data);

			if (n != null && n.left != null)
				queue.add(n.left);

			if (n != null && n.right != null)
				queue.add(n.right);

		}
	}

	public int getElementsAtHeight() {
		return getElementsAtHeight(node, 1);
	}

	private int getElementsAtHeight(Node n, int height) {
		if (n == null) {
			return 0;
		}
		int lHeight = height;
		lHeight = 1 + getElementsAtHeight(n.left, height + 1);
		int rHeight = height;
		rHeight = 1 + getElementsAtHeight(n.right, height + 1);
		if (lHeight == rHeight) {
			if (elemMap.containsKey(height)) {
				List<Integer> lst = elemMap.get(height);
				lst.add(n.data);
				elemMap.put(height, lst);
			} else {
				List<Integer> lst = new ArrayList<>();
				lst.add(n.data);
				elemMap.put(height, lst);
			}
			// System.out.println("height +" + height + " : " + n.data);
		}

		return Math.max(lHeight, rHeight);

	}

	public int min() {
		return min(this.node);
	}

	private int min(Node n) {
		if (n == null) {
			return 0;
		}
		while (n.left != null) {
			n = n.left;
		}
		return n.data;
	}
	
	private Node minNode(Node n) {
		if (n == null) {
			return null;
		}
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}

	public int findCommonAncestor(int num1, int num2) {
		return findCommonAncestor(node, num1, num2).data;
	}

	private Node findCommonAncestor(Node root, int num1, int num2) {
		if (root == null) {
			return null;
		}

		if (num1 < root.data && num2 < root.data) {
			root = findCommonAncestor(root.left, num1, num2);
		} else if (num1 > root.data && num2 > root.data) {
			root = findCommonAncestor(root.right, num1, num2);
		}
		return root;
	}

	public int distanceFromRoot(int num) {
		return distanceFromRoot(node, num, 0);
	}

	private int distanceFromRoot(Node root, int num, int dist) {
		if (root == null) {
			return -1;
		}
		int distance = dist;
		if (num < root.data) {
			return distanceFromRoot(root.left, num, dist + 1);
		} else if (num > root.data) {
			return distanceFromRoot(root.right, num, dist + 1);
		}
		return distance;
	}

	public int distanceBetweenNodes(int num1, int num2) {
		if (isValid(node, num1) && (isValid(node, num2))) {
			Node parentNode = findCommonAncestor(node, num1, num2);
			System.out.println(parentNode.data);
			int d1 = distanceFromRoot(parentNode, num1, 0);
			System.out.println("d1 : " + d1);
			int d2 = distanceFromRoot(parentNode, num2, 0);
			System.out.println("d2 : " + d2);
			return d1 + d2;
		} else {
			System.out.println("Please enter valid Nodes");
			return -1;
		}
	}

	private boolean isValid(Node root, int num) {
		if (root == null) {
			return false;
		}
		if (num < root.data) {
			return isValid(root.left, num);
		} else if (num > root.data) {
			return isValid(root.right, num);
		} else {
			return true;
		}
	}

	public void delete(int num) {
		this.node = delete(node, num);
	}

	private Node delete(Node root, int num) {
		if (root == null) {
			return null;
		}

		if (num < root.data) {
			root.left = delete(root.left, num);
		} else if (num > root.data) {
			root.right = delete(root.right, num);
		} else {
			if (root.right == null) {
				return root.left;
			}
			if (root.left == null) {
				return root.right;
			}
			
			Node temp = root;
			root = minNode(temp.right);
			root.right = deleteMin(temp.right);
			root.left = temp.left;
			

		}

		return root;
	}

	public void deleteMin() {
		this.node = deleteMin(node);
	}

	private Node deleteMin(Node root) {
		if (root.left == null) {
			return null;
		}
		
		root.left = deleteMin(root.left);
		
		return root;
	}

	public static void main(String[] args) {
		MyPracticeTree tree = new MyPracticeTree();
		tree.insert(50);
		tree.insert(40);
		tree.insert(70);
		tree.insert(45);
		tree.insert(35);
		tree.insert(60);
		tree.insert(80);
		tree.insert(42);
		tree.insert(41);
		tree.insert(43);

		tree.ineorder();

		tree.delete(40);
		System.out.println();
		System.out.println("---------");
		tree.ineorder();
	}
}
