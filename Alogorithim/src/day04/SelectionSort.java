package day04;

import java.util.Arrays;

//���� ����: �ּ�(�Ǵ� �ִ�)���� �����ؼ� �ش� ���� �� ��ġ���� ������ �δ� �˰���
public class SelectionSort {

	public static void main(String[] args) {
		int arr[]= {6,4,8,3,1,9,7};
		System.out.println(Arrays.toString(arr));
		System.out.println("---���� ������----------------");
		selectionSort(arr);
	}//----------------------

	private static void selectionSort(int[] arr) {
		//�ּҰ��� �ִ� ���� �ε��� ��ȣ�� �˾Ƴ���.
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
