package day05;

public class ArrayTest {

	public void testArray() {
		System.out.println("1차원 배열----------------------");
		
		int []a;//1. 선언
		boolean b[];
		
		a = new int[3];//2 메모리 할당
		b = new boolean[3];
		System.out.println(a[0]);
		System.out.println(b[0]);
		//3.초기화
		a[0] = 100;
		a[1] = 017;//8진수
		a[2] = 0x16;//16진수
		
		//for루프 이용해서 a값 출력하기
		for(int i = 0; i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		b[0] = true;
		b[1] = false;
		b[2] = 4>2;
		
		for(int i=0; i<b.length;i++) {
			System.out.println(b[i]);
		}
		
		//for-each루프문, 확장 for루프문
		/*
		 * for(변수선언문: 배열){
		 * 	    실행문;
		 * }
		 */
		for(int x:a) {
			System.out.println("x: "+ x);
		}
		//b에 저장된 값을 for-each루프문 이용해 출력하세요
		for(boolean y:b) {
			System.out.println("y: " + y);
		}
	}
	
	public static void testArray2() {
		System.out.println("2. 참조형 배열-------------");
		//String 타입의 1차원 배열을 선언하고 배열 크기는 4로 주세요
		//"Hi","Hello","Good","Morning"
		String str[];
		str = new String[4];
		str[0] = "Hi";
		str[1] = "Hello";
		str[2] = "Good";
		str[3] = "Morning";
		//for루프 이용해서 출력하기
		for(int i= 0; i<str.length;i++){
			System.out.println(str[i]);
		}
		//for-each루프 이용해 출력하기
		for(String x:str) {
			System.out.println(x.toUpperCase());
		}
		
		
	}//---------------------
	
	public static void main(String[] args) {
		//testArray() 호출하기
		ArrayTest obj = new ArrayTest();
		obj.testArray();
		
		//testArray2() 호출하기//static메서드 => 클래스 메서드
		ArrayTest.testArray2();
	}

}
