package week7;

public class MyStack {
	int maxSize = 10;
	int[] stack;

	int sp; // 대문자 SP == 컴퓨터 엑세스할 수 있는 stack pointer

	public MyStack() {
		stack = new int[maxSize];
		sp = 0;
	}

	public boolean isEmpty() {
		if (sp == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void push(int value) { // in
		if (sp == maxSize) { // full 검증
//			sp++;
		}
		if (sp >= maxSize) {
			return;
		} else {
			stack[sp] = value;
			sp++;
		}
	}

	public int pop() { // out
		if (isEmpty()) {
			return -9999;
		} else {
			return stack[--sp];
		}

	}

	public int peek() { // pop이랑 똑같아 대신 sp 변화를 주지 마
		if (isEmpty()) {
			return -9999;
		} else {
			return stack[sp - 1];
		}
	}

}
