package day03;

public class MyStackTest {

	public static void main(String[] args) {
		MyStack<String> sk1=new MyStack<>();
		sk1.push("HTML");
		sk1.push("Javascript");
		sk1.push("Java");
		sk1.push("SQL");
		
		String topData=sk1.peek();
		System.out.println(topData);
		String item=sk1.pop();
		System.out.println(item+"이 삭제되었음");
		System.out.println(sk1.peek());
		sk1.pop();
		sk1.pop();
		System.out.println("sk1의 현재 top: " + sk1.peek());
		System.out.println(sk1.isEmpty());
		if(!sk1.isEmpty()) {
			sk1.pop();
		}
		//System.out.println(sk1.peek());
		System.out.println("------------------------------");
		//[1] Double유형을 저장할 MyStack생성해서 실수값 3개 저장하세요
		MyStack<Double> sk2=new MyStack<>();
		sk2.push(11.1);
		sk2.push(13.31);
		sk2.push(15.55);
		//[2] 반복문 이용해서 [1]의 스택에 저장된 값들을 출력하세요
		while(!sk2.isEmpty()) {
			System.out.println(sk2.pop());
		}
		System.out.println("------------------------------");
		//[3] Member객체 3개 생성해서 스택에 저장한 뒤,
		//    반복문 이용해서 회원정보를 한꺼번에 출력하세요
		Member member1 = new Member("홍길동", 25, 180);
		Member member2 = new Member("최길동", 27, 170);
		Member member3 = new Member("이길동", 30, 160);
		
		MyStack<Member> sk3 =new MyStack<>();
		
		sk3.push(member1);
		sk3.push(member2);
		sk3.push(member3);
		
		for(int i =1; !sk3.isEmpty();i++) {
			Member user=sk3.pop();
			System.out.println(i+" : " + user);
		}
		
		
	}

}
