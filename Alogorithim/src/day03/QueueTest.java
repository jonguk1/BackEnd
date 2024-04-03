package day03;
import java.util.*;
public class QueueTest {

	public static void main(String[] args) {
		
		Queue<String> q = new LinkedList<>();
		q.add("Hello");//�߰� 
		q.offer("Bye");//�߰�
		System.out.println(q);
		System.out.println("q.peek(): " + q.peek());
		System.out.println("q.element(): " + q.element());
		
		q.remove();//�� �� ��Һ��� ����
		System.out.println("q.peek(): " + q.peek());
		q.poll();//����
		System.out.println("q.peek(): " + q.peek());
		
		System.out.println("q.isEmpty(): " + q.isEmpty());
		
		q.offer("Hi");
		q.offer("�ȳ�");
		q.offer("�ݰ�����");
		
		System.out.println(((LinkedList<String>)q).get(0));
		System.out.println("------------------------");
		//for���� �̿��ؼ� �Ѳ����� q�� ����� �� ���
		for(String str:q) {
			System.out.println(str);
		}
		System.out.println("------------------------");
		// iterator() �޼��� �̿��ؼ� �Ѳ����� q�� ����� �� ���
		Iterator<String> it=q.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}

	}

}
