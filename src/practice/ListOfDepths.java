package practice;

import java.util.ArrayList;
import java.util.List;

public class ListOfDepths {

	private class Tree {
		private Tree left, right;
		private int data;
	}

	private Tree node;
	List<List<Integer>> levelLists = new ArrayList<>();

	public void add(int num) {
		node = add(num, this.node);
	}

	private Tree add(int num, Tree node) {
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

	public void createListAtDepth() {

	}

	public void preorder() {
		preorder(this.node,0);
	}

	private void preorder(Tree node,int level) {
		if (null == node) {
			return;
		}
		List<Integer> levelList = null;
		if(level==levelLists.size()){
			levelList = new ArrayList<>();
			levelList.add(node.data);
			levelLists.add(levelList);
		}else{
			levelList = levelLists.get(level);
			levelList.add(node.data);
		}
		System.out.println(node.data + ":"+level);
		preorder(node.left,level+1);
		preorder(node.right,level+1);
	}
	
	public static void main(String[] args) {
		ListOfDepths dTree = new ListOfDepths();
		dTree.add(50);
		dTree.add(40);
		dTree.add(60);
		dTree.add(30);
		dTree.add(45);
		dTree.add(50);
		dTree.add(65);
		dTree.preorder();
		System.out.println("complete");
	}
}
