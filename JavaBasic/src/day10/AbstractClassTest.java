package day10;
import java.util.*;

public class AbstractClassTest {

	public static void main(String[] args) {
		System.out.println("여러 도형의 면적을 구해봅시다~~~");
		System.out.printf("가로: %d, 세로 : %d인 도형 면적---\n",12,10);
		//사각형 객체 생성해서 area()
		Rectangle rt = new Rectangle();
		rt.area(10, 20);
		
		//직삼각형 area()
		Triangle tr = new Triangle();
		tr.area(20, 30);
		
		//원 area()
		//Circle cr = new Circle() [x]
		//추상 클래스는 타입 선언은 할 수 있으나 객체 생성은 할 수 없다
		Circle cr = new SubCircle();//[0]
		SubCircle cr2 = new SubCircle();//[0]
		//cr.area(20);[x]
		((SubCircle)cr).area(20);
		cr2.area(10);
		
		//Shape sp = new Shape();[x]
		Shape sp = new Rectangle();
		sp.area(8, 10);
		
		
		//rt, tr, cr, cr2, sp 를 저장할 배열을 생성하고
		//저장한 후 반복문 돌려서 각 도형의 면적을 출력하기
		//가로:20, 세로 : 30
		//반지름: 20
		Shape[] shapes = {rt, tr, cr, cr2, sp};
		
		for(Shape obj:shapes) {
			System.out.println("-----------");
			if(obj instanceof Circle) {
				((SubCircle)cr).area(20);
				continue;
			}
			obj.area(20, 30);
		}
		
		//ArrayList에 저항
		List<Shape> list = new ArrayList<>();
		list.add(rt);
		list.add(tr);
		list.add(cr);
		
	}

}
