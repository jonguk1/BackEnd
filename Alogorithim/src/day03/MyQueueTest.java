package day03;

public class MyQueueTest {

	public static void main(String[] args) {
		MyQueue q= new MyQueue(5);
		q.enque("Tiger");//rear ++ rear:1
		q.enque("Dog");//rear:2
		q.enque("Cat");//rear:3
		System.out.println(q.peek());//Tiger
		System.out.println("q.size(): " + q.size());
		q.enque("Duck");
		q.enque("Lion");
		System.out.println("q.size(): " + q.size());
		//q.enque("");
		
		q.printQueue();
		System.out.println("q.deque(): " + q.deque());//front: 1, cnt: 4
		System.out.println("q.size(): " + q.size());
		System.out.println("----------------------------");
		q.printQueue();
		System.out.println(q.deque());
		System.out.println("----------------------------");
		q.printQueue();
		q.enque("Elephant");
		System.out.println("----------------------------");
		q.printQueue();
		
		int idx=q.indexOf("Lion");
		System.out.println("idx: " + idx);
		
		idx=q.indexOf("Elephant");
		System.out.println("idx: " + idx);
		Member m1 = new Member("±èÃ¶¼ö", 20, 175);
		q.enque(m1);
		
		System.out.println("q.peek(): " + q.peek());
		System.out.println("q.size(): " + q.size());
		q.deque();
		q.deque();
		q.deque();
		q.deque();
		System.out.println("q.peek(): " + q.peek());
		System.out.println("q.size(): " + q.size());
		
		}

}
