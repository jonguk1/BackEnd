package quiz02;
import java.util.*;

public class MyGame {

	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc =new Scanner(System.in);
		
		int win = 0;
		int count =0;
		
		for(;;) {
			System.out.println("me(0이면 가위, 1이면 바위, 2이면 보)>>");
			int me = sc.nextInt();
			int computer = rd.nextInt(3);
			
			System.out.println(computer + "\t" + me);
			//내가 가위일떄
			if(me  == 0) {
				//전체 횟수
				count++;
				//컴퓨터가 가위일때
				if(computer == 0) {
					System.out.println("무승부");
				//컴퓨터가 바위일때
				}else if(computer == 1) {
					System.out.println("컴퓨터승");
				//컴퓨터가 보일때	
				}else {
				//내가 이긴 횟수
					win++;
					System.out.println("내가승");
				}
			}
			//내가 가위일때
			if(me  == 1) {
		        //전체 횟수
				count++;
				//컴퓨터가 가위일때
				if(computer == 0) {
				//내가 이긴 횟수
					win++;
					System.out.println("내가승");
				//컴퓨터가 바위일때
				}else if(computer == 1) {
					System.out.println("무승부");
				//컴퓨터가 보일때
				}else {
					System.out.println("컴퓨터승");
				}
			}
			
			//내가 보일떄
			if(me  == 2) {
				//전체 횟수
				count++;
				//컴퓨터가 가위일때
				if(computer == 0) {
					System.out.println("컴퓨터승");
				//컴퓨터가 바위일때
				}else if(computer == 1) {
				//내가 이긴 횟수
					win++;
					System.out.println("내가승");
				//컴퓨터가 보일때
				}else {
					System.out.println("무승부");
				}
			}
			System.out.println("종료하실래요X>>");
			String input = sc.next();
			//종료할때
			if(input.equals("X")) {
				break;
			}
		}
		
		System.out.println("종료합니다.");
		System.out.println("전체 " + count + "중에 내가 승리한 수는 " + win);

	}

}
