package day04;

public class MethodCallStack {

	public static void main(String[] args) {
		System.out.println("1) push main()�� ȣ��Ǿ���.");
		a();
		System.out.println("4) pop main() ���� �Ϸ�");
	}//---------------------
	public static void a() {
		System.out.println("2) push a()�� ȣ��Ǿ���.");
		b();
		System.out.println("3) pop a() ���� �Ϸ�");
	}
	
	public static void b() {
		System.out.println("3) push b()�� ȣ��Ǿ���.");
		c();
		System.out.println("2) pop b() ���� �Ϸ�");
	}
	public static void c() {
		System.out.println("4) push c()�� ȣ��Ǿ���.");		
		System.out.println("1) pop c() ���� �Ϸ�");
	}

}///////////////////////////
