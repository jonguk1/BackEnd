package day06;
//Encapsulation: data를 외부에서 함부로 접근하지 못하게 보호하는 것
/* 접근지정자(제한자) -access modifier
* [1] public : 어디서든 접근 가능
* [2] protected : 같은 패키지안이면 접근 가능 + 같은 패키지가 아닐지라도 부모,자식의 상속 관계면 접근 가능
* [3] 생략형-default: 같은 패키지 안에서만 접근 가능
* [4] private: 외부 클래스에서는 접근 불가. 내부용으로 사용된다
* 
* 접근 범위
* public > protected > 생략형 > private
* 
* 캡슐화
* - 멤버변수 앞에 private 을 붙여준다 ==> 자판기 안에 재료 넣음
* - setter/ getter 메서드를 구성해서 private변수에 접근할 수 있도록 한다
* 
* public void setXXX(매개변수) {
* 		멤버변수=매개변수;
* }
* 
* public 반환타입 getXXX(){
*     return 멤버변수
* }
* */
public class CoffeeMachine {
	
	private int coffee;
	private short sugar;
	private float cream;
	
	//setter
	public void setCoffee(int cf) {
		coffee=cf;
	}
	//getter
	public int getCoffee() {
		return coffee;
	}
	//setter
	public void setSugar(short sg) {
		sugar=sg;
	}
	//getter
	public short getSugar() {
		return sugar;
	}
	//setter
	public void setCream(float cr) {
		cream=cr;
	}
	//getter
	public float getCream() {
		return cream;
	}

}
