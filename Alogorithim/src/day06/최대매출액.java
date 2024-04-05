package day06;

import java.util.Scanner;

public class 최대매출액 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("며칠의 매출기록을 입력하실래요?");
		int n=sc.nextInt();
		System.out.println("연속 며칠의 매출을 구할까요?");
		int k=sc.nextInt();
		System.out.printf("%d일간의 매출기록을 입력하세요%n", n);
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		
		int max=solution(n,k,a);
		System.out.println("최대 매출액: "+max);
	}

	private static int solution(int n, int k, int[] a) {
		int sum=0;
		int max=0;
		
		for(int i=0;i<k;i++) {
			sum+=a[i];
		}
		
		for(int i=k;i<n;i++) {
			sum=sum-a[i-k]+a[i];
			if(sum>max) {
				max=sum;
			}
		}
		return max;
	}

}
