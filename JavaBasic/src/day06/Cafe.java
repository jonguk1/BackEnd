package day06;

public class Cafe {
	
	public static void main(String[] args) {
		CoffeeMachine cm = new CoffeeMachine();
		cm.setCoffee(1);
		cm.setSugar((short)2);
		cm.setCream(3.5f);
		
		//각각 출력해보세요
		int coffee = cm.getCoffee();
		short sugar = cm.getSugar();
		float cream = cm.getCream();
		System.out.println("cm.coffee: " + coffee);
		System.out.println("cm.sugar: " + sugar);
		System.out.println("cm.cream: " + cream);
	}
}
