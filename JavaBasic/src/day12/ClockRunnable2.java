package day12;
import java.util.*;
public class ClockRunnable2 implements Runnable{

	MultiThreadGui remote;
	public ClockRunnable2(MultiThreadGui gui) {
		remote=gui;
	}
	
	@Override
	public void run() {
		while(true) {
			Calendar cal=Calendar.getInstance();
					//new Calendar();[x] 추상클래스
			
			String str ="";
			int yy = cal.get(Calendar.YEAR);
			str += yy+"-";
			
			int month = cal.get(Calendar.MONTH) +1;// JAN 0, ... DEC 11을 반환
			str +=(month <10)?"0"+month+"-":month+"-";
			
			int dd=cal.get(Calendar.DAY_OF_MONTH);
			str +=(dd <10)?"0"+dd+" ":dd+" ";
			
			int am_pm=cal.get(Calendar.AM_PM);
			str +=(am_pm==Calendar.AM)?"AM ":"PM ";
			
			int hh=cal.get(Calendar.HOUR_OF_DAY);//24시간을 기준으로 한 시간
			int mm=cal.get(Calendar.MINUTE);//분
			int ss=cal.get(Calendar.SECOND);//초
			str+=hh+":";
			str+=(mm<10)?"0"+mm+":": mm+":";
			str+=(ss<10)?"0"+ss: ss;
			//System.out.println(str);
			
			remote.lbClock.setText(str);
			
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}//while-----
	}//run()----------
}
