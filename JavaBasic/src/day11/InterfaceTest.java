package day11;
/*참조형
 * - 클래스형
 * - 배열
 * - 인터페이스형
 * */
interface MyInter
{
	//추상메서드 + final 변수 만 멤버로 갖는다
	void foo();//public abstract가 자동으로 붙는다
	void bar(String str);
	
}/////////////////////
interface YourInter
{
	String GREETING="Hi"; //public static final이 자동으로 붙는다
	int baz();
}////////////////////
//인터페이스를 상속받을 때는 여러 개 상속 가능하며
//implements 로 상속받는다
class MyClass implements MyInter,YourInter
{
	//Override해서 에러 없도록
	@Override
	public void foo() {
		System.out.println("foo()");
	}
	@Override
	public void bar(String str) {
		System.out.println("bar(): "+str);
	}
	@Override
	public int baz() {
		System.out.println("baz()");
		return 100;
	}
	
}////////////////////
public class InterfaceTest {

	public static void main(String[] args) {
		//MyInter mi=new MyInter();//[x]
		//인터페이스도 타입 선언은 가능하나 new 해서 객체 생성은 할 수 없다
		MyInter mi=new MyClass();
		//foo(), bar()호출하기
		mi.foo();
		mi.bar("Hello");
		
		//baz()호출해보기
		//mi.baz();//[x]
		int n=((MyClass)mi).baz();
		System.out.println(n);
		
		//YourInter yi=new YourInter();//[x]
		YourInter yi=new MyClass();
		//baz()
		yi.baz();
		//foo(), bar()
		((MyClass)yi).foo();
		((MyInter)yi).bar("Hi");
		//GREETING값 출력해보기
		System.out.println(MyClass.GREETING);
		System.out.println(YourInter.GREETING);
		System.out.println(yi.GREETING);
		//System.out.println(mi.GREETING);[x]
		
		//MyClass.GREETING="Allo";//[x] final상수
	}

}
