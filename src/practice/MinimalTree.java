package practice;

public class MinimalTree {

	private class Tree {
		Tree left, right;
		int data;

		public Tree(int d) {
			data = d;
			left = right = null;
		}
	}

	private Tree tree;

	public Tree makeTree(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		if (start > end) {
			return null;
		}
		tree = new Tree(arr[mid]);
		tree.left = makeTree(arr, start, mid - 1);
		tree.right = makeTree(arr, mid + 1, end);
		return tree;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	}

}
