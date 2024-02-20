package day06;
//1개의 파일에 여러 클래스를 구성할 수 있다.
//이때 public 속성은 한 클래스만 가져야 함
class Car{
	//variable,field,property
	//맴버변수(1. 클래스(static) 변수, 2. 인스턴스(non-static) 변수)
	String color;//인스턴스 변수
	static int capa;//클래스 변수
	
	//맴버 메서드(1. 클래스 메서드(static), 2.인스턴스 메서드(non-static))
	public void run(int km) {
		System.out.println(color + "색 자동차가 시속" + km + "km로 달려요~~");
	}
	
	public static String info() {
		String str = "-----자동차 정보-------\n";
		str += "용량: " + capa + "cc\n";
		//str += "색상: " + color + "색\n";[x]
		return str;
	}
}///////
class Tv{
	
}///////



public class MyDemo {
	
	String str = "나는 인스턴스 변수";
	static String str2 = "나는 클래스 변수";

	public static void main(String[] args) {
		System.out.println(MyDemo.str2);//선발대
		System.out.println(str2);//선발대
		//System.out.println(str);//후발대
		MyDemo md = new MyDemo();//후발대
		
		
		//Car클래스의 color 변수값을 출력
		Car car = new Car();
		System.out.println("Car.color: "+ car.color);
		System.out.println("Car.capa: " + Car.capa);
		
		car.color="red";
		Car.capa=2000;
		
		//Car클래스의 capa값 출력
		System.out.println("Car.color: "+ car.color);
		System.out.println("Car.capa: " + Car.capa);
		//run()호출하기
		car.run(100);
		
		//Car의 info()호춣하기 => static 메서드
		System.out.println(Car.info());
		
		Car car2 = new Car();
		car2.color= "black";
		Car.capa=3000;
		car2.run(130);
		System.out.println(Car.info());
		
		System.out.println("car.capa: " + car.capa);
		System.out.println("car2.capa: " + car2.capa);
		
	}

}
