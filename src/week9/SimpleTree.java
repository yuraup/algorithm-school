package week9;

public class SimpleTree {
	// 노드는 일반사용자에게 오픈 X
	char[] array;

	class Node {
		char data;
		Node leftChild;
		Node rightChild;

		Node(char d) { // 생성자
			data = d;
			leftChild = null;
			rightChild = null;
		}

		Node(Node lc, char d, Node rc) { // 생성자 lc = leftChild
			data = d;
			leftChild = lc;
			rightChild = rc;
		}

		public String toString() {// public 이유: object 오버라이딩(상속받은 함수) 한 거라 바꿀 수 없음
			return "" + data; // string 타입으로 데이터 반환
		}
	}

	Node root; // 맨 위에 있는 root 노드

	SimpleTree() {
		root = null;
		array = new char[10];
	}
//	
//	public Node mainTree(char ch) { //char 받아옴 
//		root = new Node(ch);
//		return root;
//	}
//	

	public Node makeTree(char ch) {
		root = new Node(ch);
		return root;
	}

	public Node makeTree(SimpleTree leftSubTree, char ch, SimpleTree rightSubTree) { // char 받아옴
		// 실제로 root는 노드가 아니라 tree임.
		root = new Node(leftSubTree.root, ch, rightSubTree.root);
		return root;
	}

	public void ShowTree() {
		// 불러온 객체의 root부터 시작
//		System.out.print(root.toString());
//		//어느 한 노드에서의 operation을 정의하고, 이게 null이 아닐 때까지만 반복 
//		print leftChild, rightChild;
		showTree(root); // recursion

	}

	private void showTree(Node p) { // tree에서 recursion 불가피 : iteration 횟수 모르니까 (무지 중요)
		if (p != null) { // 기저 조건 해결
			showTree(p.leftChild); // 내 왼쪽 놈에도 이짓을 똑같이 해줘?!?!
			System.out.print(p.data);
			showTree(p.rightChild); // 라이트도 해야지
		}

	}

	// *1+1의 관계가 유지되려면 시작이 1이어야 함. 0 안 돼
	public void toArray() {

		toArray(root, 1);

		System.out.println();
		for (int i = 1; i <= 7; i++)
			System.out.print("[" + i + "]" + array[i] + " ");
	}

	private void toArray(Node p, int index) {
		if (p != null) {
			array[index] = p.data;
			toArray(p.leftChild, index * 2);
			toArray(p.rightChild, index * 2 + 1);
		}
	}

	public static void main(String[] args) {
		SimpleTree t1 = new SimpleTree();
		t1.makeTree('a');
		SimpleTree t2 = new SimpleTree();
		t2.makeTree('b');
		SimpleTree t3 = new SimpleTree();
		t3.makeTree('c');
		SimpleTree t4 = new SimpleTree();
		t4.makeTree('d');

		// 이제 엮어야 됨
		SimpleTree t5 = new SimpleTree();
		t5.makeTree(t1, '+', t2); // char = ' '

		SimpleTree t6 = new SimpleTree();
		t6.makeTree(t3, '%', t4);

		SimpleTree t7 = new SimpleTree();
		t7.makeTree(t5, '+', t6);

		t7.ShowTree();
		t7.toArray();
	}
}
