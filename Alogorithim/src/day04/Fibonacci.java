package day04;

import java.util.Scanner;

public class Fibonacci {
	
	static int [] arr;
	//1 1 2 3 5 8 13 21 34 55 ....
	//�ݺ����� �̿��� �Ǻ���ġ ������ �����غ�����
	public static void fibo(int num) {
		int num1=1;
		int num2=1;
		int num3=0;
		System.out.print(num1+" "+num2+" ");
		for(int i=0;i<num-2;i++) {
			num3=num1+num2;
			System.out.print(num3+" ");
			num1=num2;
			num2=num3;
		}
	}//------------------------
	
	//1 1 2 3 5 8 13 21 34 55 ....
	//��� �Լ��� �̿��� �Ǻ���ġ ������ �����غ�����
	public static int fibo2(int n) {
		if(n==1) return 1;
		if(n==2) return 1;
		
		return fibo2(n-2)+fibo2(n-1);
	}//---------------------------
	
	public static int fibo3(int n) {
		if(n==1) return arr[n]=1;
		else if(n==2) return arr[n]=1;
		else
			return arr[n]=fibo3(n-2)+fibo3(n-1);
	}//--------------------------
	//���� ������ �ݺ��������� �ʵ��� ���� ����� ������� ����
	//�����ϵ��� �˰����� �����غ���.===> �޸������̼�
	public static int fibo4(int n) {
		////////////////////
		if(arr[n]>0) {//�̹� ������ �����ߴٸ�. ���̻� ���ȣ������ ����
			return arr[n];//�� ������� ��ȯ����.
		}
		////////////////////
		if(n==1) return arr[n]=1;
		else if(n==2) return arr[n]=1;
		else
			return arr[n]=fibo4(n-2)+fibo4(n-1);
	}//---------------------------
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�Ǻ���ġ ���� ������ �մϴ�. n�� �Է�: ");
		int n=sc.nextInt();
		arr=new int[n+1];
		//fibo3(n);
		fibo4(n);
		
		for(int i=1;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
		/*
		for(int i=1;i<=n;i++) {
			int res=fibo2(i);
			System.out.print(res+" ");
		}
		*/

	}

}
