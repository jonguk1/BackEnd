package day04;
//아웃풋이 어떻게 나올지 예측해보세요
public class Recursion {
	
	public static void recur(int n) {
		if(n<=0) return;
		recur(n-1);
		System.out.println(n);
		recur(n-2);
	}//----------------------
	public static void main(String[] args) {
		recur(4);
	}//----------------------
}////////////////////////////
