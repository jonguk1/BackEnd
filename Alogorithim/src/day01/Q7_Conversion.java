package day01;

import java.util.Scanner;

public class Q7_Conversion {

	public static String conv_binary(int num) {
		String answer="";	
		
		int[] arr=new int[32];
		int cnt=0;
		do {
			int mod=num%2;
			arr[cnt++]=mod;
			num/=2;
		}while(num!=0);
		
		for(int i =0;i<cnt;i++) {
			answer+=arr[cnt-1-i];
		}
		
		/*
		while(num>0) {
			answer = String.valueOf(num%2) + answer;
			num=num/2;
		}
		*/
		return answer;
	}
	
	public static String conv_binary2(int num) {
		StringBuffer buf= new StringBuffer("");
		do {
			int mod=num%2;
			buf.append(mod);
			num/=2;
		}while(num!=0);
		return buf.reverse().toString();
	}
	
	public static String conv_radix(int num, int radix) {
		String str="0123456789ABCDEF";
		String answer="";
		do {
			answer=str.charAt(num%radix) + answer;
		    num/=radix;
		}while(num!=0);
		return answer;
	}
	
	public static String conv_binary8(int num) {
		String answer="";	
		
		while(num>0) {
			answer = String.valueOf(num%8) + answer;
			num=num/8;
		}
		return answer;
	}
	
	public static String conv_binary16(int num) {
		String answer="";	
		
		while(num>0) {
			if(num%16==10) {
				answer = "A"+ answer;
			}else if(num%16==11) {
				answer = "B"+ answer;
			}else if(num%16==12) {
				answer = "C"+ answer;
			}else if(num%16==13) {
				answer = "D"+ answer;
			}else if(num%16==14) {
				answer = "E"+ answer;
			}else if(num%16==15) {
				answer = "F"+ answer;
			}else {
				answer = String.valueOf(num%16) + answer;
			}
			num=num/16;
		}
		return answer;
	}
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("양의 정수를 입력: ");
		int num = sc.nextInt();
		//System.out.println("2진수: " + conv_binary(num));
		//System.out.println("2진수: " + conv_binary2(num));
		//System.out.println("8진수: " + conv_binary8(num));
		//System.out.println("16진수: "+ conv_binary16(num));
		System.out.println("몇진수로 바꿀까요(2~16): ");
		int radix=sc.nextInt();
		System.out.println(conv_radix(num, radix));

	}

}
