package day08;
//Person상속받고 subject(과목) 추가, 생성자 오버로드 하기
public class Teacher extends Person{
	String subject;
	
	public Teacher() {
		super(1, "선생님", "010");
	}
	
	public Teacher(int no, String name, String tel, String subject) {
		super(no, name, tel);
		this.subject = subject;
	}
	
	//toString() 오버라이드
	@Override
	public String toString() {
		String str = super.toString();
		str =str.replace("Person","Teacher");
		str += "\nSubject: " + subject;
		return str;
	}
}
