package cci.udmy;

public class MyTree {

	private class Tree {
		private Tree left;
		private Tree right;
		private int data;
	}

	private Tree node;

	public void add(int num) {
		node = add(num, node);
	}

	public Tree add(int num, Tree node) {

		if (node == null) {
			node = new Tree();
			node.data = num;
			return node;
		}

		if (num < node.data) {
			node.left = add(num, node.left);
		} else {
			node.right = add(num, node.right);
		}
		return node;
	}

	public int height(Tree root) {
		if (root == null) {
			return 0;
		}
		int height = 0;
		height += Math.max(height(root.left), height(root.right));
		return height;
	}

	public boolean isBST(Tree root) {
		return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	public boolean isBST(Tree root, int max, int min) {
		if (root == null) {
			return true;
		}

		if (root.data <= min || root.data >= max) {
			return false;
		}

		return (isBST(root.left, root.data, min) && isBST(root.right, max, root.data));
	}

	public void inorder() {
		inorder(this.node);
	}

	private void inorder(Tree root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		inorder(root.left);
		inorder(root.right);
	}

	public void invertTree() {
		invertTree(this.node);
	}

	public Tree invertTree(Tree root) {
		if (root != null) {
			helper(root);
		}

		return root;
	}

	private void helper(Tree root) {
		if (root == null) {
			return;
		}
		Tree temp = root.left;
		root.left = root.right;
		root.right = temp;
		helper(root.left);
		helper(root.right);
	}

	public boolean isSameTree(Tree p, Tree q) {
		if (p == null && q == null) {
			return true;
		}

		if ((p != null && q != null)
				&& (p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		MyTree tree = new MyTree();
		tree.add(4);
		tree.add(2);
		tree.add(7);
		tree.add(1);
		tree.add(3);
		tree.add(6);
		tree.add(9);
		tree.inorder();

		tree.invertTree();
		tree.inorder();
	}

}
