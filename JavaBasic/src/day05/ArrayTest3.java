package day05;

import java.util.*;

public class ArrayTest3 {
	
	public void getScores() {
		System.out.println("---수능 점수 구하기----------");
		
		Random rd = new Random(50);
		int score[] = new int[10000]; 
		int count = 0;
		int zeroCount = 0;
		int sum = 0;
		int avg_50 = 0; 
		
		for(int i =0; i <score.length;i++) {
			score[i] = rd.nextInt(451);
		}

		for(int i =0; i <score.length;i++) {
			if(score[i] == 450) {
				count++;
			}else if(score[i] == 0) {
				zeroCount++;
			}
			sum += score[i]; 
		}
		
		float avg = (float)sum/score.length;
		
		for(int i =0; i <score.length;i++) {
			if(score[i] >=avg-50 && score[i] <=avg+50) {
				avg_50++;
			}
		}

		System.out.println("만점자는 " + count + "명입니다");
		System.out.println("0점은 " + zeroCount + "명입니다");
		System.out.println("평균은 " + avg + "점입니다");
		System.out.println("평균보다 +-50점인 학생은 " + avg_50 + "명입니다");
	}
	
	public static void main(String[] args) {
		//getScores()호출하기
		ArrayTest3 arr = new ArrayTest3();
		arr.getScores();

	}

}
