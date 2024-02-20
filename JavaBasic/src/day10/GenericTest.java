package day10;

import java.awt.Color;

class Car{
	String color;
	int capa;
	
	@Override
	public String toString() {
		return "Car [color=" + color + ", capa=" + capa + "]";
	}
	
}/////////

class Truck<T1, T2, T3>
{
	T1 weight;
	T2 distance;
	T3 color;
	@Override
	public String toString() {
		return "Truck [weight=" + weight + ", distance=" + distance + ", color=" + color + "]";
	}
	
}//////////////

public class GenericTest {

	public static void main(String[] args) {
		Car c1 = new Car();
		c1.color="white";
		c1.capa=2000;
		System.out.println(c1);
		
		Truck t1 = new Truck();
		System.out.println(t1);
		
		Truck<Double, Integer, String> t2 = new Truck<>();
		t2.weight=2.5;
		t2.distance=5000;
		t2.color="gray";
		System.out.println(t2);
		
		Truck<String, Float, Color> t3= new Truck<>();
		t3.weight ="매우 무거움";
		t3.distance=450.3f;
		t3.color=Color.magenta;
		System.out.println(t3);
		
	}

}
