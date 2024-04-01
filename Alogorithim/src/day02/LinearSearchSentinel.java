package day02;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchSentinel {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("�迭 ũ�� �Է�: ");
		int n =sc.nextInt();
		
		int[] arr=new int[n];
		
		int[] arr2=new int[n+1];//���ʹ����� ����� �迭. ���ʰ��� �迭 �������� ��������
		
		System.out.println("������ ������(����)�� �Է�: ");
		for(int i=0;i<n;i++) {
			arr[i]= sc.nextInt();
			arr2[i]=arr[i];
		}
		
		System.out.println(Arrays.toString(arr));
		
		System.out.println("�˻��� �� �Է�: ");
		int key=sc.nextInt();
		
		int idx=solution(arr, n, key);
		
		int idx2=solution2(arr2, n, key);
		
		System.out.println((idx<0)?key+"�� �����ϴ�" :key+"�� �迭" + idx+"���� �־��");
		System.out.println("���ʹ��� �̿��� �˻� ���: idx2: " + idx2);
		if(idx2==arr2.length-1) {
			System.out.println(key+"���� idx2�ȿ� �����ϴ�.");
		}
	}
	
	public static int solution(int [] arr, int n, int key) {
		//int result=-1;
		//���� �˻�
		/*
		 * for(int i =0;i<n;i++) { if(arr[i] ==key) { result = i; } } return result;
		 */
		int idx=0;
		while(true) {
			if(idx==n) return -1;//�˻��� ���� ���� ���
			if(arr[idx]==key) {//�˻��� ���� �ִ� ���
				return idx;
			}
			idx++;
		}
	}
	
	//���ʹ��� Ȱ���� ���� �˻�==> �Ǵ�Ƚ���� ���̴� ���
	public static int solution2(int [] arr, int n, int key) {
		arr[n]=key;//���ʰ��� �迭 ���� ����
		System.out.println("---���ʰ� ������----------------");
		System.out.println(Arrays.toString(arr));
		System.out.println("----------------------------");
		int idx=0;
		while(true) {
			if(arr[idx]==key) {//�˻��� ���� �ִ� ���
				break;
			}
			idx++;
		}
		return idx;
	}
	

}
