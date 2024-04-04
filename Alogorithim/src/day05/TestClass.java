package day05;

import java.util.Scanner;

//등수 구하기
public class TestClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 수 입력: ");
		int n = sc.nextInt();
		System.out.println("국어 성적 " + n + "개 입력");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		TestClass test = new TestClass();

		int[] rank = test.solution(arr);

		for (int i = 0; i < rank.length; i++) {
			System.out.print(rank[i] + " ");
		}
	}

	public int[] solution(int[] arr) {
		int[] rank = new int[arr.length];
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			cnt = 1;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					cnt++;
				}
			}
			rank[i] = cnt;
		}
		return rank;
	}

}
