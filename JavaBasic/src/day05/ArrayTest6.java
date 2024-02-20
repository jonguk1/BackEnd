package day05;

import java.util.Random;

public class ArrayTest6 {

	public static void solution1() {
		System.out.println("---성적 확인 문제--------");
		String subject[] = {"국어", "수학", "영어", "과탐", "사탐"};
		//1학기 성적
		int[] term1 = {99, 75, 82, 50, 48};
		int[] term2 = {80, 82, 100, 50, 42};
		
		//1. 성적이 2학기에 향상된 과목수를 출력
		int count =0;
		
		for(int i =0;i<term1.length;i++) {
			if(term1[i] < term2[i]) {
				count++;
			}
		}
		System.out.println("향상된 과목수 : " + count);
		
		//2. 성적이 1,2학기에서 동일한 과목수, 과목명를 출력
		int equalCount = 0;
		String equalSubject = "";
		
		for(int i =0;i<term1.length;i++) {
			if(term1[i] == term2[i]) {
				equalCount++;
				equalSubject += subject[i] + ", ";
			}
		}
		System.out.println("동일한 과목수 : " + equalCount);
		System.out.println("동일한 과목명 : " + equalSubject);
		
	}
	
	public void solution2() {
		System.out.println("---토익 문제 채점----------");
		System.out.println("번호:\t답안\t내답");
		System.out.println("-----------------------");
		
		int[] answer = new int[990];
		int[] myAnswer = new int[990];
		int count = 0;
		Random ran = new Random();
		
		for(int i=0;i<990;i++) {
			answer[i] = ran.nextInt(4) + 1;
			myAnswer[i] = ran.nextInt(4) + 1;
			System.out.println((i+1) + ":\t" + answer[i] + "\t" + myAnswer[i]);
			if(answer[i] == myAnswer[i]) {
				count++;
			}
		}
		System.out.println("내 점수: " + count + "점");
	}
	
	public void solution3() {
		System.out.println("---토익 문제 채점----------");
		System.out.println("번호:\t답안\t내답");
		System.out.println("-----------------------");
		
		int answer[][] = new int[990][2];
		int score = 0;
		Random ran = new Random();
		
		for(int i=0;i<answer.length;i++) {
			answer[i][0] = ran.nextInt(4) + 1;
			answer[i][1] = ran.nextInt(4) + 1;
			if(answer[i][0] == answer[i][1]) {
				score++;
			}
			System.out.printf(" %3d\t%d\t%d\n",i+1,answer[i][0], answer[i][1]);
		}
		System.out.printf("내 토익 점수:%3d점\n ",score);
	}
	
	public static void main(String[] args) {
		//solution1() 호출
		ArrayTest6.solution1();
		//solution2() 호출
		ArrayTest6 arr = new ArrayTest6();
		arr.solution2();
		
	}

}
