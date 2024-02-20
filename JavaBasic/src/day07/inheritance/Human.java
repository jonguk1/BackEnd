package day07.inheritance;
/* 부모 클래스 : Super class, Base class
 * 자식 클래스 : Sub class, Derived class
 * 자바는 상속받을 때 extends를 이용하며, 단일 상속만 가능하다
 * 클래스를 구성하면 묵시적으로 extends Object 가 된다 
 * 모든 클래스의 최 상위에는 java.lang.Object 클래스가 있다.
 * */
public class Human {//부모 클래스
	
	String name;
	int height;
	
	public void showInfo() {
		System.out.println("이 름: " + name);
		System.out.println("키  : " + height);
	}
}
