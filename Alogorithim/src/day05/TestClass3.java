package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//������ �ִ��� ���ϱ�
public class TestClass3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ڿ��� N�� �Է��ϼ���");
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
				sumWidth += arr[i][j];// �� ���ϱ�
				sumHeight += arr[j][i];// �� ���ϱ�
				if (i == j) {
					sumDiagonal1 += arr[i][j];// ���ʺ��� ������ �밢�� ���ϱ�
					sumDiagonal2 += arr[arr.length - i - 1][arr.length - j - 1];// �����ʺ��� ���� �밢�� ���ϱ�
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
