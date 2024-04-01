package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Backjoon1 {
	
	public int[] sumArr(int b,int[] range,int[] arr) {
		
		int[] sumArr= new int[b];
		
		for(int i=0;i<b;i++) {
			int sum=0;
			int start = range[2*i];
			int end = range[2*i+1];
			for(int j=start-1;j<end;j++) {
				sum+=arr[j];
			}
			sumArr[i]=sum;
		}
		
		return sumArr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� ������ �Է��ϼ���");
		int a= sc.nextInt();
		
		System.out.println("���� ���ؾ��ϴ� ������ �Է��ϼ���");
		int b= sc.nextInt();
		
		System.out.println("�迭�� �Է��ϼ���");
		int[] arr = new int[a]; 
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("���� ���ؾ��ϴ� ������ �Է��ϼ���");
		int[] range= new int[b*2];
		for(int j =0; j<range.length;j++) {
			range[j] = sc.nextInt();
		}
		
		Backjoon1 bj = new Backjoon1();
		int[] sumArr = bj.sumArr(b, range, arr);

		for(int i=0;i<sumArr.length;i++) {
			System.out.println(sumArr[i]);
		}
		
	}

}
