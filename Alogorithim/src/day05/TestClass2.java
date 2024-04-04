package day05;

import java.util.ArrayList;
import java.util.Scanner;

//두 배열의 공통원소 추출
public class TestClass2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("배열1의 개수: ");
		int n1 = sc.nextInt();
		System.out.println("배열2의 개수: ");
		int n2 = sc.nextInt();
		System.out.println("배열1에 저장할 값을 오름차순으로 입력: ");
		int[] arr1 = new int[n1];
		for (int i = 0; i < n1; i++) {
			arr1[i] = sc.nextInt();
		}
		System.out.println("배열2에 저장할 값을 오름차순으로 입력: ");
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
