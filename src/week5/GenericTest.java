package week5;

public class GenericTest<A, B> { // T가 타입을 말하는 변수가 됨. T는 변수명
	// 데이터 타입을 레코드로 작성하는 것이 누구나 어떤 타입을 쓰기 편하도록 함
	// 모든 클래스 객체는 Object를 상속받음
	A i;
	B j;

	// 제너릭은 제너럴라이즈 한다는 것. 일반적인, 일반화
	public GenericTest(A value1, B value2) {
		i = value1;
		j = value2;
	}

	public void print() {
		// i에는 아무거나 들어갈 수 있으니까 일반화 된 것
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

	static class Record { // class 는 new가 없으면 메모리 할당이 안 됨, static 붙임
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
