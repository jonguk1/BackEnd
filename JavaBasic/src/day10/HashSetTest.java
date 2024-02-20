package day10;
import java.util.*;
/* Set계열의 특징
 * - 순서를 기억하지 않는다.
 * - 데이터 중복을 허용하지 않는다.
 * 구현클래스
 * - HashSet
 *: 해쉬셋은 객체를 저장하기 전에 객체의 hashCode()를 호출하여 해시코드를 얻어낸다.
 *     그리고 이미 저장되어 있는 객체들의 해시코드와 비교한다. 만약 동일한 해시코드가 
 *     있다면 그다음에는 equals()메소드로 두 객체를 비교해서 true가 나오면 동일한
 *     객체로 판단하고 중복 저장을 하지 않는다. 	
 * 
 * */
public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("Java");
		set.add("Servlet");
		set.add("JSP");
		set.add("Spring");
		System.out.println("set.size(): " + set.size());
		set.add("JSP");
		System.out.println("set.size() 2: " + set.size());
		
		//Iterator<E>	iterator() 이용해서 set에 저장된 요소를 모두 출력하세요
		/* # Iterator의 경우**************************************
		 * Iterator인터페이스는 객체들을 집합체로
		 * 관리하도록 해주는 인터페이스이다.
		 * 이들 인터페이스에서는 각각의 객체들을 한 순간에 하나씩
		 * 처리할 수 있는 메소드를 제공한다.
		 * 	- boolean hasNext(): 논리적 커서(첫번째 요소 직전에
		 * 				위치) 이후에 요소들이 있는지 물어서 있으면true
		 * 				없으면 false를 반환
		 *  - E next() : 논리적 커서를 다음 요소로 이동하고
		 *  			현재 가리키고 있는 요소를 반환한다.
		 * */
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
		
		for(String str:set) {
			System.out.println(str.toLowerCase());
		}
		
	}

}
