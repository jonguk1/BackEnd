package day05;

import java.util.ArrayList;
import java.util.Scanner;

//�� �迭�� ������� ����
public class TestClass2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�迭1�� ����: ");
		int n1 = sc.nextInt();
		System.out.println("�迭2�� ����: ");
		int n2 = sc.nextInt();
		System.out.println("�迭1�� ������ ���� ������������ �Է�: ");
		int[] arr1 = new int[n1];
		for (int i = 0; i < n1; i++) {
			arr1[i] = sc.nextInt();
		}
		System.out.println("�迭2�� ������ ���� ������������ �Է�: ");
		int[] arr2 = new int[n2];
		for (int i = 0; i < n2; i++) {
			arr2[i] = sc.nextInt();
		}

		ArrayList<Integer> resultList = new ArrayList<>();

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					resultList.add(arr1[i]);
				}
			}
		}

		for (int i = 0; i < resultList.size(); i++) {
			System.out.print(resultList.get(i) + " ");
		}

	}

}
