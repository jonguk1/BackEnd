package day11;

/*스레드를 구현하는 방법
 * [1] java.lang.Thread클래스를 상속받아 구현
 * [2] java.lang.Runnable인터페이스를 상속받아 구현
 * 
 *    반드시 구현해야 하는 메서드
 *    public void run() : 스레드가 할일을 여기에 구현한다
 * 
 * */
public class SnailThread1 extends Thread {

	public SnailThread1(String name) {
		this.setName(name);// 스레드 이름 설정
	}

	@Override
	public void run() {
		// 스레드가 할일을 구현
		for (int x = 0; x <= 100; x++) {
			System.out.println(getName() + "가 앞으로 기어감: " + x);

//			try {
//				// sleep()호출
//				Thread.sleep(10);// 0.01초 동안 block상태가 된다
//			} catch (InterruptedException e) {
//				System.out.println("예외: "+e.getMessage());
//			}

		}
	}

}
