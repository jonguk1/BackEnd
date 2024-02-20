package day03;
import java.util.*;

public class RandomTest {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		//랜덤한 임의의 정수를 발생시켜보자 0<= r < 10
		for(;;) {
			System.out.println("종료할래요 [X]?");
			String input = sc.next();
			if(input.equals("X")) {
				break;//가장 가까운 반복문을 벗어난다
			}
			int r = ran.nextInt(10);
			System.out.println(r);
		}//for---
		System.out.println("Bye Bye~");
	}

}
