package day02;

import java.util.Arrays;

public class Q13_PrimeNum {

	public static void solution() {
		int[] prime = new int[500];//�Ҽ��� ������ �迭
		int ptr=0;
		prime[ptr++]=2;//�Ҽ� prime[0]=2, ptr=1;
		int cnt=0;
		for(int i=3;i<=1000;i+=2) {//�Ǻ� ����� Ȧ���� �ϵ���
			int j;
			for(j=1;j<ptr;j++) {
				cnt++;
				if(i%prime[j]==0) {
					break;
				}
			}
			if(ptr==j)
				prime[ptr++]=i;
		}
		//System.out.println(Arrays.toString(prime));
		for(int i=0;i<ptr;i++) {
			System.out.print(prime[i] + ", ");
		}
		System.out.println();
		System.out.println("���� Ƚ��: " + cnt);
		
	}
	
	public static void main(String[] args) {
		solution();
	}

}
