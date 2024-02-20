package day11;

interface Animal{
	void getBaby(int num);
	String crySound();
}//////////////////////
class Dog extends Object implements Animal
{
	public void getBaby(int n) {
		System.out.println(n+"마리의 새끼를 낳았어요~");
	}
	public String crySound() {
		return "멍멍~~";
	}
}/////////////////////////
class Cat implements Animal
{
	public void getBaby(int n) {
		System.out.println(n+"마리의 새끼를 낳았어요~");
	}
	public String crySound() {
		return "야옹 야옹~~";
	}
}//////////////////////////
class Duck implements Animal
{
	@Override
	public void getBaby(int n) {
		System.out.println(n+"개의 알 낳았어요~");
	}
	@Override
	public String crySound() {
		return "꽥 꽥~~";
	}
}/////////////////////////
public class AnimalTest {
	//args: 명령줄 인수
	//src>javac -encoding utf-8 -d ../bin day11\AnimalTest.java
	//bin>java day11.AnimalTest 강아지 10
	//java 패키지명.클래스명 명령줄인수1 명령줄인수2 ...
	//args[0]=강아지  args[1]=10
	public static void main(String[] args) {
		if(args.length!=2) {
			System.out.println("명령줄 인수 2개를 입력해야 해요 (ex 강아지 3)");
			return;
		}
		System.out.println("args[0]="+args[0]);
		System.out.println("args[1]="+args[1]);
		Animal a=null;
		if(args[0].equals("강아지")) {
			a=new Dog();
		}else if(args[0].equals("고양이")) {
			a=new Cat();
		}else if(args[0].equals("오리")) {
			a=new Duck();
		}else {
			System.out.println("그런 동물은 안키워요!!");
			return;
		}
		String str=a.crySound();
		System.out.println(str);
		int num=Integer.parseInt(args[1]);
		a.getBaby(num);
	}

}





