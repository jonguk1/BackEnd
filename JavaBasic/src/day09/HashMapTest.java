package day09;
import java.util.*;
/*Map계열
 * Hashtable, HashMap, Properties
 * - Object유형을 저장할 수 있다
 * - key와 value값을 매핑하여 저장한다.
 * - key값의 중복을 허용하지 않는다.
 * - 무순서
 * - 데이터가 75%차면 자동으로 저장 역역을 확대한다.
 * - 데이터 저장: Object put(Object key, Object value)
 * - 데이터 꺼내기: Object get(Object key)
 * */
public class HashMapTest {

	public static void main(String[] args) {
		HashMap<Integer , String> map = new HashMap<>();
		//key: Integer, value: String
		map.put(1, "엄마");
		map.put(2, "아빠");
		map.put(3, new String("친구"));
		map.put(4, "동생");
		
	    System.out.println("단축키 2번은 누구? " + map.get(2));
	    System.out.println(map.get(55));//null
	    System.out.println("map.size(): "+map.size());
	    System.out.println(map);
	}

}
