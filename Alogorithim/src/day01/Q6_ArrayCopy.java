package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_ArrayCopy {
	Scanner sc= new Scanner(System.in);
	
	public int[] input(int i){
		int [] arr= null;
		System.out.println("��ڼ��� �Է�: ");
		//�Է� �޾� �迭 �޸� �Ҵ�
		int n=sc.nextInt();
		arr=new int[n];
		//�ݺ��� ���鼭 �Է¹޾� �迭�� �����ϱ�
		for(int j=0;j<arr.length;j++) {
			System.out.println("arr"+i+"["+j+"] : ");
			arr[j] = sc.nextInt();
		}
		return arr;
	}
	public void copy(int[] a,int[] b) {
		
		int size=(a.length<b.length)?a.length:b.length;
		
		for(int i=0;i<size;i++) {
			if(a.length<b.length) {
				b[i]=a[i];
			}else {
				a[i]=b[i];
			}
		}
		
		System.out.println("ī�� �Ϸ�");
	}
	
	public void reverse_copy(int[] a,int[] b) {
		
		int size=(a.length<b.length)?a.length:b.length;
		
		int[] large=a;//�ּҰ��� ���� ����, ���� ����
		int[] small=b;
		
		if(b.length>a.length) {
			large=b;
			small=a;
		}
		
		for(int i=0;i<size;i++) {
			large[i]=small[size-1-i];
		}
		
		System.out.println("reverse ī�� �Ϸ�");
	}
	
	
	public static void main(String[] args) {
		//�迭 2�� input()�ؼ� �����ϰ� ũ�Ⱑ ���� �� �迭 ��Ұ��� ū �� �迭�� ī���ϼ���
		//�׷� �� �� ����� (a, b)�� ����ϼ���
		Q6_ArrayCopy q = new Q6_ArrayCopy();
		int[] a = q.input(1);
		int[] b = q.input(2);
		q.copy(a, b);
		System.out.println("ī��a: "+ Arrays.toString(a));
		System.out.println("ī��b: "+Arrays.toString(b));
		q.reverse_copy(a, b);
		System.out.println("reverse ī��a: "+ Arrays.toString(a));
		System.out.println("reverse ī��b: "+ Arrays.toString(b));
	}

}
