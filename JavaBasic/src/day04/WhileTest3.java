package day04;

public class WhileTest3 {

	public static void main(String[] args) {
		//[문제1] 중첩 while루프를 이용해서 구구단 전체를 아래와 같은
		//형태로 출력하세요
		/*
		2 x 1=2     3x1=3		4x1=4 .....  9x1=9
		2 x 2=4		3x2=6 ...
		...
		2 x 9=18	
		*/
		
		int i =1;
		while(i < 10) {
			int k =2;
			while(k<10) {
				System.out.printf("%dx%d=%2d\t",k,i,k*i);
				k++;
			}
			System.out.println();
			i++;
		}

	}

}
