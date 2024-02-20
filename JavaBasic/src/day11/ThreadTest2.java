package day11;

public class ThreadTest2 {

	public static void main(String[] args) {
		//시계를 동작 시켜보세요
		ClockRunnable2 cr=new ClockRunnable2();
		//=> run()코드를 가짐
		
		Thread tr=new Thread(cr);
		//Thread와 Runnable객체를 결합
		tr.start();
	}

}
