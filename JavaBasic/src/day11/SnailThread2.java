package day11;
//100부터 시작해서 1씩 감소하는 달팽이 스레드로 구현해보기
public class SnailThread2 extends Thread{
	
	public SnailThread2(String name) {
		this.setName(name);
	}
	
	public void run(){
		for(int x=100;x>=0;x--) {
			System.out.println(getName()+"가 뒤로 기어감: "+x);
//			try {
//				Thread.sleep(20);//0.02초 sleep
//			}catch(Exception e) {
//				System.out.println(e.getMessage());
//			}
		}//for
	}//run()
	

}
