package day10;
//JobSeeker,Student,Teacher,Superman...도메인(domain) 객체 => VO객체(Value Object),DTO객체(Data Transfer Object)
public class Person {
	private String name;
	private int age;
	
	public Person() {
		this("김철수",20);
	}
	
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
	}
	//setter,getter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//hashCode(), equals()메서드를 Override하자
	//이름,나이가 같으면 동일한 인물로 간주하여 해시셋에 중복저장하지
	//않도록
	@Override
	public int hashCode() {
		System.out.println("name의 해시코드: " + name.hashCode());
		return name.hashCode() + age;
	}
	//instanceof 연산자: boolean값 반환
	//참조변수 instanceof 클래스명
	//참조변수가 클래스의 객체면 true반환, 그렇지 않으면 false반환
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p =(Person)obj;
			boolean bool = (this.name.equals(p.getName())&& this.age ==p.getAge());
			return bool;
		}else {
			return false;
		}
	}
}
