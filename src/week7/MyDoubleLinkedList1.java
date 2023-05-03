package week7;

import week6.MyLinkedList0;

public class MyDoubleLinkedList1 {
	private class Node {
		int data;
		Node next;
		Node prev; // 앞 가르킴

		private Node(int value) {
			data = value;
			prev = null;
			next = null;
		}
	}

	Node first;
	Node last; // prev
	int nOfNodes;

	public MyDoubleLinkedList1() {
		first = null; // 아무것도 가르킬 게 없음
		last = null;
		nOfNodes = 0;
	}

	public void addFirst(int value) {
		// 한 개라도 있는 경우와 없는 경우를 나눠야 함
		Node newNode = new Node(value);
		if (first == null) { // nOfNodes 넣어도 됨
			first = newNode;
			last = newNode;
//			nOfNodes++; // 1개 추가됨

		} else { // 1개라도 있었다.
			// 다음 거의 prev가 앞 Node를 가리키게 만들어주는 걸 만들어야 함 == 0과 차이
			newNode.next = first;
			first.prev = newNode;

			first = newNode;
			// prev를 건드릴 필요가 있을까? 만일, linkedList로 만들면 건드려야 함.
			// 근데 우리는 맨끝에서 끊어지는 LinkedList라 건드릴 필요 없음
			// last 건드릴 필요는? 얘도 없음 , 주소값이 변경되면 건드려야겠지만 -> 이 필기들이 갈곳을 잃었따
			nOfNodes++;
		}
	}

	public void addLast(int value) { // arrayList에서 제일 간단, addFirst와 대칭되게 구현
		Node newNode = new Node(value);
		if (last == null) { // 새 거 만들어
			first = new Node(value);
			last = new Node(value);
		} else {
			newNode.prev = last;
			last.next = newNode;
			last = newNode;
			nOfNodes++;
		}
//		nOfNodes++;
	}

	private void add(int index, int value) {
		// index의 유효성 체크
		if (index < 0 || index > nOfNodes) { // 인덱스가 범위보다 작거나 클 때 . 같을때는 범위 포함 아님
			return;
		}
		if (index == 0) { // 인덱스가 처음이면 원래 메소드 사용 (맨앞)
			addFirst(value);
		} else if (index == nOfNodes - 1) {// 맨 뒤에 넣으라는 의미는 n-1에 넣어라 (맨뒤)
			addLast(value);
		} else { // index번째 찾기
			Node p = first;
			for (int i = 0; i < index - 1; i++) { // index == index-1 , 내부 코드는 달라짐
				p = p.next;
			}
			Node newNode = new Node(value);
			p.next = newNode;
			newNode.prev = p;
			p.next.prev = newNode;
			newNode.next = p.next;
		}
		nOfNodes++;
	}

	// remove는 숙제 ... 시험 공부로 해라

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

	private int indexOf(int value) {
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

	private int size() { // 손 안 대도 됨
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
