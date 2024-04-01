package day02;

import java.util.Scanner;

//회문 문자열
public class Q11_Pallindrome {

	public static String solution(String str) {
		String answer="Pallindrom YES";
		char[] arr= str.toLowerCase().toCharArray();
		for(int i=0;i<arr.length;i++) {
			if(arr[i] != arr[arr.length-i-1]) {
				answer="Pallindrom NO";
				break;
			}
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("문자열을 입력하세요");
		String str=sc.next();
		System.out.println(solution(str));
		//Pallindrome OK/NO
	}

}
