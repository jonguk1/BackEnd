package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_ArrayCopy {
	Scanner sc= new Scanner(System.in);
	
	public int[] input(int i){
		int [] arr= null;
		System.out.println("요솟수를 입력: ");
		//입력 받아 배열 메모리 할당
		int n=sc.nextInt();
		arr=new int[n];
		//반복문 돌면서 입력받아 배열에 저장하기
		for(int j=0;j<arr.length;j++) {
			System.out.println("arr"+i+"["+j+"] : ");
			arr[j] = sc.nextInt();
		}
		return arr;
	}
	public void copy(int[] a,int[] b) {
		
		int size=(a.length<b.length)?a.length:b.length;
		
		for(int i=0;i<size;i++) {
			if(a.length<b.length) {
				b[i]=a[i];
			}else {
				a[i]=b[i];
			}
		}
		
		System.out.println("카피 완료");
	}
	
	public void reverse_copy(int[] a,int[] b) {
		
		int size=(a.length<b.length)?a.length:b.length;
		
		int[] large=a;//주소값을 같이 참조, 얕은 복사
		int[] small=b;
		
		if(b.length>a.length) {
			large=b;
			small=a;
		}
		
		for(int i=0;i<size;i++) {
			large[i]=small[size-1-i];
		}
		
		System.out.println("reverse 카피 완료");
	}
	
	
	public static void main(String[] args) {
		//배열 2개 input()해서 생성하고 크기가 작은 쪽 배열 요소값을 큰 쪽 배열에 카피하세요
		//그런 뒤 그 결과값 (a, b)을 출력하세요
		Q6_ArrayCopy q = new Q6_ArrayCopy();
		int[] a = q.input(1);
		int[] b = q.input(2);
		q.copy(a, b);
		System.out.println("카피a: "+ Arrays.toString(a));
		System.out.println("카피b: "+Arrays.toString(b));
		q.reverse_copy(a, b);
		System.out.println("reverse 카피a: "+ Arrays.toString(a));
		System.out.println("reverse 카피b: "+ Arrays.toString(b));
	}

}
