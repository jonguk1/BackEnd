package day04;

import java.util.*;

//static메서드=> 클래스 메서드 ==> 클래스.메서드()
//non-static 메서드 =>인스턴스(객체) 메서드 ==> 객체명.메서드()
public class ArrayTest {

	public static void test1() {
		System.out.println("1. 1차원 배열---------------");
		int[] arr = {1,2,3};
		System.out.println(arr);//배열은 참조형, 주소값 출력
		System.out.println("arr[0]=" + arr[0]);
		System.out.println("arr[1]=" + arr[1]);
		System.out.println("arr[2]=" + arr[2]);
		/**1. 선언
		 * 2.메모리 할당
		 * 3.초기화
		 *
		 */
		
		// 1.선언
		int b[];//1차원 배열 선언
		double[]c;//1차원 배열 선언
		
		//2. 메모리 할당
		b = new int[5];//배열 크기: 5
		c=  new double[2];//배열 크기: 2
		System.out.println("b[0]= " + b[0] );
		System.out.println("c[0]= " + c[0] );
		
		b[0] = 10;
		b[1] = 20;
		b[2] = 30;
		b[3] = 40;
		b[4] = 50;
		System.out.println("b[0] = " + b[0]);
		//배열 c도 초기화 해보세요
		c[0] = .456;
		c[1] = 'A';
		System.out.println("c[0]= " + c[0] );
		System.out.println("c[1]= " + c[1] );
		
		//배열의 속성
		System.out.println("b.length:" + b.length);
		System.out.println("c.length:" + c.length);
		
		//for루프문을 이용해서 배열 b가 가진 값을 한꺼번에 출력하세요
		for(int i =0; i<b.length;i++) {
			System.out.println("b["+i+"] =" + b[i]);
		}
		
		
		//1+2 선언과 동시에 메모리 할당
		char[] ch = new char[3];
		//초기화
		ch[0] = 'H';
		ch[1] = 'i'; 
		ch[2] = '?'; 
		
		//for루프 이용해 ch저장한 값 출력
		for(int i =0;i<ch.length;i++) {
			System.out.println("ch["+i+"] = " + ch[i]);
		}
	}
	
	public void test2() {
		System.out.println("2. 2차원 배열---------------");
		//[1] float타입의 배열 요소를 받아들이는
		//			배열을 선언하고 크기는 3만큼 잡는다.
		//			인덱스0에는 -16.1을 넣어주고,
		//			인덱스1에는 200.1
		//			인덱스 2에는 30E-7의 값을 넣어주자.
	 	// 반복문 이용해 저장된 값을 출력하세요
		float[] arr = new float[3];
		
		arr[0] = -16.1f;
		arr[1] = 200.1f;
		arr[2] = 30E-7f;
		
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		
	}
	
	public static void main(String[] args) {
		ArrayTest.test1();
		
		ArrayTest obj = new ArrayTest();
		obj.test2();
		
		//Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();
	}

}
