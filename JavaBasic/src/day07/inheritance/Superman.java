package day07.inheritance;
//자식 클래스(Super class)
//Superman is a Human "is a" 관계 ===> 상속성
public class Superman extends Human{
	
	int power;
	public Superman() {
		this("아무개", 177,150);
	}
	
	public Superman(String name,int height,int power) {
		super.name=name;
		super.height =height;
		this.power = power;
	}
	//부모로부터 상속받은 메서드를 다시 재정의해보자
	//==>Overriding(재정의)
	/*오버라이딩 조건
	 * 1. 부모와 메서드 이름을 동일하게 구성
	 * 2. 매개변수도 동일하게
	 * 3. 반환타입도 동일하게
	 * 4. 접근 지정자는 부모와 동일하거나 더 넓은 범위를 지정
	 * */
	//annotation
	@Override
	public void showInfo() {
		super.showInfo();//이름, 키 출력
		System.out.println("초능력: " + power);
	}
	
	//Overload
	public void showInfo(String title) {
		System.out.println(title);
		//이름,키,초능력
		this.showInfo();
	}
	
	public String showInfo(String title, int up){
		this.showInfo(title);
		power+=up;
		return ">>초능력을 충전했어요: 현재 초능력은" + power + "입니다<<";
	}
	
	
}///////////
