package day05;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {5,6,4,8,3,7,9,0,1,5,2};
		System.out.println(Arrays.toString(arr));
		partition(arr,0,arr.length-1);
		System.out.println("---------�������� ��-----------");
		System.out.println(Arrays.toString(arr));
		

	}

	private static void partition(int[] arr, int left, int right) {
		if(left>=right) return;//��������. �����ϴ� ���� left�� right���� �������� ������ �����
		
		int mid=(left+right)/2;//��� ��ġ�� ���ϱ�
		partition(arr, left, mid);//���ݺ� ����
		partition(arr, mid+1, right);//�Ĺݺ� ����
		
		merge(arr,left,right);//2���� ���� �迭�� �����ϴ� �޼���
		
	}

	private static void merge(int[] arr, int left, int right) {
		int tmp[] = new int[arr.length];//������ ���� ���� �ӽù迭
		int index=0;//tmp�迭���� ����� �ε���
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
