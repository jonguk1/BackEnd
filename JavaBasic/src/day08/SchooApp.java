package day08;

public class SchooApp {

	public static void main(String[] args) {
		Object obj = new Object();
		Object obj2 = new Object();
		Object obj3 = obj2;
		
		System.out.println(obj.toString());//obj.toString()
		System.out.println(obj2.toString());
		
		System.out.println("obj==obj2: " + (obj==obj2));//주소값 비교
		System.out.println("obj2==obj3: " + (obj2==obj3));
		
		System.out.println("obj.equals(obj2): " + (obj.equals(obj2)));//주소값 비교
		System.out.println("obj2.equals(obj3): " + (obj2.equals(obj3)));
		
		//String 클래스에서 내용비교로 오버라이딩(재정의) 되었음
		System.out.println("--------------------");
		//Person객체 1개 생성, 객채값 출력하기
		Person p1 = new Person(1, "홍길동", "010-1111-1111");
		System.out.println(p1);
		
		//Student생성해서 객체값 출력
		Student student = new Student(100, "김학생", "010-2222-2222", "백엔드");
		System.out.println(student);
		
		
		//Teacher생성해서 객채값 출력
		Teacher teacher = new Teacher(500, "최교사", "010-3333-4444", "Java");
		System.out.println(teacher);
		
		//부모타입 변수 = new 자식객체생성()
		Person ps = new Student(101,"이세영","011-4545-7878", "프론트엔드반");
		Person pt = new Teacher(501,"강교사", "010-9898-7777","Python");
		
		System.out.println("ps.name: " + ps.name);
		System.out.println("ps.tel: " + ps.tel);
		//System.out.println("ps.className: " + ps.className);[x]
		
		System.out.println(ps.toString());
	}

}
