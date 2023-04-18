package week6;

public class MyArrayList2 <T> { // make MyArrayList1 generic!
	
	int maxSize =10;
	T [] array ;
	int currentSize;
	
	public MyArrayList2 () {
		array = (T [])new Object [maxSize];
		currentSize =0;
	}
	
	private boolean isFull() {
		if ( currentSize == maxSize) {
			return true;
		}
		else 
			return false;
	}
	private void enlarge() {
		System.out.println("\nList Capacity is enlarged !");
		T [] tempArray = (T [])new Object  [maxSize*2];
		for (int i=0;i<currentSize;i++)
			tempArray[i]=array[i];
		maxSize *=2;
		array=tempArray;
	}
	public void addLast(T value) {
		if ( isFull()) {
			enlarge();
		}
			array[currentSize++]=value;
	}
	
	public void addFirst(T value) {
//		if ( isFull()) {
//			System.out.println("Memory Full!");
//		}
//		else {
//			for (int i=currentSize; i>0; i--)
//				array[i]=array[i-1];
//			array[0]=value;
//		}
		add(0, value);
	}
	
	public void add(int index, T value) {
		// homework
		if ( isFull()) {
			enlarge();
		}
		for (int i=currentSize; i>index; i--)
			array[i]=array[i-1];
		array[index]=value;
		currentSize++;

	}
	public boolean isEmpty() {
		if ( currentSize == 0) {
			return true;
		}
		else 
			return false;
	}	
	public T removeLast() { 
		// return value
		if (isEmpty()) {
			System.out.println("List Empty!");
			return null;  // -9999 means null!
		}
		else {
			T retValue = array[currentSize-1];
			currentSize--;
			return retValue;
//			return array[--currentSize];
		}
	}

	public T removeFirst() {
		// return value
		// homework
		if (isEmpty()) {
			System.out.println("List Empty!");
			return null;  // -9999 means null!
		}
		else {
			T retValue = array[0];
			currentSize--;

			for (int i=0;i<currentSize; i++)
				array[i]=array[i+1];
			
			return retValue;
		}
		
	}

	public int removeKey(T value) {
		// return index
		int index = indexOf(value);
		if (index==-1) {
			System.out.println("Not Found!");
			return -1;
		}
		else {
		// homework
			remove(index);	
			return index;
			
		}
	}

	public T remove(int index) {  // return type changed!
		// return value
		// homework
		if (index>=currentSize || index<0) {
			System.out.println("Wrong index!");
			return null;  // -9999 means null!
		}
		else {
			T retValue = array[index];
			currentSize--;

			for (int i=index;i<currentSize; i++)
				array[i]=array[i+1];
			
			return retValue;	
			
		}
	}

	public int size() {
		return currentSize;
	}

	public T get(int index) {
		// return value
		
		if (index<0 || index >=currentSize) {
			System.out.println("Wrong Index!");
			return null;
		}
		else 		
			return array[index];
	}

	public void set(int index, T value) {
		// homework
		array[index] = value;
	}

	public int indexOf(T value) {
		for (int i=0;i<currentSize;i++) {
			if (array[i].equals(value))
				return i;
		}
		return -1;
	}

	public void showList() {
		System.out.println("\n[ Current List ] ");
		for (int i=0;i<currentSize; i++)
			System.out.print(array[i].toString()+"  ");
	}


}

