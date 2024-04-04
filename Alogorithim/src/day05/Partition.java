package day05;

import java.util.Arrays;

public class Partition {

	public static void main(String[] args) {
		int[] arr= {5,7,1,4,6,2,3,9,8};
		System.out.println(Arrays.toString(arr));
		partition(arr);
		System.out.println("---2그룹으로 분할 뒤-------");
		System.out.println(Arrays.toString(arr));
	}
	
	static void partition(int[] arr) {
		int pl=0;//증가
		int pr=arr.length-1;//감소
		int pivot=arr[arr.length/2];//기준 피벗
		while(pl<=pr) {
			while(arr[pl] < pivot) pl++;
			while(arr[pr] > pivot) pr--;
			if(pl<=pr) {
				swap(arr, pl, pr);
				pl++;
				pr--;
			}
			System.out.println("pivot: " + pivot);
		}
		
		
	}
	static void swap(int[] arr,int i, int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}

}
