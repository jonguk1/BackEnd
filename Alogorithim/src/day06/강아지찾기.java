package day06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ������ã�� {
	
	static int[] distance= {1, -1, 5};
	//BSF==> ť ���
	static boolean [] visited=new boolean[10001];
	static Queue<Integer> q=new LinkedList<>();
	
	public static void main(String[] args) {
		// 1. ö�� ���� ��ġ
		Scanner sc= new Scanner(System.in);
		System.out.println("ö���� ���� ��ġ �Է�: ");
		int n=sc.nextInt();
 		// 2. �������� �ִ� ��ġ �Է�
		System.out.println("�������� �ִ� ��ġ: ");
		int m=sc.nextInt();
		
		int level=solution(n, m);
		System.out.println("Level: " + level);
	}
	
	static int solution(int start, int end) {
		q.add(start);
		visited[start]=true;
		int L=0;
		while(!q.isEmpty()) {
			int size=q.size();
			System.out.println("L: " + L+"---------------");
			for(int i=0;i<size;i++) {
				int val=q.remove();//������
				System.out.print(val+" ");
				if(val==end) {
					return L;
				}
				for(int j=0;j<distance.length;j++) {
					int node=val+distance[j];
					if(!visited[node]&&node>=1&&node<=10001) {
						q.add(node);
						visited[node]=true;
					}
				}
				System.out.println();
			}
			L++;
		}
		return -1;
	}

}
