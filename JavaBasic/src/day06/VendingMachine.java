package day06;
/*다형성 (Polymorphism)
 * - 오버로딩(Overloading)
 * 		<1> 메서드 오버로딩
 * 		<2> 생성자 오버로딩
 * - 동일한 메서드 이름으로 여러 개 구성하는 것
 *   단, 매개변수의 자료형, 개수, 순서가 다르게 구성해야 한다
 * [규칙]
 * 	<1> 메서드 이름은 동일하게
 *  <2> 매개변수의 자료형, 개수, 순서가 다르게 구성해야 한다
 *  <3> 반환타입은 신경쓰지 않는다 (같아도 되고 달라도 된다)
 * 
 * - 오버라이딩(Overriding) 
 *   상속 개념과 맞물려 사용함
 * */
public class VendingMachine {
	int coffee;
	int sugar;
	int cream;
	
	public void makeTea(int coffee, int sugar, int cream) {//매게변수(지역변수)
		//매개변수(지역변수)와 멤버변수의 이름이 동일한 경우
		//지역변수가 우선순위가 높다.
		//멤버변수를 구별하기 위해 멤버변수 앞에 this.멤버변수 형식으로 사용
		this.coffee=coffee;
		this.sugar = sugar;
		this.cream =cream;
		System.out.println("밀크커피 나가요~~~~~ 농도: " + (this.coffee + this.sugar + this.cream));
	}
	
	public void makeTea(int cf,int sg) {
		coffee = cf;
		this.sugar =sg;
		System.out.println("설탕커피 나가요 ~~~ 농도 : " + (coffee+sugar) );
	}
	
	//black coffee
	public String makeTea(int cf) {
		coffee = cf;
		return "블랙커피 나가요~~ 농도 : " + coffee;
	}
	//cream coffee 크림커피
	public void makeTea(int coffee,short cream) {
		this.coffee= coffee;
		this.cream =cream;
		System.out.println("크림커피 나가요 ~~~ 농도: " + (this.coffee + this.cream));
	}
	
	public void makeTea(short cream, int coffee) {
		this.makeTea(coffee,cream);
	}
	
	//유자차
	public void makeTea(Yuja y) {
		System.out.println("유자 농도: " + y.getYuja());
		System.out.println("설탕 농도: " + y.getSugar());
		System.out.println("유자차 나가요 ~~~ 농도 : "  + (y.getYuja() + y.getSugar()));
		
	}

}
