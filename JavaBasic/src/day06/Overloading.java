package day06;

public class Overloading {

	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		vm.makeTea(1, 2, 3);
		System.out.println("vm.coffee: " + vm.coffee);
		System.out.println("vm.sugar: " + vm.sugar);
		System.out.println("vm.cream: " + vm.cream);
		
		//1.설탕 커피 만들기
		vm.makeTea(1, 1);
		
		//2.블랙 커피 만들기
		String str = vm.makeTea(3);
		System.out.println(str);
		
		//3. 크림 커피 만들기
		vm.makeTea((short)1, 1);
		
		//4.유자차 만들기
		Yuja tea = new Yuja();
		tea.setYuja(6);
		tea.setSugar(6);
		vm.makeTea(tea);
		
	}

}
