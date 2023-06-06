package week12;


public class AVLTree2 extends BST {

	public AVLTree2() { 
	//avl == 높이 균형 성질을 만족하는 이진 탐색 트리 
		super();
	}
	//insert, delete 후 균형 깨진 노드를 기준으로 회전을 통해 균형을 맞춘다. 
	//균형이 깨졌다 ==좌우 자식 노드 높이 차이 <= 1
	private boolean isBalanced(Node p) {
		if (p == null)
			return true;
		if (Math.abs(height(p.left) - height(p.right)) <= 1)
			return true;
		else
			return false;
	}

	public void AVLInsert(int k) {
		Node node = insert(k);
		verifyNFix(node);
	}
	
	public void AVLDelete (int k) {
		Node node = insert(k);
		verifyNFix(node);
	}

	public void verifyNFix(Node node) {
	    while (node != null) {
	        if (!isBalanced(node)) {
	            if (height(node.left) > height(node.right)) {
	                // Left subtree is taller
	                Node leftChild = node.left;
	                if (height(leftChild.left) >= height(leftChild.right)) {
	                  
	                    rotateRight(node);
	                } else {
	                    rotateLeft(leftChild);
	                    rotateRight(node);
	                }
	            } else {
	                Node rightChild = node.right;
	                if (height(rightChild.right) >= height(rightChild.left)) {
	                    rotateLeft(node);
	                } else {
	                    rotateRight(rightChild);
	                    rotateLeft(node);
	                }
	            }
	        }
	        node = node.parent; 
	    }
	}
	
	private Node rotateLeft(Node x) {
		Node y = x.right;

		if (y == null)
			return x;

		// y --> x
		y.parent = x.parent;

		if (y.parent == null)
			root = y;
		else {
			if (x == x.parent.left)
				x.parent.left = y;
			else
				x.parent.right = y;
		}

		x.right = y.left;
		if (y.left != null)
			y.left.parent = x;
		y.left = x;
		x.parent = y;

		return y;
	}

	private Node rotateRight(Node x) {
		Node y = x.left;
		if (y == null)
			return x;
		y.parent = x.parent;

		if (y.parent == null) {
			root = y;
		} else {
			if (x == x.parent.left)
				x.parent.left = y;
			else
				x.parent.right = y;
		}

		x.left = y.right;
		if (y.right != null) {
			y.right.parent = x;
		}

		y.right = x;
		x.parent = y;

		return y;

	}
	
	public static void main(String[] args) {
		int[] key = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		AVLTree t = new AVLTree();
		
		for (int i = 0; i < key.length; i++) {
			t.AVLInsert(key[i]);
		}
		t.showLevel();
		
	}
}