package week12;

import java.util.ArrayDeque;
import java.util.Deque;

public class BST {
   class Node {
      int key;
      Node left;
      Node right;
      Node parent;

      Node(int key) {
         this.key = key;
         this.left = null;
         this.right = null;
         this.parent = null;
      }

      Node(Node lc, int key, Node rc) {
         this.key = key;
         this.left = lc;
         this.right = rc;
         this.parent = null;

         this.left.parent = this;
         this.right.parent = this;
      }

      public String toString() {
         return "" + key;
      }
   }

   Node root;

   public BST() {
      root = null;
   }

   public Node insert(int key) {
      if (root == null) {
         root = new Node(key);
         return root;
      } else
         return insert(root, key, null);
   }

   private Node insert(Node node, int key, Node parent) {
      if (node == null) {
         // insert here !
         Node newNode = new Node(key);

         if (key < parent.key) {
            parent.left = newNode;
            newNode.parent = parent;
         } else {
            parent.right = newNode;
            newNode.parent = parent;
         }
         return newNode;
      } else if (key < node.key) {
         return insert(node.left, key, node);
      } else {
         return insert(node.right, key, node);
      }

   }

   public boolean search(int key) {
      return search(root, key);
   }

   private boolean search(Node node, int key) {
      if (node == null)
         return false;
      if (node.key == key)
         return true;
      else if (node.key > key)
         return search(node.left, key);
      else
         return search(node.right, key);
   }

   private Node searchNode(Node node, int key) {
      if (node == null)
         return null;
      if (node.key == key)
         return node;
      else if (node.key > key)
         return searchNode(node.left, key);
      else
         return searchNode(node.right, key);
   }

   public Node delete(int key) {
      return delete(root, key);
   }

   private Node delete(Node startNode, int key) {
      Node node = searchNode(root, key);
      if (node != null) {
         // case 1 : degree == 0
         if (node.left == null && node.right == null) {

            if (node.key < node.parent.key)
               node.parent.left = null;
            else // right child
               node.parent.right = null;
         }
         // case 2 : degree == 1
         else if (node.left == null) {
            if (node.key < node.parent.key)
               node.parent.left = node.right;
            else
               node.parent.right = node.right;

         } else if (node.right == null) {
            if (node.key < node.parent.key) {
               node.parent.left = node.left;
               node.left.parent = node.parent;

            } else {
               node.parent.right = node.left;
               node.left.parent = node.parent;
            }

         }
         // case 3 : degree == 2
         else {
            Node p = successor(node);
            node.key = p.key;
            delete(node.right, p.key);
         }
      }
      return node;
   }
   
   private Node successor(Node node) { // 오른쪽 중 가장 왼쪽 :: 나보다 큰 놈 중 가장 작은 놈
      if (node != null) {
         Node p = node.right;
         while (p != null)
            p = p.left;
         return p;
      } else
         return null;
   }

   private Node predesuccessor(Node node) { // 왼쪽 중 가장 오른쪽 :: 나보다 작은 놈 중 가장 큰 놈
      if (node != null) {
         Node p = node.left;
         while (p != null)
            p = p.right;
         return p;
      } else
         return null;
   }

   public int height() {
      return height(root);
   }

   protected int height(Node node) {
      if (node == null)
         return 0;
      return 1 + Math.max(height(node.left), height(node.right)); // 한 단계 내려갔으니 + 1

   }

   private int level(Node node) {
      if (node == root)
         return 0;
      else
         return level(node.parent) + 1;
   }

   // showTree는 inorder로 출력

   public void showTree() {
      showTree(root);
//      levelOrderTraverse(root);
      System.out.println();
   }

   private void showTree(Node p) {
      if (p != null) {
         showTree(p.left);
         System.out.print(p.key);
         showTree(p.right);
      }
   }

   private void levelOrderTraverse(Node node) {
      Deque<Node> q = new ArrayDeque<Node>();
      q.add(node);
      while (!q.isEmpty()) {
         Node p = q.removeFirst();
         System.out.print(p.key);
         if (p.left != null)
            q.add(p.left);
         if (p.right != null)
            q.add(p.right);
      }
   }

   public void showLevel() {
      showLevel(root);
   }

   private void showLevel(Node node) {
      Deque<Node> q = new ArrayDeque<Node>();

      q.add(node);
      int curLevel = -1;
      while (!q.isEmpty()) {
         Node p = q.removeFirst();
         if (curLevel < level(p)) {
            curLevel++;
            System.out.print("\nLevel" + curLevel + " : ");
         }
         System.out.print(p.key);
         if (p.left != null)
            q.add(p.left);
         if (p.right != null)
            q.add(p.right);

      }

   }

   public static void main(String args[]) {
      int[] keys = { 4, 7, 5, 1, 0, 3, 9, 2, 6, 8 };

      BST t = new BST();

      for (int i = 0; i < keys.length; i++) {
         t.insert(keys[i]);
      }

      t.showTree();
      t.showLevel();
      System.out.println();
      System.out.println(t.search(3));
      System.out.println(t.search(11));
      t.delete(3);
      t.showTree();
      t.showLevel();
      System.out.println();
      System.out.println("---------------------" + t.height());
      //

      int[] key2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      BST t2 = new BST();

      for (int i = 0; i < key2.length; i++) {
         t2.insert(key2[i]);

      }
      t2.showLevel();

      System.out.println();
      System.out.println("---------------------" + t2.height());
//      t2.rotateLeft();
//      t2.showLevel();
   }

}
