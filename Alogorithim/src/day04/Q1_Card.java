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
			q.offer(i); // 1부터 n까지 q에 삽입
		}
		System.out.println(q);
		
		while(q.size() > 1) // q의 크기가 1보다 클 경우 반복, 1보다 작으면 while문 빠져 나오기
		{
			q.poll(); // 맨 앞 원소 삭제
			q.offer(q.poll()); // 맨 앞 원소 버리기 + 맨 뒤에 삽입
		}
		
		System.out.println(q.poll());
		
	}

}