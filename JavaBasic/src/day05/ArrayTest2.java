package day05;

import java.util.*;

public class ArrayTest2 {
	
	public static void foo() {
		System.out.println("1. 참조형 배열----------------------");
		//java.lang.Object클래스=> 모든 클래스의 부모 클래스
		Object[] arr = new Object[5];
		//Object유형의 배열에는 모든 유형의 객체를 저장할수 있다.
		arr[0] = new Object();
		arr[1] = "Hello";
		arr[2] = new Random();
		arr[3] = new Date();
		arr[4] = new Scanner(System.in);
		
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i]);
			System.out.println(arr[i].toString());
			System.out.println("******************");
		}
		System.out.println("--------------------");
		
		//for-each루프문 이용해서 arr에 저장된 값 출력
		for(Object obj: arr) {
			System.out.println(obj);
		}
	}
	
	public void bar() {
		System.out.println("2. 1차원 배열----------------------");
		int[] a = {10,20};
		int b[] = {9,8,7,6};
		int c[];//배열 전환
		c=a;
		//c는 a가 참조하는 배열을 같이 참조하는 형태가 된다
		System.out.println("a:" + a);
		System.out.println("b:" + b);
		System.out.println("c:" + c);
		for(int v:a) {
			System.out.println(v);
		}
		
		c[1] = 70;
		System.out.println("c[1]: " + c[1]);
		System.out.println("a[1]: " + a[1]);
		
		System.out.println("**********");
		
		int[] x= {1,2,3,4,5};
		int[] y= {100,200};
		int[] tmp;
		
		//x와 y의 배열을 서로 바꿔 참조하도록 해보기 -swap
		tmp = x;
		x = y;
		y= tmp;
		for(int i:x) {
			System.out.println(i);
		}
		System.out.println("**********");
		for(int k:y) {
			System.out.println(k);
		}
	}

	public static void main(String[] args) {
		// foo() 호출하기
		ArrayTest2.foo();
		//bar() 호출하기
		ArrayTest2 at = new ArrayTest2();
		at.bar();

	}

}
