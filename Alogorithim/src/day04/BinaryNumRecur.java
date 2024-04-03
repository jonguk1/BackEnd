package day04;

public class BinaryNumRecur {

	public static void binary(int num) {
		//종료조건
		if(num<=0) {
			return;
		}
		//재귀 단계
		binary(num/2);
		System.out.print(num%2);
		
	}
	
	public static void radixNum(int num,int radix) {
		if(num>0) {
			radixNum(num/radix,radix);
			String str="0123456789ABCDEF";
			System.out.print(str.charAt(num%radix)); 
		}
	}
	
	public static void main(String[] args) {
		//binary(1);
		radixNum(52, 8);
		System.out.println();
		radixNum(52,16);
		
	}

}
