package day05;
//���������� �ϱ� ���� 2���� �迭�� �ϳ��� �����ϴ� ������ �����غ���

import java.util.Arrays;

public class MergeArray {

	public static void main(String[] args) {
		int[] a= {2,4,6,8,10};//5��
		int[] b= {1,2,5,9,11,13,21,25};//8��
		//�迭 a,b�� �����Ͽ� �迭 c�� ��������
		
		int[] c= new int[a.length+b.length];//13��
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		merge(a,b,c);
		System.out.println("------a,b�� ������ �� c-------------------");
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
	}

	private static void merge(int[] a, int[] b, int[] c) {
		int pa=0; //a �迭�� �ε����� ����� ������
		int pb=0; //b �迭�� �ε����� ����� ������
		int pc=0; //c �迭�� �ε����� ����� ������
		
		//a�� ����� ���� b�� ����� ���� ���ؼ�
		//�� �������� ���� c�� �����Ѵ�. �׷��鼭 ���������� �����͸� ������Ų��
		while(pa<a.length &&pb<b.length) {
			if(a[pa]<b[pb]) {
				c[pc++]=a[pa++];
			}else {
				c[pc++]=b[pb++];
			}
		}
		
		//a �Ǵ� b�� �����ִ� �����Ͱ� �ִٸ� �����ִ� ��Ҹ� ��� c�� �ű��
		while(pa<a.length) {//a�迭�� �����ִ� �����Ͱ� �ִٸ�
			c[pc++]=a[pa++];
		}
		while(pb<b.length) {//b�迭�� �����ִ� �����Ͱ� �ִٸ�
			c[pc++]=b[pb++];
		}
		
		
		
	}

}
