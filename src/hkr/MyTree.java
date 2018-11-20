package hkr;

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
		if(root == null){
			return 0;
		}
		int height= 0;
		height+=Math.max(height(root.left),height(root.right));
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
	

	public static void main(String[] args) {
		MyTree tree = new MyTree();
		tree.add(80);
		tree.add(50);
		tree.add(100);
		System.out.println(tree);
	}

}
