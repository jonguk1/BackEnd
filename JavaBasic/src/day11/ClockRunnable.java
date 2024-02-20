package day11;
//[2] java.lang.Runnable 인터페이스를 상속받아 구현
// -  run()추상메서드를 오버라이드 하여 스레드가 할 일을 구현한다
// - 스레드를 동작시킬때는
//	<1> Runnable객체를 먼저 생성
//  <2> Thread객체를 생성하되, 생성자 매개변수로 <1>번 Runnable객체를 전달
//  <3> Thread객체의 start()호출한다
import java.util.*;
public class ClockRunnable implements Runnable {
	
	public void run() {
		while(true) {
			Date now=new Date();
			System.out.println(now);
			
			try {
				Thread.sleep(1000);//1초 동안 sleep
			} catch (InterruptedException e) {
				//e.printStackTrace();
				System.out.println("예외: "+e.getMessage());
			}
			
		}//while----
	}//run()------------

}
