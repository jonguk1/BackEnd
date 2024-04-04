package day05;
//병합정렬을 하기 전에 2개의 배열을 하나로 병합하는 과정을 진행해보자

import java.util.Arrays;

public class MergeArray {

	public static void main(String[] args) {
		int[] a= {2,4,6,8,10};//5개
		int[] b= {1,2,5,9,11,13,21,25};//8개
		//배열 a,b를 병합하여 배열 c에 저장하자
		
		int[] c= new int[a.length+b.length];//13개
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		merge(a,b,c);
		System.out.println("------a,b를 병합한 후 c-------------------");
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
	}

	private static void merge(int[] a, int[] b, int[] c) {
		int pa=0; //a 배열의 인덱스를 사용할 포인터
		int pb=0; //b 배열의 인덱스를 사용할 포인터
		int pc=0; //c 배열의 인덱스를 사용할 포인터
		
		//a에 저장된 값과 b에 저장된 값을 비교해서
		//더 작은쪽의 값을 c에 저장한다. 그러면서 작은값쪽의 포인터를 증가시킨다
		while(pa<a.length &&pb<b.length) {
			if(a[pa]<b[pb]) {
				c[pc++]=a[pa++];
			}else {
				c[pc++]=b[pb++];
			}
		}
		
		//a 또는 b에 남아있는 데이터가 있다면 남아있는 요소를 모드 c에 옮긴다
		while(pa<a.length) {//a배열에 남아있는 데이터가 있다면
			c[pc++]=a[pa++];
		}
		while(pb<b.length) {//b배열에 남아있는 데이터가 있다면
			c[pc++]=b[pb++];
		}
		
		
		
	}

}
