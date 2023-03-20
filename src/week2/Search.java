package week2;

//����: ������ ũ���� array���� x�� ã�ƶ�. 
public class Search {
	int count = 0;

	public void setCount() {
		count = 0; // �ʱ�ȭ

	}

	public int getCount() { // �󸶸��� ã�Ҵ��� ���� ���� �Լ�
		return count;
	}

	public int search1(int[] data, int x) { // ���� �� ����
		for (int i = 0; i < data.length; i++) {
			count++;
			if (x == data[i]) {
				return i;
			}
		}
		return -1; // ����. == -1

	}

	public int search2(int[] data, int x, int n) { // ž �ٿ�
		count++;

		if (n < 0) { // ���� �� ���� ó��
			return -1;
		}
		if (x == data[n]) {
			return n;
		} else {
			return search2(data, x, n - 1);
		}

	}

	// int start, end; // ������ ���⿡ ������... �ٲ� ���ɼ��� �ֱ� ������ �� ��
	public int search3(int[] data, int x, int start, int end) {
		count++;

		if (end - start < 0) {
			return -1; // �� ã�Ҵ�
		}
		int middle = (start + end) / 2;

		if (x == data[middle]) {
			return middle;
		} else if (x > data[middle]) {
			return search3(data, x, middle + 1, end);
		} else {
			return search3(data, x, start, middle - 1);
		}
	}

	public static void main(String[] args) {
		int[] data = { 1, 3, 4, 6, 7, 10, 12, 17, 21, 23, 25, 30, 33, 37 };

		Search s = new Search();

		int x = 17;
		s.setCount();
		System.out.println(s.search1(data, x) + " " + s.getCount());
		s.setCount();
		System.out.println(s.search2(data, x, data.length - 1) + " " + s.getCount());
		s.setCount();
		System.out.println(s.search3(data, x, 0, data.length - 1) + " " + s.getCount());
	}
}
