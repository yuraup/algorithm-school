package week13;

import java.util.ArrayDeque;
import java.util.Deque;

public class HeapInList {
	class Node {
		char priorty; //HeapInList
		Node left, right, parent;
		public Node (char val, Node l, Node r, Node p) {
			priorty = val;
			left = l;
			right = r;
			parent = p;
		}
		public String toString () {
			return " "+priorty;
		}
	}
	
	Node heapRoot;
	Node last;
	
	public HeapInList () {
		heapRoot = null;
		last = null;
	}
	
	public void insert (char c) {
		Node parentOfNext = null;
		
		if (heapRoot == null) {
			heapRoot = new Node(c, null, null, parentOfNext);// 제일 처음에 들어가니까 Null 
			last = heapRoot;
		}
		else if (heapRoot == last) { //하나밖에 없는 경우 
			parentOfNext = heapRoot;
			heapRoot.left = new Node(c, null, null, parentOfNext);
			last = heapRoot.left;
		} 
		else if (last == last.parent.left) {
			parentOfNext = last.parent;
			parentOfNext.right =  new Node(c, null, null, parentOfNext);
			last = parentOfNext.right;
		} 
		else {
			parentOfNext = last;
			while (parentOfNext.parent != null && parentOfNext == parentOfNext.parent.right) {
				//오른쪽 자식이면 올라가라 , root일 경우까지 
				parentOfNext = parentOfNext.parent;
			} //여기서 빠져나오면, 부모가 없거나 왼쪽자식일 때 
			
			if (parentOfNext.parent != null) { //왼쪽 일 때 
				parentOfNext = parentOfNext.parent.right;
				
				while (parentOfNext != null) { //왼쪽 타고 내려옴 
					parentOfNext = parentOfNext.left;
				}
				
				parentOfNext = new Node(c, null, null, parentOfNext);
				last = parentOfNext.left;
			}
			fixUpward(last);
		}
	}
	
	private void fixUpward(Node node) {
			if (node == null || node.parent == null) {
				return;
			}
			if (node.priorty >node.parent.priorty) {
				swap(node, node.parent);
				fixUpward(node.parent); //올라가 
			}
			
	}
	
	private void swap(Node a, Node b) {
		char temp = a.priorty;
		a.priorty = b.priorty;
		b.priorty = temp;
	}
	
	public void showHeap() {
		Node node = heapRoot;
		Deque<Node> q = new ArrayDeque<Node>();
	      q.add(node);
	      while (!q.isEmpty()) {
	         Node p = q.removeFirst();
	         System.out.print(p.toString());
	         if (p.left != null)
	            q.add(p.left);
	         if (p.right != null)
	            q.add(p.right);
	      }
	}

	public static void main(String[] args) {
		HeapInList heap = new HeapInList();

		for (int i = 0; i<26; i++) {
			heap.insert((char)('A' + i));
			System.out.println();
			
			heap.showHeap();
		}
		
		System.out.println("<<Tree Created>>");
		heap.showHeap();
		
//		System.out.println("<<Sorted List>>");
//		
//		for (int i = 0; i< 26; i++) { 
//			heap.showHeap();
//			heap.delete();
//		}
		
	}
}
