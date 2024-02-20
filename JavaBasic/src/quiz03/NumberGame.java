package quiz03;
import java.util.*;
//컴퓨터는 1<=num < 101사이의 임의의 정수를 랜덤하게 발생시킨다
//컴퓨터가 발생시킨 값을 맞추는 게임
//총 시도 횟수 7회 제한
//quiz03_홓길동.zip으로 제출
public class NumberGame {
	
	public static void startGame() {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		
		int com = ran.nextInt(101) + 1;
		int count =0;
		
		System.out.println(":컴퓨터가 낸 숫자를 맞춰보세요:");
		System.out.println(com);
		
		for(int i= 0; i < 7;i++) {
			int me = sc.nextInt();
			count++;
			if(com > me) {
				System.out.println("더 큰수를 입력하세요");
			}else if(com<me) {
				System.out.println("더 작은수를 입력하세요");
			}else {
				break;
			}
		}
		
		if(count ==7) {
			System.out.println("실패하셧습니다");
		}else {
			System.out.println(count + "번 만에 맞췃네요^^");
		    System.out.println("컴퓨터 숫자: " + com);
		}
	}

	public static void main(String[] args) {
		NumberGame.startGame();
	}

}
