package day01;

import java.util.Arrays;

public class Q2_Median {

	public static int median(int a, int b, int c) { 
		if((a>=b && b>=c) || (c>=b&& b>=a)) {
			return b;
		}else if((c>=a && a>=b) || (b>=a && a>=c)) {
			return a;
		}else {        
			return c;//중앙값 반환하기
		}
		

	}
	public static void main(String[] args) {
		int x =233, y=330, z=88;
		int res=median(x, y, z);
		System.out.printf("%d,%d,%d 값의 중앙값은: %d\n", x, y, z, res);
	}

}
