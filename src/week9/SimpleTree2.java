package week9;

public class SimpleTree2 {
    class Node {
        char data;
        Node leftChild;
        Node rightChild;

        Node(char d) {
            data = d;
            leftChild = null;
            rightChild = null;
        }

        Node(Node lc, char d, Node rc) {
            data = d;
            leftChild = lc;
            rightChild = rc;
        }

        public String toString() {
            return "" + data;
        }
    }

    Node root;
    int nodeCount;

    SimpleTree2() {
        root = null;
        nodeCount = 0;
    }

    public Node insert(Node node, char ch) { //새로운 노드 삽입 
        if (node == null) {
            node = new Node(ch);
            nodeCount++;
        } else {
            if (ch < node.data) {
                node.leftChild = insert(node.leftChild, ch);
            } else {
                node.rightChild = insert(node.rightChild, ch);
            }
        }
        return node;
    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.leftChild);
            System.out.print(node.data + " ");
            inorderTraversal(node.rightChild);
        }
    }

    public void showTree() {
        inorderTraversal(root);
    }

    public void toArray() { 
        char[] array = new char[nodeCount *2 + 2]; // 배열 크기를 트리의 노드 수에 맞게 설정

        toArray(root, 1, array);

        System.out.println();
        for (int i = 1; i < array.length; i++) {
            System.out.print("[" + i + "]" + array[i] + " ");
        }
    }

    private void toArray(Node node, int index, char[] array) {
        if (node != null) {
            array[index] = node.data;
            toArray(node.leftChild, index * 2, array);
            toArray(node.rightChild, index * 2 + 1, array);
        }
    }

    public static void main(String[] args) {
        SimpleTree2 tree = new SimpleTree2();
        tree.root = tree.insert(tree.root, 'a');
        tree.root = tree.insert(tree.root, 'b');
        tree.root = tree.insert(tree.root, 'c');
        tree.root = tree.insert(tree.root, 'd');
        tree.root = tree.insert(tree.root, '+');
        tree.root = tree.insert(tree.root, '%');
        tree.root = tree.insert(tree.root, '+');

        tree.showTree();
        tree.toArray();
    }
}