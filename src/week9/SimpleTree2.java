package week9;

public class SimpleTree2 {
	char[] array;

	class Node {
		char data;
		Node leftChild;
		Node rightChild;
		Node parent;

		Node(char d) {
			data = d;
			leftChild = null;
			rightChild = null;
			parent = null;
		}

		Node(Node lc, char d, Node rc) {
			data = d;
			leftChild = lc;
			rightChild = rc;
			parent = null;
			if (lc != null)
				lc.parent = this; // 왼쪽 자식 노드의 부모
			if (rc != null)
				rc.parent = this; // 오른쪽 자식 노드의 부모
		}

		public String toString() {
			return "" + data;
		}
	}

	Node root;

	SimpleTree2() {
		root = null;
		array = new char[10];
	}

	public Node makeTree(char ch) {
		root = new Node(ch);
		return root;
	}

	public Node makeTree(SimpleTree2 leftSubTree, char ch, SimpleTree2 rightSubTree) {
		root = new Node(leftSubTree.root, ch, rightSubTree.root);
		return root;
	}

	public void showTree() {
		showTree(root);
	}

	private void showTree(Node node) {
		if (node != null) {
			showTree(node.leftChild);
			System.out.print(node.data);
			showTree(node.rightChild);
		}
	}

	public void toArray() {
		toArray(root, 1);
		System.out.println();
		for (int i = 1; i <= 7; i++)
			System.out.print("[" + i + "]" + array[i] + " ");
	}

	private void toArray(Node node, int index) {
		if (node != null) {
			array[index] = node.data;
			toArray(node.leftChild, index * 2);
			toArray(node.rightChild, index * 2 + 1);
		}
	}

	public static void main(String[] args) {
		SimpleTree2 t1 = new SimpleTree2();
		t1.makeTree('a');
		SimpleTree2 t2 = new SimpleTree2();
		t2.makeTree('b');
		SimpleTree2 t3 = new SimpleTree2();
		t3.makeTree('c');
		SimpleTree2 t4 = new SimpleTree2();
		t4.makeTree('d');

		SimpleTree2 t5 = new SimpleTree2();
		t5.makeTree(t1, '+', t2);

		SimpleTree2 t6 = new SimpleTree2();
		t6.makeTree(t3, '%', t4);

		SimpleTree2 t7 = new SimpleTree2();
		t7.makeTree(t5, '+', t6);

		t7.showTree();
		t7.toArray();
	}
}