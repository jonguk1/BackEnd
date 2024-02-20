package day09;
/*컬렉션: 
 * List, Set, Map,
 * - ArrayList
 *   - java.util.List계열
 *   - 입력순서를 기억한다
 *   - 데이터 중복을 허용한다.
 *   - 동적으로 저장크기를 늘릴 수 있다.
 *   - 참조형의 데이터를 저장함.
 *   - 다른 유형의 데이터도 저장 가능함
 * 
 * */
import java.util.*;
public class CollectionTest {

	public static void main(String[] args) {
		//List계열
		ArrayList arr = new ArrayList(5);//초기용량: 5개 저장
		arr.add("홍길동");//0
		arr.add("홍길동");//1
		arr.add(100);//int ==>java.lang.Integer객체로 저장된다. auto boxing
		arr.add(11.12);//double ==> java.lang.Double
		System.out.println("arr.size(): " + arr.size() + "개 저장함");
		arr.add('남');//Character객체
		arr.add(true);//Boolean객체
		System.out.println("arr.size(): " + arr.size() + "개 저장함");
		
		//for루프 이용해서 꺼내보기
		//Object get(int index);
		Object val =arr.get(0);
		System.out.println(val);
		System.out.println(((String)val).charAt(0));//성
		
		//index 2에 있는 객체를 꺼내보기
		Integer val2 = (Integer)arr.get(2);
		System.out.println(Integer.toBinaryString(val2));//2진수 문자열 반환
		System.out.println("***************************");
		HashSet set = new HashSet();//Set계열, 순서x,중복지정x
		
		//for
		for(int i=0;i<arr.size();i++) {
			Object obj = arr.get(i);
			System.out.println(obj);//순서대로 출력
			set.add(obj);//리스트에서 꺼낸 객체를 Set에 저장해본다
		}
		
		//Set계열과 비교해보자
		System.out.println("set: " + set);
	}

}
