package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Q1_Max {

	public static void main(String[] args) {
		//1.
		
		int a=55, b=12;
		int mx=max1(a,b);
		System.out.println("�ִ밪: " + mx);
		
		int m=235,n=122, k=789;
		int mx2=max2(m,n,k);
		System.out.println("�ִ밪2: "  + mx2);
		
		int c=235,d=122, e=789, f=999;
		int mx3=max3(c, d, e, f);
		System.out.println("�ִ밪3: "  + mx3);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�迭 ũ�� : ");
		int size=sc.nextInt();
		//�迭 �޸� �Ҵ�
		int[] arr = new int[size];
		//�ݺ��� ���鼭 �迭�� ������ �� �Է¹ޱ�
		System.out.println("�迭�� �����Ұ� �Է�");
		for(int i =0; i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		//min1()�Լ� ȣ��=>�ּҰ� �޾� ���
		System.out.println("�ּҰ�: " + min1(arr));
		
	}
	
	public static int min1(int[] arr) {
		Arrays.sort(arr);
		return arr[0];//�ּҰ� ��ȯ
	}

	public static int max1(int a, int b) {
		/*if(a>b) {
			return a;
		}else {
			return b;
		}*/
		
		if(a>b) {
			b=a;
		}
		return b;
		
	}
	
	public static int max2(int x, int y, int z) {
		if(x>y && x>z) {
			return x;
		}else if(y>x && y>z) {
			return y;
		}else {
			return z;
		}
	}
	
	public static int max3(int x, int y, int z, int w) {
		if(x>y && x>z && x>w) {
			return x;
		}else if(y>x && y>z && y>w) {
			return y;
		}else if(z>x && z>y && z>w){
			return z;
		}else {
			return w;
		}
	}

}
