package cci;

public class MyLinkedList {

	private class Node {
		private Node next;
		private int data;
	}

	private Node node;

	public void add(int number) {
		if (node == null) {
			node = new Node();
			node.data = number;
			return;
		}

		Node temp = node;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node();
		temp.next.data = number;
	}

	public MyLinkedList reverse(MyLinkedList list) {
		Node temp = list.node;
		Node rev = null;
		while (temp != null) {
			Node newNode = new Node();
			newNode.data = temp.data;
			newNode.next = rev;
			rev = newNode;
			temp = temp.next;
		}
		MyLinkedList newList = new MyLinkedList();
		newList.node = rev;
		return newList;
	}

	public boolean isPalindrome() {
		Node list1 = node;
		Node list2 = node;
		Node rev = null;
		while ((list2 != null) && (list2.next != null)) {
			Node n = new Node();
			n.data = list1.data;
			n.next = rev;
			rev = n;
			list1 = list1.next;
			list2 = list2.next.next;
		}
		
		if(list2 != null){
			list1 = list1.next;
		}
		
		//now loop over list1 and compate the elements
		while(list1 != null){
			if(list1.data == rev.data){
				list1 = list1.next;
				rev = rev.next;
			}else{
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node temp = node;
		while (temp.next != null) {
			sb.append(temp.data + " : ");
			temp = temp.next;
		}
		sb.append(temp.data + " : ");
		return sb.toString();
	}

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(40);
		ll.add(30);
		ll.add(20);
		ll.add(10);
//		System.out.println(ll.reverse(ll));
		 System.out.println(ll);
		 System.out.println(ll.isPalindrome());
	}

}
