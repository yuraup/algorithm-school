package week7;

public class MyQueue { // circular queue
	int maxSize = 10;
	int[] queue;

	int front; // 변수
	int rear;

	public MyQueue() {
		queue = new int[maxSize];
		front = 0;
		rear = 1;
	}

	public boolean isEmpty() {
		if ((front + 1) % maxSize == rear) { // empty
			return true;
		} else {
			return false;
		}
	}

	public void enqueue(int value) { // in
		if (front == rear) { // full 체크 : 둘이 같을 때 full
			return;
		} else {
			queue[rear] = value;
			rear = (rear + 1) % maxSize;
		}

	}

	public int dequeue() { // out
		if (isEmpty()) {
			return -9999;
		} else {
			front = front + 1;
			return queue[front];
		}
	}

	public int peek() { // pop이랑 똑같아 대신 sp 변화를 주지 마
		if (isEmpty()) {
			return -9999;
		} else {
			return queue[front + 1] % maxSize;
		}
	}

}
