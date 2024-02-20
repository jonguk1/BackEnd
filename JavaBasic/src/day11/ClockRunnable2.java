package day11;
import java.util.*;
public class ClockRunnable2 implements Runnable{

	@Override
	public void run() {
		while(true) {
			Calendar cal=Calendar.getInstance();
					//new Calendar();[x] 추상클래스
			int am_pm=cal.get(Calendar.AM_PM);
			String str=(am_pm==Calendar.AM)?"AM ":"PM ";
			
			
			int hh=cal.get(Calendar.HOUR_OF_DAY);//24시간을 기준으로 한 시간
			int mm=cal.get(Calendar.MINUTE);//분
			int ss=cal.get(Calendar.SECOND);//초
			str+=hh+":";
			str+=(mm<10)?"0"+mm+":": mm+":";
			str+=(ss<10)?"0"+ss: ss;
			System.out.println(str);
			
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}//while-----
	}//run()----------
}
