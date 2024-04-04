package day05;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		int[] arr= {6,4,1,7,3,9,8};
		System.out.println(Arrays.toString(arr));
		insertSort2(arr);
		System.out.println("---삽입 정렬 후-------------------");
		System.out.println(Arrays.toString(arr));
	}
	
	static void insertSort(int[] a) {
		for(int i=1;i<a.length;i++) {
			int tmp=a[i];//삽입할 데이터. 삽입할 위치를 찾아간다
			int j=i-1;
			for(;j>=0;j--) {
				if(a[j]>tmp) {
					a[j+1]=a[j];//뒤로 밀어내기
				}else {
					break;
				}
			}
			a[j+1]=tmp;//삽입할 위치를 찾았다면 삽입
			System.out.println(i+ ":" + Arrays.toString(a));
		}
		
	}
	
	static void insertSort2(int[] a) {
		for(int i=1;i<a.length;i++) {
			int tmp=a[i];
			int j=i-1;
			for(;j>=0 && a[j]>tmp;j--) {
				a[j+1]=a[j];
			}
			a[j+1]=tmp;
		}
	}

}
