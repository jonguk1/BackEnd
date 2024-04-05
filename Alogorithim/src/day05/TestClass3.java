package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//격자판 최대합 구하기
public class TestClass3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("자연수 N을 입력하세요");
		int n = sc.nextInt();

		int[][] arr = new int[n][n];

		ArrayList<Integer> sumList = new ArrayList<>();

		int sumWidth = 0;
		int sumHeight = 0;
		int sumDiagonal1 = 0;
		int sumDiagonal2 = 0;

		for (int i = 0; i < arr.length; i++) {
			sumWidth=0;
			sumHeight=0;
			for (int j = 0; j < arr.length; j++) {
				int data = sc.nextInt();
				arr[i][j] = data;
				sumWidth += arr[i][j];// 행 더하기
				sumHeight += arr[j][i];// 열 더하기
				if (i == j) {
					sumDiagonal1 += arr[i][j];// 왼쪽부터 오른쪽 대각선 더하기
					sumDiagonal2 += arr[arr.length - i - 1][arr.length - j - 1];// 오른쪽부터 왼쪽 대각선 더하기
				}
			}
			sumList.add(sumWidth);
			sumList.add(sumHeight);
		}
		sumList.add(sumDiagonal1);
		sumList.add(sumDiagonal2);

		Collections.sort(sumList);
		System.out.println(sumList.size());
		System.out.println(sumList.get(sumList.size()-1));

	}

}
