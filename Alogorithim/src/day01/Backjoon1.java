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
		
		System.out.println("수의 개수를 입력하세요");
		int a= sc.nextInt();
		
		System.out.println("합을 구해야하는 개수를 입력하세요");
		int b= sc.nextInt();
		
		System.out.println("배열을 입력하세요");
		int[] arr = new int[a]; 
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("합을 구해야하는 범위를 입력하세요");
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
