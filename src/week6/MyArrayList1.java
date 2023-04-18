package week6;

public class MyArrayList1 {
	
	int maxSize =10; //최대 크기  10 -> enlarged 필요함 
	int [] array ; //int[] 타입의 array
	int currentSize; //현재 크기 
	
	public MyArrayList1 () { //생성자 함수 
		array = new int [maxSize]; 
		currentSize = 0;
	}
	
	private boolean isFull() { //메모리가 이미 차 있는지 확인 
		if ( currentSize == maxSize) { //현재 크기가 최대 크기와 같으면 full
			return true;
		}
		else 
			return false;
	}
	
	public boolean isEmpty() { //비어 있는가 
		if ( currentSize == 0) { //만약 지금 사이즈가 0이면 
			return true; //비어있음 
		}
		else 
			return false; // 내용있음 
	}	
	
	private void enlarge() { //메모리 공간 추가 함수 
		System.out.println("\n List1 Capacity is enlarged ! :용량 추가 ");
		int [] tempArray = new int [maxSize*2]; //최대 사이즈 *2
		System.out.println("currentSize in enlarge" + currentSize);
		for (int i=0; i<currentSize; i++)
			tempArray[i]=array[i];
		maxSize *=2; //maxSize 확장 
		array=tempArray; //array에 tempArray 값 넣음 
	}
	public void addLast(int value) {
		if (isFull()) { // maxSize 가 모자라면 
			enlarge(); //메모리 공간을 추가해! 
		}
	System.out.println("addLast확인: " + currentSize + " " + value);
			array[currentSize++]=value;
	}
	
	public void addFirst(int value) {
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
	
	public void add(int index, int value) {
		// homework
		if ( isFull()) {
			enlarge();
		}
		for (int i=currentSize; i>index; i--)
			array[i]=array[i-1];
		array[index]=value;
		currentSize++;

	}

	public int removeLast() {  // 마지막 값 삭제 
		// return value
		if (isEmpty()) { //마지막 값 존재하는가 
			System.out.println("List Empty!");
			return -9999;  // -9999 means null!
		}
		else { //존재한다면 
			int returnValue = array[currentSize-1]; //마지막 값을 returnValue에 넣어 
			currentSize--; //array size는 줄여 
			return returnValue;
		}
	}

	public int removeFirst() { //처음 값 삭제 
		// return value
		if (isEmpty()) { //값이 없다
			System.out.println("List Empty!");
			return -9999;  // -9999 means null! : 값이 없다 
		}
		else { // 값이 있다 
			int returnValue = array[0]; //내보낼 변수에 0번째 값을 넣음 
			currentSize--; //값이 하나 빠졌으니 길이 한 칸 줄임 (19)
			for (int i=0; i<currentSize; i++) 
				array[i]=array[i+1]; // i+1 값을 i에 담아서 array 변경 
			return returnValue; //0번째 값 
		}
		
	}

	public int removeKey(int value) {
		// return index
		int index = indexOf(value);
		if (index==-1) { //value 가 없다면 
			System.out.println("Not Found!");
			return -1;
		}
		else { //value에 해당하는 index를 찾음 
		// homework
			return remove(index);	//index에 해당하는 값 삭제 
		}
	}

	public int remove(int index) {  // return type changed!
		// return value
		// homework
		if (index>=currentSize || index<0) { //  index < 0 ,index > currentSize 일 때 
			System.out.println("Wrong index!"); // 잘못됨 
			return -9999;  // -9999 means null!
		}
		else { // 인덱스가 0< index< currentSize 일 때 
			int returnValue = array[index]; //반환값은 index번째의 값 
			currentSize--; //하나를 뺐으니까 사이즈 줄이기 

			for (int i=index; i<currentSize; i++)  //지운 인덱스 다음부터 i+1의 값을 i로 옮겨담기 
				array[i]=array[i+1]; //	
			return returnValue;	
			
		}
	}

	public int size() {
		return currentSize;
	}

	public int get(int index) {
		// return value
		
		if (index<0 || index >=currentSize) {
			System.out.println("Wrong Index!");
			return -9999;
		}
		else 		
			return array[index];
	}

	public void set(int index, int value) {
		// homework
		array[index] = value;
	}

	public int indexOf(int value) {
		for (int i=0;i<currentSize;i++) {
			if (array[i]==value) //인덱스 i의 값이 value와 같다면 
				return i; //인덱스 i 값 반환 
		}
		return -1; // 같은 값이 없다면 -1 반환 
	}

	public void showList() { //리스트 출력 
		System.out.println("\n[ Current List ] ");
		for (int i=0;i<currentSize; i++)
			System.out.print(array[i]+"  ");
	}
	
	public static void main(String[] args) { //여기서 실
		int dataSize = 20; // 데이터 크기 : 20
		int [] data = new int[dataSize];

		//데이터 생성 
		for (int i=0; i<dataSize; i++) 
			data[i] = (int)(Math.random()*1000);  // 랜덤값 생성 
		
		MyArrayList1 list = new MyArrayList1(); //생성자 
		
		//요소 추가 
		System.out.println("요소 추가 ");
		for (int i=0;i<20; i++) {
			list.addLast(data[i]);
//			System.out.println("list 뭔데 :" + data[i]);			
		} 
		
		System.out.println(" \n 리스트 보여줌 ");
		list.showList();
		
		
		System.out.println(" \n 리스트에 추가: 1. 300  2. 400 ");
		list.addFirst(300);
		list.add(5, 400);
		list.showList();

		
		System.out.println(" \n 인덱스 찾아 값 변경 ");
		int index = list.indexOf(400);
		list.set(index, 450);
		System.out.println("\n"+index+"-th Value is : "+list.get(index));
		
		System.out.println("\n 인덱스 검색 후 추가 Size is : "+list.size() + "\n");
		
		System.out.println("\n 삭제");
		list.remove(3); // index = 3
		list.showList();
		list.removeKey(450); // key value =450;
		list.showList();
		
		System.out.println("\n 처음, 마지막 삭제");
		list.removeFirst();
		list.removeLast();
		list.showList();
	}

}
