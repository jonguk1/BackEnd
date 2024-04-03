package day03;
import java.util.*;
public class QueueTest {

	public static void main(String[] args) {
		
		Queue<String> q = new LinkedList<>();
		q.add("Hello");//추가 
		q.offer("Bye");//추가
		System.out.println(q);
		System.out.println("q.peek(): " + q.peek());
		System.out.println("q.element(): " + q.element());
		
		q.remove();//맨 앞 요소부터 삭제
		System.out.println("q.peek(): " + q.peek());
		q.poll();//삭제
		System.out.println("q.peek(): " + q.peek());
		
		System.out.println("q.isEmpty(): " + q.isEmpty());
		
		q.offer("Hi");
		q.offer("안녕");
		q.offer("반가워요");
		
		System.out.println(((LinkedList<String>)q).get(0));
		System.out.println("------------------------");
		//for루프 이용해서 한꺼번에 q에 저장된 값 출력
		for(String str:q) {
			System.out.println(str);
		}
		System.out.println("------------------------");
		// iterator() 메서드 이용해서 한꺼번에 q에 저장된 값 출력
		Iterator<String> it=q.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}

	}

}
