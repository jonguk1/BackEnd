package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Q5_ArrayEquals {
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
	
	public boolean equalsArray(int[] a, int[] b) {
		boolean result = true;
		//a와 b에 저장된 요소값이 같으면 true, 다르면 false반환
		if(a.length != b.length) {
			result=false;
		}
		for(int i=0;i<a.length;i++) {
			if(a[i] !=b[i]) {
				result=false;
				break;
			}
		}
		
		
		return result;
	}
	
	public boolean equalsArray2(int[] a, int[] b) {
		return Arrays.equals(a, b);
		
	}
	
	public static void main(String[] args) {
		//배열 2개 input() 통해 반환 받아 비교하세요
		Q5_ArrayEquals q = new Q5_ArrayEquals();
		int[] a = q.input(1);
		int[] b = q.input(2);
		boolean result = q.equalsArray2(a, b);
		
		if(result) {
			System.out.println("배열 a와 b는 같습니다");
		}else {
			System.out.println("배열 a와 b는 같지않습니다");
		}
		
		

	}

}
