package day04;

import java.util.Arrays;

//선택 정렬: 최소(또는 최대)값을 선택해서 해당 값을 앞 위치부터 가져다 두는 알고리즘
public class SelectionSort {

	public static void main(String[] args) {
		int arr[]= {6,4,8,3,1,9,7};
		System.out.println(Arrays.toString(arr));
		System.out.println("---선택 정렬후----------------");
		selectionSort(arr);
	}//----------------------

	private static void selectionSort(int[] arr) {
		//최소값이 있는 곳의 인덱스 번호를 알아내자.
		for(int i=0;i<arr.length-1;i++) {
			int min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min] > arr[j]) {
					min=j;
				}
			}//for------
			int tmp=arr[min];
			arr[min]=arr[i];
			arr[i]=tmp;
			System.out.println(i+": "+Arrays.toString(arr));
		}//for-----------
		
	}

}
