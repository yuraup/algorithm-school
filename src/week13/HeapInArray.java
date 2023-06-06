package week13;

import java.util.ArrayList;

public class HeapInArray {
	ArrayList<Character> heap = new ArrayList<>();
	int heapRoot;
	public HeapInArray() {
		heap.add(null); //null 넣고 시작[0] , 그 다음부터는 1번부터 들어감  
//		heapRoot = 1;
	}
	
	public void insert (char ch) {
//		heap.add(ch);
		int lastIndex = heap.size();
		heap.add(lastIndex, ch);
		fixUpward(heap.size()-1); //새로 들어간 놈의 엔덱스 == heapify
	}
	
	private Character delete() {
		if (heap.size()<= 1) {
			return null;			
		}
		char reVal = heap.get(1); //제일 큰 값 저장 
		if (heap.size() == 2) {
			heap.remove(1);
		}
		else {
			
			heap.set(1, heap.remove(heap.size()-1)); //맨 뒤의 값을 1에 넣음 
			fixDownward(1);
		}
		return reVal;
	
	}
	private void fixUpward(int index) {
		int parentIndex = index/2;
		if (parentIndex > 0) {
//			heap.get(index); //내 값 
//			heap.get(parentIndex); //부모의 
			
			if (heap.get(index) > heap.get(parentIndex)) {
				swap(index, parentIndex); // 내가 더 크면 부모랑 바꿔
				fixUpward(parentIndex); //다시 호출 -> 인덱스 0 되면 종료 
			}
		}
		
	}

	private void fixDownward(int i) {
		int bigger = i*2; //left child
		if (bigger >= heap.size()) {
			return;
		}
		
		if (bigger+1 < heap.size() && heap.get(bigger) <  heap.get(bigger +1)) { //위가 
			bigger ++;
		}
		
		if (heap.get(i) <  heap.get(bigger)) { //위가 더 작음 
			swap(i, bigger);
			fixDownward(bigger);
		}
	}

	private void swap(int i, int j) {
		char temp = heap.get(i);
		heap.set(i, heap.get(i));
		heap.set(j, temp);
		
	}
	
//	public void showLevel () {
//		System.out.println();
//		int h = height();
//		System.out.println("");
//		for (int level = 0; level <= h; level ++) {
//			int levelStart = (int) Math.pow(2, level);
//			int levelEnd = ((int) Math.pow(2, level+1)-1, heap.size() -1);
//		
//		for (int i = levelStart; i <= levelEnd)}
//	}
	
	public static void main(String[] args) {
		HeapInArray heap = new HeapInArray();
		
		for (int i = 0; i<26; i++) {
			heap.insert((char)('A' + i));
			heap.showHeap();
		}
		System.out.println("<<Tree Created>>");
		heap.showHeap();
		
		System.out.println("<<Sorted List>>");
		
		for (int i = 0; i< 26; i++) { 
			heap.showHeap();
			heap.delete();
		}
		
	}

	private void showHeap() {
		System.out.println(heap);
	}
}
