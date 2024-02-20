package day10;
/*
 * modifier
 * ----------------------------------------
 * 			abstract			final
 * ----------------------------------------
 * 클래스  |상속받게할 목적		| 상속받지 못하게 함
 * 메서드  |오버라이드할 목적		| 오버라이드 못하도록
 * 변수   |   x				| 값 할당 못하도록
 * ----------------------------------------
 * */
//[1] final + class : 상속 불가
final class Parent{
	int a = 10;
}//////////////
class Child //extends Parent[x]
{ 
	void foo() {
		System.out.println("foo()");
	}
	//[2] final + method : 오버라이딩 불가
	final void bar() {
		System.out.println("bar()");
	}
}//////////////
class SubChild extends Child
{
	//[3] final + 변수: 값 할당 못함
	//public final static ==> 상수
	public static final double PI = 3.14;
	
	//foo()
	@Override
	public void foo() {
		super.foo();
		System.out.println("###########");
	}
	
	//bar()
	/* final메서드는 오버라이드 못함
	@Override
	public void bar() {
		super.bar();
		System.out.println("bar()");
	}
	*/
}


public class FinalTest {

	public static void main(String[] args) {
		//SubChild의 파이값을 출력
		System.out.println(SubChild.PI);
		//SubChild.PI= 30.14;[x]
		
		//foo() 호출하기
		SubChild sub = new SubChild();
		sub.foo();
		sub.bar();
	}

}
