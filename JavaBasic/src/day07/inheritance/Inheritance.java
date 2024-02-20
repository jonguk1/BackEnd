package day07.inheritance;

public class Inheritance {

	public static void main(String[] args) {
		Human h = new Human();
		h.name="홍길동";
		h.height=180;
		h.showInfo();
		
	    System.out.println("--------------------");
		Superman s = new Superman();
	    s.showInfo(); 
	    
	    Superman s2= new Superman("초능력자",188,300);
	    s2.showInfo();
	    System.out.println("--------------------");
	    Aquaman a= new Aquaman("아쿠아맨",179,1232.12);
	    a.showInfo();
	    
	    s.showInfo("###슈퍼맨 정부####");
	    
	    s2.showInfo("@@@슈퍼맨 정보@@@@");
	    
	    String str = s2.showInfo("***울트라 슈퍼맨**", 500);
	    System.out.println(str);
	    
	    //상속관계를 맺으면
	    //부모타입의 변수선언 = new 자식객체(); 가능함
	    //이때 이 참조변수로 접근할 수 있는 변수나 메서드는 제한이 있다.
		//[1] 부모가 물려준 변수,메서드는 접근 가능
		//[2] 그러나 오버라이드한 메서드가 있을 경우에는 자식의 오버라이드한 메서드를 적용한다
		//[3] 자식만이 갖는 고유한 변수나 메서드는 접근 할 수 없다.
	    Human hs = new Superman("김초롱",175,850);//다형성(Polymorphism)
	    //Human hs =new String();//[x]
	    System.out.println("hs.name: " + hs.name);
	    System.out.println("hs.height: " + hs.height);
	    //System.out.println("hs.power: " + hs.power);//[x]
	    
	    //부모 > 자식
	    System.out.println( "((Superman)hs).power: " +((Superman)hs).power);
	    //강제형변환을 하여 접근해보자
	    hs.showInfo();
	    //오버라이딩한 메서드를 우선 적용함
	    //hs.showInfo("***슈퍼맨 정보****");//[x]overload
	    ((Superman)hs).showInfo("***슈퍼맨 정보****");
	    
	    //Human타입의 변수 선언하고 Aquaman객체를 생성해서
	    //name,height,speed, showInfo()호출해보기
	    Human ha = new Aquaman("김똘똘", 165, 45);
	    System.out.println("ha.name: " +ha.name);
	    System.out.println("ha.height: " +ha.height);
	    System.out.println("ha.speed: " + ((Aquaman)ha).speed);
	    
	    ha.showInfo();
	    
	    // h, s,a, hs,ha 객체들을 저장할 배열을 생성하고 저장하세요
	 	// 그런뒤 반복문 이용해서 배열에 저장된 객체들의 showInfo()를 호출하세요
	    Human[] humanList = {h,s,a,hs,ha};
	    
	    for(int i =0;i<humanList.length;i++) {
	    	humanList[i].showInfo();
	    }
	    
	}

}
