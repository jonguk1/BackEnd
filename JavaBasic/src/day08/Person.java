package day08;
//학사관리프로그램
//학생(학번,이름,연락처,학급),교사(교번,이름,연락처),직원(사번,이름,연락처,부서)
public class Person { //extends Object
	int no;
	String name;
	String tel;
	
	//인자생성자
	public Person(int no,String name,String tel) {
		this.no = no;
		this.name=name;
		this.tel=tel;
	}
	
	//toString() 오버라이딩 하세요
	public String toString() {
		String str = "---Person---\n";
		str += "No: " + no + "\nName: " + name+ "\nTel: " + tel;
		return str;
	}	
	
}///////////////////////////
