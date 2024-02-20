package day04;
import java.util.*;
public class AnotherGame {

	//method 구성
	public static void menu() {
		System.out.println("********MyGame v1.1**********");
		System.out.println(" 1. 가위 2. 바위 3. 보 9. 종료");
		System.out.println("*****************************");
		System.out.println("입력하세요 =>");
		System.out.println("*****************************");		
	}//---------------------------
	public static void startGame() {
		Random ran=new Random();
		Scanner sc=new Scanner(System.in);
		int win=0;//내가 이긴 횟수
		int count=0;//게임 시도 횟수
		for(;;) {
			MyGame.menu();
			int me=sc.nextInt();
			int com=ran.nextInt(3)+1;//1<= com <4      nextInt(범위) + 시작수
			//System.out.println("me: "+me+", com: "+com);
			count++;
			if(me==9) {
				//break;//가장 가까운 반복문을 벗어난다
				System.out.println("Bye Bye~~");
				System.exit(0);//시스템 종료
			}
			//유효성 체크
			if(me<1||me>3) {
				System.out.println("메뉴에 없는 번호입니다!! 다시 입력하세요=>");
				//return;//return문을 가진 메서드를 호출한 쪽으로 돌아간다
				continue;//아래 실행문을 skip하고 반복문을 계속 수행한다
			}
			
			//System.out.println("게임 진행...");
			String msg="";
			if(me==com) {
				msg="비겼네요~";
			}else if ((me==1&&com==3)|| (me==2 &&com==1)|| (me==3&&com==2)) {//내가 이긴 경우
				msg="당신이 이겼네요^^";
				win++;
			}else {//컴퓨터가 이긴 경우
				msg="당신이 졌어요 ㅠㅠ";
			}
			//show()호출해보기
			String result1=MyGame.show(me);
			
			System.out.println("당 신: "+result1);
			System.out.println("컴퓨터: "+MyGame.show(com));
			System.out.println(msg); 
			System.out.println("전체 시도 횟수: "+count+", 당신이 승리한 횟수: "+win);
			
		}//for-----
	}//---------------------------------
	
	static public String show(int num) {
		String str="";
		switch(num) {
		case 1: str="가위 [☞]";			
			break;
		case 2: str="바위 [●]";
			break;
		case 3: str="보 [▥]";
			break;
		}//switch----
		return str;
	}//------------------------------------

	public static void main(String[] args) {
		//startGame() 호출해보기
		MyGame.startGame();
	}//main()----------------------

}
