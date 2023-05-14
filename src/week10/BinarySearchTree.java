package week10;

public class BinarySearchTree {
	class Node {
		int key;
		char data;
		Node leftChild;
		Node rightChild;
		Node parent;

		Node(int key) {
			this.key = key;
			this.leftChild = null;
			this.rightChild = null;
			this.parent = null;
		}

		Node(Node lc, int key, Node rc) {
			this.key = key;
			this.leftChild = lc;
			this.rightChild = rc;

		}

		public String toString() {// public 이유: object 오버라이딩(상속받은 함수) 한 거라 바꿀 수 없음
			return "" + key; // string 타입으로 데이터 반환
		}
	}

	Node root;

	public BinarySearchTree() { // 생성자
		root = null;
	}

	public void insert(int key) {
		if (root == null)
			root = new Node(key);
		else
			insert(root, key, null);
	}

	private void insert(Node node, int k, Node parent) {
		if (node == null) { // 빈자리를 찾은 것임.
			// insert here
			Node newNode = new Node(k);
			if (k < parent.key) {
				parent.leftChild = newNode;
				newNode.parent = parent;
			} else { // 그게 아니면 오른쪽
				parent.rightChild = newNode;
				newNode.parent = parent;
			}
		} else if (k < node.key) { // follow left child
			insert(node.leftChild, k, node); // parent == node
		} else {
			insert(node.rightChild, k, node);
		}
	}

	public boolean search(int k) {
		return search(root, k);
	}

	private boolean search(Node node, int key) {
		if (node == null)
			return false;
		if (node.key == key)
			return true;
		else if (node.key > key)
			return search(node.leftChild, key);
		else
			return search(node.rightChild, key);
	}

	public Node searchNode(Node node, int k) {
		if (node == null) {
			return null;
		}
		if (node.key == k) {
			return node;
		} else if (k < node.key) {
			return searchNode(node.rightChild, k);
		} else
			return searchNode(node.leftChild, k);
	}

	public void delete(int k) {
		delete(root, k);
	}

	private void delete(Node startNode, int k) {
		Node node = searchNode(startNode, k);
		if (node != null) {
			// case1: degree == 0 -> 나를 없애 == 내 부모가 나를 가르키는 링크를 끊어
			if (node.leftChild == null && node.rightChild == null) {
				// if (node == node.parent.leftChild) { 아래 코드와 같은 의미의 코드
				if (node.key < node.parent.key) { // 만약 왼쪽이라면
					node.parent.leftChild = null;
				} else
					node.parent.rightChild = null; // 만약 오른쪽이라면
			}
			// case2: degree == 1 / 어떤 하나가 null인 경우
			else if (node.leftChild == null) {

				if (node.key < node.parent.key) { // 만약 왼쪽이라면
					node.parent.leftChild = node.rightChild;
				} else
					node.parent.rightChild = node.rightChild;

			} else if (node.rightChild == null) {
				if (node.key > node.parent.key) { // 만약 왼쪽이라면
					node.parent.leftChild = node.leftChild;
				} else
					node.parent.rightChild = node.leftChild;
			}
			// case 3: degree == 2
			else {
				Node p = successor(node);
				node.key = p.key;
				delete(node.rightChild, p.key);
			}
		}
	}

	public Node successor(Node node) {
		if (node != null) {
			Node p = node.rightChild;
			while (p.leftChild != null) {
				p = p.leftChild;
				return p;
			}
		}
		return null;
	}

	public Node predecessor(Node node) {
		if (node != null) {
			Node p = node.leftChild;
			while (p.rightChild != null) {
				p = p.rightChild;
				return p;
			}
		}
		return null;
	}

	public void showTree() { // inorder
		showTree(root);
		System.out.println();
	}

	private void showTree(Node p) { // tree에서 recursion 불가피 : iteration 횟수 모르니까 (무지 중요)
		if (p != null) { // 기저 조건 해결
			showTree(p.leftChild);
			System.out.print(p.key);
			showTree(p.rightChild); // 라이트도 해야지
		}
	}

	public static void main(String[] args) {
		int[] keys = { 4, 7, 5, 1, 0, 3, 9, 2, 6, 8 };

		BinarySearchTree t = new BinarySearchTree();

		for (int i = 0; i < keys.length; i++) {
			t.insert(i);
		}

		t.showTree();

		System.out.println(t.search(3)); // true , false 가 출력됨 - true
		System.out.println(t.search(11)); // true , false 가 출력됨 - false4

		t.delete(3);
		t.showTree();
	}
}
