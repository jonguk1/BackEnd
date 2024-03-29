package day01;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		// 배열 카피 : (얕은 복사, 깊은 복사)
		int [] a= {10,20,30};
		int tmp[];
		
		tmp=a;//얕은 복사 같은 배열을 참조하고 있음
		System.out.println("a: " + Arrays.toString(a) + ", " + a);
		System.out.println("tmp: " + Arrays.toString(tmp) + ", " + tmp);
		
		tmp[1] =200;
		System.out.println("a: " + Arrays.toString(a) + ", " + a);
		System.out.println("tmp: " + Arrays.toString(tmp) + ", " + tmp);
		System.out.println("----------------------------------");
		
		//clone(): 깊은 복사. 실제 저장된 요소들을 카피해서 새로운 배열을 생성
		int[] b=a.clone();
		System.out.println("a: " + Arrays.toString(a) + ", " + a);
		System.out.println("b: " + Arrays.toString(b) + ", " + b);
		

	}

}
