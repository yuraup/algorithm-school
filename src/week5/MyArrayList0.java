package week5;

public class MyArrayList0 {
	// public class MyArrayList implements List { List가 정의한 것들을 구현하겠다.
	// interface로 정의한 건 의무다. 모든 메소드가 있어야 한다.

	int maxSize = 20;
	int[] array;
	int currentSize; //

	public MyArrayList0() {
		array = new int[maxSize];
		currentSize = 0;
	}

	private boolean isFull() { // 메모리 공간 여부
		if (currentSize == maxSize) { // 현재 사이즈 체크
			return true;
		} else
			return false;
	}

	public boolean isEmpty() { // 메모리 공간 여부
		if (currentSize == 0) { // 현재 사이즈 체크
			return true;
		} else
			return false;
	}

	public void addLast(int value) {
		if (isFull()) { // 현재 사이즈 체크
			System.out.println("Memory full!");
			return;
		} else {
			array[currentSize++] = value;
		}
	}

	public void addFirst(int value) { // 있는 거 전부 다 밀어내야 함
		if (isFull()) { // 현재 사이즈 체크
			System.out.println("Memory full!");
		} else { // 사이즈가 가능하다면 하나씩 밀기
			for (int i = currentSize; i > 0; i--)
				array[i] = array[i - 1];
			array[0] = value;

		}
	}

	public void add(int index, int value) { // 숙제

	}

	public int removeLast() { // 맨뒤 삭제
		if (isEmpty()) {
			System.out.println("List Empty");
		} else {
			int returnValue = array[currentSize - 1];
			currentSize--;
			return returnValue;
//			return array[--currentSize]; 위 세 줄을 줄여서 쓴 것
		}
		return currentSize; // 임의 추가 값 변경해야 함
	}

	public int removeFirst(int index) {
		return index; // 맨앞 삭제 -> 뒷 요소들 땡겨오기 (숙제)

	}

	public int removeKey(int value) { // 숙제 : 줄인 거 뒤부터 줄여라
		int index = indexOf(value);
		if (index == -1) {
			System.out.println("Not Found!");
		}
		return index;

	}

	public int remove(int index) {
		return index; // (숙제)

	}

	public int size() {
		return currentSize;
	}

	public int get(int index) { //
		// 사용자가 인덱스에 없는 값을 준다면? : indexOutOfBound 체크
		if (index < 0 || index >= currentSize) { // 따로 메소드로 떼어낼 수 있음
			System.out.println("Wrong Index!");
			return -9999; // not found 라고 정의함
		} else
			return array[index];
	}

	public int set(int index, int value) { // (숙제): 특정 i번째 값을 변경
		// 여기에 indexOutOfBound 방지하기 코드 넣는 게 숙제 , 위에 잇음
		array[index] = value;
		return array[index];
	}

	private int indexOf(int value) { // 서치 - sorting 안 되어 있음
		for (int i = 0; i < currentSize; i++) {
			if (array[i] == value) {
				return i;
			}
		}
		return -1; // 원하는 값이 없다. null == -1
	}

	public static void main(String[] args) {
		int[] data = new int[10];

		for (int i = 0; i <= 10; i++) {
			data[i] = (int) Math.random() * 10; // 10개의 랜덤 데이터 만들기

		}

		MyArrayList list = new MyArrayList(); // 메모리 할당 시작

		for (int i = 0; i < 10; i++) {
			list.addLast(data[i]);
		}

		list.addFirst(300);

		list.add(5, 400);

		int index = list.indexOf(400);

		list.set(index, 450);

		list.get(index); // 450으로 고쳐졌는지 확인

		list.size();

		list.remove(3); // index = 3
		list.removeKey(450); // key Value = 450

		list.removeFirst(index);
		list.removeLast();

	}
}
