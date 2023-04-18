package week6;

public class Main {
	public static void main(String[] args) {
		int dataSize = 20; //데이터 사이즈 

		MyArrayList2<Record> list = new MyArrayList2<>(); //제네릭 타입의 array 
		//초기 데이터 생성 
		for (int i=0; i<dataSize; i++) { //19개의 데이터 생성 
			list.addLast(new Record(i, "LEE")); //리스트 마지막: 요소 추가 
		
		}list.showList(); //데이터 생성 후 리스트 내용 보여주기 
		
		//리스트 조작 시작 
		//1.리스트 처음에 요소 추가 
		list.addFirst(new Record(50, "HAN")); //리스트 처음 : 요소 추가 , 원래 요소 뒤로 밀림 
		list.add(6, new Record(66, "PARK")); //6번째 인덱스 변경, num:66, park 
		list.showList(); 
		
		int index = list.indexOf(new Record(50, "KIM"));
		System.out.println(" \n 인덱스 확인:" + index);
		list.set(index, new Record(60, "KIM"));
		System.out.println("\n"+index+"-th Value is : "+list.get(index));
		
		System.out.println("Size is : "+list.size());
		
		list.remove(3); // index =3
		list.removeKey(new Record(55, "PARK")); // key value =450;
		list.showList();
		
		list.removeFirst();
		list.removeLast();
		list.showList();
	}
}