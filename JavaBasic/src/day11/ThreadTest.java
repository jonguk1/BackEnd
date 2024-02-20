package day11;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException{
		//스레드 2개 생성해서 동작시키자.
		//동작시킬떄는 run()이 아니라 start()호출해야 함
		SnailThread1 tr1=new SnailThread1("똘똘이 달팽이");
		SnailThread2 tr2=new SnailThread2("거꾸로 달팽이");
		
		tr1.setPriority(10);//높은 우선순위
		tr2.setPriority(3);//낮은 우선순위
		//tr1.run();//[x]
		tr1.start();
		tr2.start();
		
		tr1.join();
		//tr1이 작업을 마칠때까지 join()호출한 스레드는 block상태가 된다
		
		System.out.println("Hello World~");
		//현재 실행 중인 스레드 알아보자
		Thread tr3=Thread.currentThread();
		System.out.println(tr3.getName()+"스레드가 실행중...");
		
		
		
	}

}
