package week5;

public class MyArrayList1 {
	// free from Max Size of Array!
	// 용량 늘린 버전으로 구현하기

	int maxSize = 20;
	int[] array;
	int currentSize; //

	public MyArrayList1() {
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

	private void enlarge(int value) {
		if (isFull()) { // 현재 사이즈 체크
			// enlarge Array Size! 사이즈 크게 만들자
			// 1. newArray of size maxSize*2
			// 2. copy current data to newArray
			// 3. array = newArray
			// 4. maxSize *= 2
		}
	}

	public void addLast(int value) { // 숙제 - 메모리를 늘려주는 메소드를 만들자 - 위에 있음
		if (isFull()) { // 현재 사이즈 체크
			// enlarge Array Size! 사이즈 크게 만들자
			// 1. newArray of size maxSize*2
			// 2. copy current data to newArray
			// 3. array = newArray
			// 4. maxSize *= 2

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
	}

	public int removeFirst(int index) { // 맨앞 삭제 -> 뒷 요소들 땡겨오기 (숙제)

	}

	public int removeKey(int value) { // 숙제 : 줄인 거 뒤부터 줄여라
		int index = indexOf(value);
		if (index == -1) {
			System.out.println("Not Found!");
		}

	}

	public int remove(int index) { // (숙제)

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
	}

	for(

	int i = 0;i<10;i++)
	{
		list.addLast(array[i]);
	}

	list.addFirst(300);

	list.add(5,400);

	int index = list.indexOf(400);

	list.set(index,450);

	list.get(index); // 450으로 고쳐졌는지 확인

	list.size();

	list.remove(3); // index = 3
	list.removeKey(450); // key Value = 450

	list.removeFirst();list.removeLast();
}

}
