package day04;
import java.util.*;
public class BubbleSort {
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("배열 크기 입력: ");
		int n=sc.nextInt();
		int[] arr=new int[n];
		
		Random ran=new Random(5);//seed값: 5
		for(int i=0;i<n;i++) {
			arr[i]=ran.nextInt(15)+1;//1<= r <16
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("----버블 정렬후 ---------------");
		bubble(arr);
		//bubble2(arr);
		System.out.println(Arrays.toString(arr));

	}//--------------------
	//앞에서부터 버블 정렬 ==> 1회 반복돌고 나면 가장 큰수가 오른쪽에 있다.
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
	//뒤에서부터 버블 정렬 ==> 1회 반복돌고 나면 가장 작은수가 왼쪽에 있다.
	public static void bubble2(int[] arr) {
		int cnt=0;
		for(int i=0;i<arr.length-1;i++) {
			int k=0;
			for(int j=arr.length-1;j>i;j--) {
				if(arr[j-1]>arr[j]) {
					swap(arr, j-1, j);
					k++;//교환횟수를 세어보자. swap할 일이 있으면 1씩 증가
				}//if--
				cnt++;
			}//for---
			if(k==0) break;//k가 0이라면 이미 정렬을 마쳤다는 의미
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















