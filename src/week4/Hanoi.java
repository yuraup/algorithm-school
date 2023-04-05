package week4;

import java.util.Stack;

public class Hanoi {
	class Record {// push 중복 피하기 위해 , 코드 품질 향상 ,int 3개를 가짐
		int num;
		int from;
		int to;

		public Record(int n, int f, int t) {
			num = n;
			from = f;
			to = t;
		}

		public String toString() {
			return "" + num + "" + from + "" + to;
		}
	}

	public void move(int n, int from, int to) {
		if (n == 1) {
			System.out.println("move from " + from + "to" + to);
		} else {
			move(n - 1, from, 3 - from - to); // 3-from-to == temp
			System.out.println(" move from " + from + "to" + to);
			move(n - 1, 3 - from - to, to);
		}
	}

	public static void main(String[] args) {
		Hanoi h = new Hanoi();

		// 기둥 0, 1, 2 == from, to => temp 는 어떻게 됨 ?
		// form, to가 0,1 이면 2가 되어야 하고 ...
		// temp = 3=from-to

		int numOfPlate = 4;
		h.move(numOfPlate, 0, 1);
		h.moveIteration(numOfPlate, 0, 1);

		h.moveIteration2(numOfPlate, 0, 1);

	}

	private void moveIteration(int n, int f, int t) {
		// n, to, from 값이 call될 때마다 다름
		Stack<Integer> s = new Stack<>(); // 스택 만듬
		int num = n;
		int from = f;
		int to = t; // 변수 선언으로 다시 명시

		s.push(num); // num 저장
		s.push(from);
		s.push(to); // 저장해 놓고 loop 돌릴 것임

		while (!s.isEmpty()) { // empty 가 아닐 때
			// pop은 맨 위의 요소가 나옴 -> 넣은 순서와 반대로 꺼내기
			to = s.pop();
			from = s.pop();
			num = s.pop();

			if (num == 1) {
				System.out.println(" move from " + from + "to" + to);
			} else {
				s.push(num - 1);
				s.push(from);
				s.push(3 - from - to);

				s.push(1);
				s.push(from);
				s.push(to);

				s.push(num - 1);
				s.push(from);
				s.push(3 - from - to);
			}
		}
	}

	public void moveIteration2(int n, int f, int t) {
		// n, from, to
		int num, from, to;
		Stack<Record> s = new Stack<>();
		s.push(new Record(n, f, t));

		while (!s.isEmpty()) {
			Record r = s.pop();

			if (r.num == 1) {
				System.out.println(" move from " + r.from + " to " + r.to);
			} else {
				s.push(new Record(r.num - 1, 3 - r.from - r.to, r.to));

				s.push(new Record(1, r.from, r.to));

				s.push(new Record(r.num - 1, r.from, 3 - r.from - r.to));

			}
		}
	}
}
