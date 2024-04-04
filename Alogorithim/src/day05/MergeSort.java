package day05;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {5,6,4,8,3,7,9,0,1,5,2};
		System.out.println(Arrays.toString(arr));
		partition(arr,0,arr.length-1);
		System.out.println("---------병합정렬 후-----------");
		System.out.println(Arrays.toString(arr));
		

	}

	private static void partition(int[] arr, int left, int right) {
		if(left>=right) return;//종료조건. 분할하다 보면 left와 right값이 같아지는 순간이 생긴다
		
		int mid=(left+right)/2;//가운데 위치값 구하기
		partition(arr, left, mid);//전반부 분할
		partition(arr, mid+1, right);//후반부 분할
		
		merge(arr,left,right);//2개를 나눈 배열을 병합하는 메서드
		
	}

	private static void merge(int[] arr, int left, int right) {
		int tmp[] = new int[arr.length];//병합한 값을 담을 임시배열
		int index=0;//tmp배열에서 사용할 인덱스
		int pc=(left+right)/2;
		int pl=left;
		int pr=pc+1;
		index=left;
		
		while(pl<=pc && pr<=right) {
			if(arr[pl] < arr[pr]) {
				tmp[index++]=arr[pl++];
			}else {
				tmp[index++]=arr[pr++];
			}
			
		}
		
		if(pl>pc) {
			for(int i=pr;i<=right;i++) {
				tmp[index++]=arr[i];
			}
		}else {
			for(int i=pl;i<=pc;i++) {
				tmp[index++]=arr[i];
			}
		}
		for(int i=left;i<=right;i++) {
			arr[i]=tmp[i];
		}
		System.out.printf("left: %d, right: %d\n",left,right);
		System.out.println("tmp: "+Arrays.toString(tmp));
		System.out.println("tmp: "+Arrays.toString(arr));
		System.out.println("******************************");
		
	}

}
