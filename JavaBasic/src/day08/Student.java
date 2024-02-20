package day08;
//학사관리프로그램
//학생(학번,이름,연락처,학급),교사(교번,이름,연락처),직원(사번,이름,연락처,부서)
//className
//Person 상속받고 className속성 추가하기
public class Student extends Person{

	String className;
	
	public Student() {
		super(0,"학생","010");//부모에 기본생성자가 없을 경우 명시적으로 super(인자)
		//생성자를 호출해줘야 함
		//super();자식클래스 생성자에서는 묵시적으로 super()를 호출한다
	}
	
	public Student(int no, String name, String tel,String className) {
		//super();
		super(no, name, tel);
		
		//super()=>생성자에서만 호출 가능하며, 첫번쨰 라인에서 호출해야 함
		this.className =className;
	}
	
	//toString() 오버라이드
	@Override
	public String toString() {
		String str = super.toString();
		str =str.replace("Person","Student");
		str += "\nClass: " + className;
		return str;
	}
	
	
}
