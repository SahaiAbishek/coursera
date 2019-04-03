package lc;

public class RotateList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	private ListNode root;

	public void add(int num) {
		if (root == null) {
			root = new ListNode(num);
			return;
		}
		ListNode temp = root;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new ListNode(num);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		ListNode temp = root;
		sb.append("[");
		while (temp != null) {
			sb.append(temp.val + ",");
			temp = temp.next;
		}
		sb.append("]");
		return sb.toString();
	}

	public void rotateRight(int k) {
		this.root = rotateRight(this.root, k);
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}
		int size = size(head);
		k = k % size;
		k = size - k;
		int count = 1;
		ListNode current = head;
		while (count < k) {
			current = current.next;
			count++;
		}
		ListNode kthNode = current;
		while (current.next != null) {
			current = current.next;
		}
		current.next = head;
		head = kthNode.next;
		kthNode.next = null;
		return head;
	}

	public int size() {
		return size(this.root);
	}

	private int size(ListNode head) {
		int sz = 0;
		ListNode current = head;
		while (current != null) {
			current = current.next;
			sz++;
		}
		return sz;
	}

	public static void main(String[] args) {
		RotateList list = new RotateList();
		list.add(0);
		list.add(1);
		list.add(2);
		// list.add(3);
		// list.add(4);
		// list.add(5);
		list.rotateRight(4);
		System.out.println(list);
	}

}
