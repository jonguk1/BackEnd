package day04;

public class Recursive {

	public static void recursive(int n) {
		if(n<=0) {//기본단계(종료조건)
			return;
		}
		System.out.println("recursive() n: " + n);
		recursive(n-1);//재귀 단계 
	}
	
	
	public static void main(String[] args) {
		recursive(4);
	}

}
