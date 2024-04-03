package day03;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> sk = new Stack<>();
		sk.add("홍길동");
		sk.push("차승원");
		sk.push("유재석");
		System.out.println(sk.peek());
		
		System.out.println(sk.get(0));
		System.out.println(sk.get(1));
		sk.pop();
		System.out.println("sk.peek(): " + sk.peek());
		System.out.println("sk.size(): " + sk.size());
		System.out.println("----------------------");
		while(!sk.isEmpty()) {
			String item=sk.pop();
			System.out.println(item);
		}
		System.out.println("sk.size(): " + sk.size());
		
		sk.push("아이유");
		sk.push("블핑");
		System.out.println(sk);
		int idx=sk.indexOf("아이유");
		System.out.println("idx: " + idx);
		idx=sk.indexOf("르세라핌");
		System.out.println("idx: " + idx);
		System.out.println("sk.size1(): " + sk.size());
		sk.clear();
		System.out.println("sk.size2(): " + sk.size());
	}
	
}
