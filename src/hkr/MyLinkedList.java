package hkr;

public class MyLinkedList {

	private class SinglyLinkedListNode {
		private SinglyLinkedListNode next;
		private int data;

		public SinglyLinkedListNode() {
		}

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	private SinglyLinkedListNode node;

	public void add(int number) {
		if (node == null) {
			node = new SinglyLinkedListNode();
			node.data = number;
			return;
		}

		SinglyLinkedListNode temp = node;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new SinglyLinkedListNode();
		temp.next.data = number;
	}

	public MyLinkedList reverse(MyLinkedList list) {
		SinglyLinkedListNode temp = list.node;
		SinglyLinkedListNode rev = null;
		while (temp != null) {
			SinglyLinkedListNode newNode = new SinglyLinkedListNode();
			newNode.data = temp.data;
			newNode.next = rev;
			rev = newNode;
			temp = temp.next;
		}
		MyLinkedList newList = new MyLinkedList();
		newList.node = rev;
		return newList;
	}

	public SinglyLinkedListNode insertNodeAtPosition(MyLinkedList head, int data, int position) {
		return insertNodeAtPosition(head.node, data, position);
	}

	public SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
		SinglyLinkedListNode temp = head;
		int count = 0;
		while (temp != null) {
			if (count == position - 1) {
				if (count == 0) {
					SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
					newNode.next = head;
					return head;
				} else {
					SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
					newNode.next = head;
					SinglyLinkedListNode temp1 = temp.next;
					temp.next = newNode;
					temp.next.next = temp1;
					return head;
				}
			}
			temp = temp.next;
			count++;
		}
		return null;
	}

	public boolean isPalindrome() {
		SinglyLinkedListNode list1 = node;
		SinglyLinkedListNode list2 = node;
		SinglyLinkedListNode rev = null;
		while ((list2 != null) && (list2.next != null)) {
			SinglyLinkedListNode n = new SinglyLinkedListNode();
			n.data = list1.data;
			n.next = rev;
			rev = n;
			list1 = list1.next;
			list2 = list2.next.next;
		}

		if (list2 != null) {
			list1 = list1.next;
		}

		// now loop over list1 and compate the elements
		while (list1 != null) {
			if (list1.data == rev.data) {
				list1 = list1.next;
				rev = rev.next;
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		SinglyLinkedListNode temp = node;
		while (temp.next != null) {
			sb.append(temp.data + " : ");
			temp = temp.next;
		}
		sb.append(temp.data + " : ");
		return sb.toString();
	}

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		System.out.println(ll);
		SinglyLinkedListNode sn = ll.insertNodeAtPosition(ll.node, 7, 5);
		System.out.println(sn);
	}

}
