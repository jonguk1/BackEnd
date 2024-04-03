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
		System.out.println(item+"�� �����Ǿ���");
		System.out.println(sk1.peek());
		sk1.pop();
		sk1.pop();
		System.out.println("sk1�� ���� top: " + sk1.peek());
		System.out.println(sk1.isEmpty());
		if(!sk1.isEmpty()) {
			sk1.pop();
		}
		//System.out.println(sk1.peek());
		System.out.println("------------------------------");
		//[1] Double������ ������ MyStack�����ؼ� �Ǽ��� 3�� �����ϼ���
		MyStack<Double> sk2=new MyStack<>();
		sk2.push(11.1);
		sk2.push(13.31);
		sk2.push(15.55);
		//[2] �ݺ��� �̿��ؼ� [1]�� ���ÿ� ����� ������ ����ϼ���
		while(!sk2.isEmpty()) {
			System.out.println(sk2.pop());
		}
		System.out.println("------------------------------");
		//[3] Member��ü 3�� �����ؼ� ���ÿ� ������ ��,
		//    �ݺ��� �̿��ؼ� ȸ�������� �Ѳ����� ����ϼ���
		Member member1 = new Member("ȫ�浿", 25, 180);
		Member member2 = new Member("�ֱ浿", 27, 170);
		Member member3 = new Member("�̱浿", 30, 160);
		
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
