package day02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q17_PointSort {

	public static void main(String[] args) {
		// x,y��ǥ�� ���� Point Ŭ������ �����Ͽ� �����ϼ���
		// �켱 x��ǥ �������� �����ϵ�, x���� ���� �� ���� y������������ �����ϼ���		
		PointBinarySearch();
	}

	public static void PointBinarySearch() {
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		Point[] points= new Point[num];
		
		int[] x = new int[num];
		int[] y = new int[num];
		
		for(int i=0;i<num;i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			points[i] = new Point(x[i],y[i]);
		}
		Arrays.sort(points);
		System.out.println("");
		for(int i=0;i<points.length;i++) {
			System.out.println(points[i]);
		}
		
	}

}
