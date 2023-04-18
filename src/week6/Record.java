package week6;

public class Record { //레코드 
	int num; // 숫자 
	String name; //이름 
	public Record(int n, String s) { //레코드는 두 개의 정보가 있음 
		num=n;
		name=s;
	}
	
	public boolean equals(Object that) { //레코드의 num이  같은지 확인 
		return (this.num==((Record)that).num);
	}
	
	public String toString() { //num과 name을 string으로 변
		return ""+num+"  : "+name;
	}
}
