package day11;
//TimerTask클래스를 사용해보자. java.lang.Runnable의 자식 클래스
import java.util.*;
class MyTask extends TimerTask
{
	@Override
	public void run() {
		//특정 시간 이후에 실행할 일을 run에서 구현
		System.out.println(">>게임이 종료되었습니다<<<");
	}
	
}///////////////////////

public class TimerTest {

	public static void main(String[] args) {
		Timer timer=new Timer();
		System.out.println("현재 게임이 진행되고 있어요...5초 뒤에는 게임이 종료됩니다");

		MyTask task=new MyTask();
		//timer.schedule(task,5000); 
		//5초 뒤에 task의 run()을 수행한다
		//JS window.setTimeout(함수,밀리초) 와 동일
		
		timer.scheduleAtFixedRate(task, 5000, 10000);
		//JS window.setInterval(함수,밀리초)와 동일
		//5초 뒤에 task를 수행하고, 10초 단위로 계속 실행
	}

}
