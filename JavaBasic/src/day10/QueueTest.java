package day10;
import java.util.*;
/*
 * Queue
 *  - List계열
 *  - 구현한 클래스 LinkedList, PriorityQueue
 *  - FIFO구조 (First In First Out) *  
 * */
public class QueueTest {

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		q.add("어제 들어온 우유");
		q.add("오늘 들어온 우유");
		q.add("내일 들어온 우유");
		
		System.out.println(q);
		String str = q.poll();//큐의 앞에 있는 요소를 꺼내 삭제하고, 삭제한 요소를 반환한다
		System.out.println(str + "를 꺼냈어요");
		
		System.out.println(q);
		q.remove();//poll()과 동일
		
		System.out.println(q);
	}

}
