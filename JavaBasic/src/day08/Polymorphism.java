package day08;
//public > protected > 생략형(package,default 지정자) > private
//부모
class Super{
	int a=10;
	int b=20;
	
	void foo() {
		System.out.println("*****");
	}
}////////////
//자식
class Sub extends Super{
	int b=30;
	int c=40;
	
	//foo()오버라이드 @@@@
	@Override
	protected void foo() {
		System.out.println("@@@@@");
	}
	
	public void foo(String str) {//오버로드
		System.out.println(str);
		this.foo();
	}
	
}//////////

public class Polymorphism {

	public static void main(String[] args) {
		System.out.println("1. -----------------");
		Super sp = new Super();
		System.out.println("sp.a: " + sp.a);//10
		System.out.println("sp.b: " + sp.b);//20
		sp.foo();//*****
		
		System.out.println("2. -----------------");
		Sub sb = new Sub();
		System.out.println("sb.a: " + sb.a);//10
		System.out.println("sb.b: " + sb.b);//30
		System.out.println("sb.c: " + sb.c);//40
		sb.foo();//@@@@@
		sb.foo("$$$$$");//$$$$$
		                //@@@@@
		System.out.println("3. -----------------");
		Super ss = new Sub();
		System.out.println("ss.a: " + ss.a);//10
		System.out.println("ss.b: " + ss.b);//20
		//System.out.println("ss.c: ");
		ss.foo();//@@@@@
		//ss.foo("####");[x]
		
	}

}
