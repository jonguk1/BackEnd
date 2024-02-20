package day07.inheritance;
//Human상속받고, speed추가, showInfo()오버라이딩 하기
public class Aquaman extends Human{
	
	double speed;
	
	public Aquaman(){
		this("홍길동", 170, 130);
	}
	
	public Aquaman(String name, int height, double speed) {
		super.name = name;
		super.height =height;
		this.speed = speed;
	}
	//annotation
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("스피도: " + speed);
	}
	
	
	
	
}
