package day04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1_Card {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> q = new LinkedList<>();
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++)
		{
			q.offer(i); // 1���� n���� q�� ����
		}
		System.out.println(q);
		
		while(q.size() > 1) // q�� ũ�Ⱑ 1���� Ŭ ��� �ݺ�, 1���� ������ while�� ���� ������
		{
			q.poll(); // �� �� ���� ����
			q.offer(q.poll()); // �� �� ���� ������ + �� �ڿ� ����
		}
		
		System.out.println(q.poll());
		
	}

}