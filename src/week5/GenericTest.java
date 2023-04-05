package week5;

public class GenericTest<A, B> { // T�� Ÿ���� ���ϴ� ������ ��. T�� ������
	// ������ Ÿ���� ���ڵ�� �ۼ��ϴ� ���� ������ � Ÿ���� ���� ���ϵ��� ��
	// ��� Ŭ���� ��ü�� Object�� ��ӹ���
	A i;
	B j;

	// ���ʸ��� ���ʷ������� �Ѵٴ� ��. �Ϲ�����, �Ϲ�ȭ
	public GenericTest(A value1, B value2) {
		i = value1;
		j = value2;
	}

	public void print() {
		// i���� �ƹ��ų� �� �� �����ϱ� �Ϲ�ȭ �� ��
		System.out.println(i + " " + j);
	}

	public static void main(String[] args) {
		GenericTest<Integer, Integer> t = new GenericTest<>(10, 5);
		GenericTest<Double, Double> td = new GenericTest<>(10.5, 9.9);

		t.print();
		td.print();

		GenericTest<Integer, Record> tr = new GenericTest<>(10, new Record(1, "lee"));
		tr.print();
	}

	static class Record { // class �� new�� ������ �޸� �Ҵ��� �� ��, static ����
		int num;
		String name;

		public Record(int n, String s) {
			num = n;
			name = s;
		}

		public String toString() {
			return "" + num + " : " + name;
		}
	}
}
