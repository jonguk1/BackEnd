package day04;
//재귀함수를 이용하여 10진수 정수(양수)를 2진수로 바꾸어 출력하기
public class BinaryNumRecur {
	
	public static void binary(int num) {
		//종료조건
		if(num<=0) return;
		//재귀 단계		
		binary(num/2);
		System.out.print(num%2);		
	}//-----------------
	public static void radixNum(int num, int radix) {
		if(num<=0) return;
		radixNum(num/radix, radix);
		String str="0123456789ABCDEF";
		System.out.print(str.charAt(num%radix));
	}//-----------------
	public static void main(String[] args) {
		//binary(5);
		//binary(8);
		radixNum(45, 8);//8진수로 변환
		System.out.println();
		radixNum(45,16);//16진수로 변환
	}//----------------------

}///////////////////////////////////////
