package week5;

public class MyArrayList0 {
	// public class MyArrayList implements List { List�� ������ �͵��� �����ϰڴ�.
	// interface�� ������ �� �ǹ���. ��� �޼ҵ尡 �־�� �Ѵ�.

	int maxSize = 20;
	int[] array;
	int currentSize; //

	public MyArrayList0() {
		array = new int[maxSize];
		currentSize = 0;
	}

	private boolean isFull() { // �޸� ���� ����
		if (currentSize == maxSize) { // ���� ������ üũ
			return true;
		} else
			return false;
	}

	public boolean isEmpty() { // �޸� ���� ����
		if (currentSize == 0) { // ���� ������ üũ
			return true;
		} else
			return false;
	}

	public void addLast(int value) {
		if (isFull()) { // ���� ������ üũ
			System.out.println("Memory full!");
			return;
		} else {
			array[currentSize++] = value;
		}
	}

	public void addFirst(int value) { // �ִ� �� ���� �� �о�� ��
		if (isFull()) { // ���� ������ üũ
			System.out.println("Memory full!");
		} else { // ����� �����ϴٸ� �ϳ��� �б�
			for (int i = currentSize; i > 0; i--)
				array[i] = array[i - 1];
			array[0] = value;

		}
	}

	public void add(int index, int value) { // ����

	}

	public int removeLast() { // �ǵ� ����
		if (isEmpty()) {
			System.out.println("List Empty");
		} else {
			int returnValue = array[currentSize - 1];
			currentSize--;
			return returnValue;
//			return array[--currentSize]; �� �� ���� �ٿ��� �� ��
		}
		return currentSize; // ���� �߰� �� �����ؾ� ��
	}

	public int removeFirst(int index) {
		return index; // �Ǿ� ���� -> �� ��ҵ� ���ܿ��� (����)

	}

	public int removeKey(int value) { // ���� : ���� �� �ں��� �ٿ���
		int index = indexOf(value);
		if (index == -1) {
			System.out.println("Not Found!");
		}
		return index;

	}

	public int remove(int index) {
		return index; // (����)

	}

	public int size() {
		return currentSize;
	}

	public int get(int index) { //
		// ����ڰ� �ε����� ���� ���� �شٸ�? : indexOutOfBound üũ
		if (index < 0 || index >= currentSize) { // ���� �޼ҵ�� ��� �� ����
			System.out.println("Wrong Index!");
			return -9999; // not found ��� ������
		} else
			return array[index];
	}

	public int set(int index, int value) { // (����): Ư�� i��° ���� ����
		// ���⿡ indexOutOfBound �����ϱ� �ڵ� �ִ� �� ���� , ���� ����
		array[index] = value;
		return array[index];
	}

	private int indexOf(int value) { // ��ġ - sorting �� �Ǿ� ����
		for (int i = 0; i < currentSize; i++) {
			if (array[i] == value) {
				return i;
			}
		}
		return -1; // ���ϴ� ���� ����. null == -1
	}

	public static void main(String[] args) {
		int[] data = new int[10];

		for (int i = 0; i <= 10; i++) {
			data[i] = (int) Math.random() * 10; // 10���� ���� ������ �����

		}

		MyArrayList list = new MyArrayList(); // �޸� �Ҵ� ����

		for (int i = 0; i < 10; i++) {
			list.addLast(data[i]);
		}

		list.addFirst(300);

		list.add(5, 400);

		int index = list.indexOf(400);

		list.set(index, 450);

		list.get(index); // 450���� ���������� Ȯ��

		list.size();

		list.remove(3); // index = 3
		list.removeKey(450); // key Value = 450

		list.removeFirst(index);
		list.removeLast();

	}
}
