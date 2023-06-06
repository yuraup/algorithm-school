package week12;

public class AVLTree extends BST {

	public AVLTree() {
		super();
	}

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
		Node x = node.parent;
		while (x != null) {
			if (!isBalanced(x))
				break;
			x = x.parent;
		}
		Node y = null;
		if (x != null) {
			if (k < x.key) {
				y = x.left;
				if (k < y.key)
					rotateRight(x);
				else {
					rotateLeft(y);
					rotateRight(x);
				}
			} else {
				y = x.right;
				if (k > y.key)
					rotateLeft(x);
				else {
					rotateRight(y);
					rotateLeft(x);
				}
			}
		}
	}
	
	public void AVLDelete (int k) {
	Node x = delete(k);
	Node y = null;
	Node z = null;
	Node w = null;
	
	while (x!= null) {
		if (!isBalanced(x)) {
			if (height(x.left)>= height(x.right)) {
				y = x.left;
				if (y.left != null) {
					z = y.left;
					w = rotateRight(x);
				}
				else {
					z = y.right;
					rotateLeft(y);
					w = rotateRight(x);
				}
			} else {
				y = x.right;
				if (y.left != null) {
					z = y.left;
					rotateRight(y);
					w = rotateLeft(x);
				} else {
					z = y.right;
					w = rotateLeft(x);
				}
			}
			if (w.parent == null) {
				root = w;
			}
			x = w.parent;
		} else x= x.parent;
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
