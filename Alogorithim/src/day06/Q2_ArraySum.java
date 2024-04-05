package day06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q2_ArraySum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("격자판수 입력");
		int n=sc.nextInt();
		int[][] arr=new int[n][n];
		System.out.println(n+"행"+"열에 저장할 값 입력");
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int max=solution2(arr);
		System.out.println("각 행,열,대각선의 1/2 합의 최대값: " + max);
				
	}

	private static int solution(int[][] arr) {
		int row_sum, col_sum;
		int d1=0,d2=0;
		int max=999;
		for(int i=0; i<arr.length;i++) {
			row_sum=0;
			col_sum=0;
			for(int j=0;j<arr.length;j++) {
				col_sum+=arr[i][j];
				row_sum+=arr[j][i];
				if(i==j) {
					d1+=arr[i][j];
				}
				if(i+j==arr.length-1) {
					d2+=arr[i][j];
				}
			}
			
			System.out.println(col_sum+"/"+row_sum+"/"+d1+"/"+d2);
			if(col_sum>max) {
				max=col_sum;
			}
			if(row_sum>max) {
				max=row_sum;
			}
			if(d1>max) {
				max=d1;
			}
			if(d2>max) {
				max=d2;
			}
		}
		return max;
	}
	
	private static int solution2(int[][] arr) {
		int row_sum, col_sum;
		int d1=0,d2=0;
		int max=999;
		List<Integer> list=new ArrayList<>();
		for(int i=0; i<arr.length;i++) {
			row_sum=0;
			col_sum=0;
			for(int j=0;j<arr.length;j++) {
				col_sum+=arr[i][j];
				row_sum+=arr[j][i];
				if(i==j) {
					d1+=arr[i][j];
				}
				if(i+j==arr.length-1) {
					d2+=arr[i][j];
				}
			}
			list.add(col_sum);list.add(row_sum);
			System.out.println(col_sum+"/"+row_sum+"/"+d1+"/"+d2);
		}
		list.add(d1);list.add(d2);
		//Collections.sort(list);
		Collections.sort(list,(o1,o2)->Integer.compare(o2, o1));//내림차순
		//람다식
		System.out.println(list);
		max=list.get(0);
		return max;
	}

}
