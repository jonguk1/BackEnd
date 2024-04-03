package day03;
/* ��ü�� ���� �� �ֵ��� ����� ���ؼ��� Comparable�������̽��� ��ӹ޾� compareTo()�޼��带 �������ؾ� �Ѵ�
�Ǵ� Comparator�������̽��� ��ӹ޾� compare()�޼��带 �������ؾ� �Ѵ�.
# Comparable�� Comparator�� ���̴�?
	[1] Comparable�� compareTo(T o) �޼ҵ� 
	[2] Comparator�� compare(T o1, T o2) �޼ҵ�

- Comparable�� "�ڱ� �ڽŰ� �Ű����� ��ü�� ��"�ϴ� ���̰�, 
- Comparator�� "�� �Ű����� ��ü�� ��"�Ѵٴ� ���̴�.

���� �����ڸ�, Comparable�� �ڱ� �ڽŰ� �Ķ���ͷ� ������ ��ü�� ���ϴ� ���̰�, 
Comparator�� �ڱ� �ڽ��� ���°� ��� ������� �Ķ���ͷ� ������ �� ��ü�� 
���ϴ� ���̴�. ��, ���������� ���Ѵٴ� �� ��ü�� ������, �� ����� �ٸ��ٴ� ��.
* */
public class Member implements Comparable<Member>{

	private String name;
	private int age;
	private int height;
	
	public Member() {
		
	}
	public Member(String n, int a, int h) {
		name=n; age=a; height=h;
	}
	
	//���̸� �������� �������� ����
	@Override
	public int compareTo(Member obj) {
		//��ȯ���� ����� ��ȯ�ϸ� �ڸ��� �ٲ۴�. ������ ��ȯ�ϸ� �״�� �д�
		/*
		if(this.age == obj.age) {
			return 0;
		}else if(this.age > obj.age) {
			return 1;//����� ��ȯ
		}else {
			return -1;
		}*/
		//return this.age-obj.age;//��������
		//return obj.age-this.age;//��������
		//�̸� �������� �������� ����
		//return this.name.compareTo(obj.name);//�̸� ��������
		return this.name.compareTo(obj.name)*-1;//�̸� ��������
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member user=(Member)obj;
			if(user.name.equals(this.name) && user.age == this.age && user.height==this.height) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	
	
}
