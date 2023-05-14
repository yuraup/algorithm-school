package week10;

public class levelOrderTree { // 못해도 감점 안 하는데 해봐야 는다.
	// 노드는 일반사용자에게 오픈 X
	char[] array;
	int count;

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

	levelOrderTree() {
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

	public Node makeTree(levelOrderTree leftSubTree, char ch, levelOrderTree rightSubTree) { // char 받아옴
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

	public int getNodeCount() {
		return getNodeCount(root);
	}

	private int getNodeCount(Node node) { // 내 밑에 있는 거의 노드 개수
		if (node == null) {
			return 0;
		} else {
			return 1 + getNodeCount(node.leftChild) + getNodeCount(node.rightChild);
		}
	}

	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(Node node) {
		if (node == null) {
			return 0;
		} else {
			// 데이터 구조가 복잡해지면 재귀적으로 보는 습관
			return 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
		}
	}

	public void delete(char d) {
		delete(root, d, null);// root부터 시작해서 d를 찾아야 해, 근데 이때 parent는 누구야 //root의 parent는 null
	}

	private void delete(Node node, char d, Node parent) { // terminal node만 delete 가능
		if (node != null) {
			if (node.data == d) {
				// delete this!
				if (parent.leftChild == node) {
					parent.leftChild = null; // 해당 내용을 지우는 동작
				} else {
					parent.rightChild = null;
				}
			}
		}
	}

	private Node search(Node node, char d) {
		// null이 아니어야만 value 체크 가능
		if (node != null) {
			if (d == node.data) {
				return node;
			} else {// 일반적인 상황은 아님
				// 왼쪽 찾고 없으면 return null
				Node temp = search(node.leftChild, d);
				if (temp != null) {
					return temp;
				} else {
					return search(node.rightChild, d);
				}
			}
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		levelOrderTree t1 = new levelOrderTree();
		t1.makeTree('a');
		levelOrderTree t2 = new levelOrderTree();
		t2.makeTree('b');
		levelOrderTree t3 = new levelOrderTree();
		t3.makeTree('c');
		levelOrderTree t4 = new levelOrderTree();
		t4.makeTree('d');

		// 이제 엮어야 됨
		levelOrderTree t5 = new levelOrderTree();
		t5.makeTree(t1, '+', t2); // char = ' '

		levelOrderTree t6 = new levelOrderTree();
		t6.makeTree(t3, '%', t4);

		levelOrderTree t7 = new levelOrderTree();
		t7.makeTree(t5, '+', t6);

		t7.ShowTree();
		t7.toArray();

		System.out.println(t7.getNodeCount());
		System.out.println(t7.getHeight());

		t7.delete('a');

	}
}
