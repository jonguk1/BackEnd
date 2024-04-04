package day04;
import java.util.*;
public class BubbleSort {
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�迭 ũ�� �Է�: ");
		int n=sc.nextInt();
		int[] arr=new int[n];
		
		Random ran=new Random(5);//seed��: 5
		for(int i=0;i<n;i++) {
			arr[i]=ran.nextInt(15)+1;//1<= r <16
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("----���� ������ ---------------");
		bubble(arr);
		//bubble2(arr);
		System.out.println(Arrays.toString(arr));

	}//--------------------
	//�տ������� ���� ���� ==> 1ȸ �ݺ����� ���� ���� ū���� �����ʿ� �ִ�.
	public static void bubble(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j] >arr[j+1]) {
					int tmp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=tmp;
				}//if------
			}//for----------
			System.out.println(i+": "+Arrays.toString(arr));
		}//for-------------
	}//--------------------------------
	//�ڿ������� ���� ���� ==> 1ȸ �ݺ����� ���� ���� �������� ���ʿ� �ִ�.
	public static void bubble2(int[] arr) {
		int cnt=0;
		for(int i=0;i<arr.length-1;i++) {
			int k=0;
			for(int j=arr.length-1;j>i;j--) {
				if(arr[j-1]>arr[j]) {
					swap(arr, j-1, j);
					k++;//��ȯȽ���� �����. swap�� ���� ������ 1�� ����
				}//if--
				cnt++;
			}//for---
			if(k==0) break;//k�� 0�̶�� �̹� ������ ���ƴٴ� �ǹ�
			System.out.println(i+": "+Arrays.toString(arr));
		}//for----------------
		System.out.println("bubble2() cnt: "+cnt);
	}//--------------------------------
	
	public static void swap(int [] arr, int m, int n) {
		int tmp=arr[m];
		arr[m]=arr[n];
		arr[n]=tmp;
	}//-------------------------------

}















