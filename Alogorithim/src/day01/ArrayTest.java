package day01;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		// �迭 ī�� : (���� ����, ���� ����)
		int [] a= {10,20,30};
		int tmp[];
		
		tmp=a;//���� ���� ���� �迭�� �����ϰ� ����
		System.out.println("a: " + Arrays.toString(a) + ", " + a);
		System.out.println("tmp: " + Arrays.toString(tmp) + ", " + tmp);
		
		tmp[1] =200;
		System.out.println("a: " + Arrays.toString(a) + ", " + a);
		System.out.println("tmp: " + Arrays.toString(tmp) + ", " + tmp);
		System.out.println("----------------------------------");
		
		//clone(): ���� ����. ���� ����� ��ҵ��� ī���ؼ� ���ο� �迭�� ����
		int[] b=a.clone();
		System.out.println("a: " + Arrays.toString(a) + ", " + a);
		System.out.println("b: " + Arrays.toString(b) + ", " + b);
		

	}

}
