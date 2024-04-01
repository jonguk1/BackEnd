package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Q8_SumInteval {
	static Scanner sc= new Scanner(System.in);
	
	public static int[] solution(int n,int m) {
		int answer[]= new int[m];//������ ���� ������ �迭
		int[] a=new int[n];
		System.out.println("�迭�� ������ ������ �Է�");
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println("������ ���۰�, ���� �Է�");
		for(int i=0;i<m;i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			int sum=0;
			for(int x=start;x<=end;x++) {
				sum+=a[x-1];//������ ��
			}
			answer[i]=sum;
		}
		return answer;
	}
	
	public static int[] solution2(int n,int m) {
		int answer[]= new int[m];//������ ���� ������ �迭
		int[] a=new int[n];
		System.out.println("�迭�� ������ ������ �Է�");
		int[] sumArr=new int[n+1];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
			sumArr[i+1]=sumArr[i]+a[i];
		}
		System.out.println("������ ���۰�, ���� �Է�");
		for(int i=0;i<m;i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			
			int result =sumArr[end]-sumArr[start-1];
			answer[i]=result;
		}
		return answer;
	}
	
	
	public static void main(String[] args) {
		System.out.println("�迭 ũ�� �Է�(N): ");
		int n=sc.nextInt();
		
		System.out.println("������ ���� ��� ���ұ��?(M): ");
		int m= sc.nextInt();
		
		int[] arr=solution2(n, m);
		System.out.println(Arrays.toString(arr));
		

	}

}
