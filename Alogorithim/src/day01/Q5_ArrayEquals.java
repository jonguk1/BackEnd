package day01;

import java.util.Arrays;
import java.util.Scanner;

public class Q5_ArrayEquals {
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
	
	public boolean equalsArray(int[] a, int[] b) {
		boolean result = true;
		//a�� b�� ����� ��Ұ��� ������ true, �ٸ��� false��ȯ
		if(a.length != b.length) {
			result=false;
		}
		for(int i=0;i<a.length;i++) {
			if(a[i] !=b[i]) {
				result=false;
				break;
			}
		}
		
		
		return result;
	}
	
	public boolean equalsArray2(int[] a, int[] b) {
		return Arrays.equals(a, b);
		
	}
	
	public static void main(String[] args) {
		//�迭 2�� input() ���� ��ȯ �޾� ���ϼ���
		Q5_ArrayEquals q = new Q5_ArrayEquals();
		int[] a = q.input(1);
		int[] b = q.input(2);
		boolean result = q.equalsArray2(a, b);
		
		if(result) {
			System.out.println("�迭 a�� b�� �����ϴ�");
		}else {
			System.out.println("�迭 a�� b�� �����ʽ��ϴ�");
		}
		
		

	}

}
