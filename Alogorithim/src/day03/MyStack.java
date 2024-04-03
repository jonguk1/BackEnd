package day03;

public class MyStack<T> {
	
	private Node<T> top =null;
	
	class Node<T>{
		private T data;//������
		private Node<T> next=null;
		
		public Node(T data) {
			this.data=data;
		}
		
	}
	
	public void push(T item) {
		Node<T> newNode = new Node(item);//���� ���� ���
		newNode.next=top;//����⿡ �ִ� ���� ����� �ּҰ��� ���� ���� newNode�� next�� �Ҵ�����
		top=newNode;
	}
	
	public T peek() {
		if(top==null) throw new RuntimeException("EmptyException");
		return top.data;
	}
	
	public T pop() {
		if(top==null) throw new RuntimeException("EmptyException");
		
		T delData=top.data;
		top=top.next;//top.next�� ���� ����� �ּҰ��� ������ �ִ�. ���� ����� �ּҰ����� top�� �ּҰ��� ����
		return delData;
	}
	
	public boolean isEmpty() {
		return top==null;
	}

}
