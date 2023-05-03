package week6;

public class MyLinkedList0 {

	public class Node {
		int data;
		Node next;

		public Node(int value) {
			data = value;
			next = null;
		}
	}

	Node first;
	int nOfNodes;

	public MyLinkedList0() {
		first = null;
		nOfNodes = 0;
	}

	public void addLast(int value) {
		Node p = first;
		if (p == null) {
			first = new Node(value);
		} else {
			while (p.next != null) {
				p = p.next;
			}
			// p <= last node
			p.next = new Node(value);
		}
		nOfNodes++;
	}

	public void addFirst(int value) {
		Node newNode = new Node(value);
		newNode.next = first;
		first = newNode;
		nOfNodes++;

	}

	private void add(int index, int value) {
		if (index < 0 || index >= nOfNodes)
			return;
		if (index == 0)
			addFirst(value);
		else {
			Node p = first;
			for (int i = 0; i < index - 1; i++)
				p = p.next;
			Node newNode = new Node(value);
			newNode.next = p.next;
			p.next = newNode;
		}
		nOfNodes++;

	}

	private int removeFirst() {
		int res = 0;
		if (nOfNodes > 0) {
			res = first.data;
			first = first.next;
			nOfNodes--;
		}
		return res;
	}

	private int remove(int index) {
		if (index < 0 || index >= nOfNodes)
			return -9999;
		int res = 0;
		if (index == 0)
			removeFirst();
		else {
			Node p = first;
			for (int i = 0; i < index - 1; i++)
				p = p.next;

			res = p.next.data;

			p.next = p.next.next;

		}
		nOfNodes--;
		return res;
	}

	private int removeLast() {
		return remove(nOfNodes - 1);
	}

	private void set(int index, int value) {
		if (index < 0 || index >= nOfNodes)
			return;
		Node p = first;
		for (int i = 0; i < index; i++)
			p = p.next;
		p.data = value;
	}

	public int indexOf(int value) {
		Node p = first;

		int res = 0;
		while (p != null) {
			if (p.data == value)
				return res;
			else {
				res++;
				p = p.next;
			}
		}
//		for (int i=0;i<nOfNodes;i++) {
//			if (p.data==value)
//				return i;
//			else
//				p=p.next;
//		}
//		
		return -1;
	}

	private int get(int index) {
		if (index < 0 || index >= nOfNodes)
			return -9999;
		Node p = first;
		for (int i = 0; i < index; i++)
			p = p.next;
		return p.data;
	}

	private int size() {

		return nOfNodes;
	}

	public void showList() {
		Node p = first;
		System.out.println();
		while (p != null) {
			System.out.print(" -> " + p.data);
			p = p.next;
		}
	}

	public static void main(String[] args) {

		int[] data = new int[10];

		for (int i = 0; i < 10; i++)
			data[i] = (int) (Math.random() * 1000); // () 위치! & *1000

		MyLinkedList0 list = new MyLinkedList0();

		for (int i = 0; i < 10; i++)
			list.addLast(data[i]);
		list.showList();

		System.out.println("\n\n After addFirst(300) : ");
		list.addFirst(300);
		list.showList();

		System.out.println("\n\nAfter add(5, 400) : ");
		list.add(5, 400);
		list.showList();

		int index = list.indexOf(400);
		list.set(index, 450);
		System.out.println("\n\n" + index + "-th Value is changed to : " + list.get(index));
		list.showList();

		System.out.println("\n\nSize is : " + list.size());

		list.remove(3); // index =3
		list.remove(450); // key value =450;
		list.showList();

		System.out.println("\n\nFirst & Last Values are deleted ");

		list.removeFirst();
		list.removeLast();
		list.showList();
	}

}
