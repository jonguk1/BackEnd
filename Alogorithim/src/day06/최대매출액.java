package day06;

import java.util.Scanner;

public class �ִ����� {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("��ĥ�� �������� �Է��ϽǷ���?");
		int n=sc.nextInt();
		System.out.println("���� ��ĥ�� ������ ���ұ��?");
		int k=sc.nextInt();
		System.out.printf("%d�ϰ��� �������� �Է��ϼ���%n", n);
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		
		int max=solution(n,k,a);
		System.out.println("�ִ� �����: "+max);
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
