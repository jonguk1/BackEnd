package day04;

public class ForTest {

	public static void main(String[] args) {
		/*
		 * ★★★★★
		 * ★★★★★
		 * ★★★★★
		 * ★★★★★
		 * 
		 * */
		for(int k =0;k<4;k++) {
			for(int i = 0;i<5;i++) {
				System.out.print("★");
			}//안쪽 for---------
			System.out.print("\n");
		}//바깥쪽 for--------
		
		System.out.println("1---------------------------------------------");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("2---------------------------------------------");
		
		for(int i=0;i<5;i++) {
			System.out.print(" ".repeat(4-i));
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
		System.out.println("3---------------------------------------------");
		
		for(int i=0; i<3;i++) {
			for(int k=0; k<5;k++) {
				if(i+k >=2 && k-i<=2) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		
		/*
		 * 
		[문제1]
		
		★
		★★
		★★★
		★★★★
		
		[문제2]
		    *
		   **
	      ***
	     ****
		
		[문제3]
		
		  *
		 ***
		*****
		
		
		
		 * 
		 * */

	}//main

}//class
