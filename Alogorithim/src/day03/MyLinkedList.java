package day03;

import java.util.Comparator;

//���ʸ� ��ũ�帮��Ʈ
/*head --->[A:next]--->[B:next]--->[C:next]-->[D:next]-->null
* 
* [1] ��尡 1�� �ִ��� �Ǻ���?: head --->[A:next]-->null
* 		  (head.next==null)?
* [2] ��尡 2�� �ִ��� �Ǻ���?: head --->[A:next]--->[B:next]--->null
* 		  (head.next.next==null)?
* [3] ������ ��尡 ����������� �Ǻ���?
*        (�����ѳ��.next==null)?
* */
public class MyLinkedList<T> {
	Node<T> head=null;//�Ӹ� ��带 ����
	Node<T> currentN=null;//���� �ٶ󺸰� �ִ� ���
	
	class Node<T>{
		T data;//������
		Node<T> next;//���� ����� �ּҰ��� ����
		public Node(T data,Node<T> next) {
			this.data=data;
			this.next=next;
		}
	}
	
	//��带 �� �տ� �����ϴ� �޼���
	public void addFirst(T newData) {
		Node<T> tmp=head;//�� ó�� ��� �ּҰ��� �ӽú����� ����
		Node<T> newNode=new Node(newData,tmp);
		head = currentN = newNode;
	}
	
	//��带 �� �ڿ� �����̴� �޼���
	public void addLast(T newData) {
		if(head==null) {//���� �ƹ� ������ ��尡 ���ٸ�
			addFirst(newData);
		}else {
			Node<T> end=new Node(newData,null);
			
			//������ ��带 ã�������� �˻�����. ��? �� �ڿ� �پ�� �ϹǷ�
			Node<T> ptr=head;
			while(ptr.next!=null) {
				ptr=ptr.next;//������ �̵�
			}
			//ptr.next�� null�ϰ��(��������� ���)
			ptr.next=currentN=end;	
		}
	}
	
	//�Ӹ� ��带 �����ϴ� �޼���
	public void removeFirst() {
		if(head !=null) {
			head = currentN= head.next;
		}
	}
	
	//���� ��带 �����ϴ� �޼���
	public void removeLast() {
		if(head!=null) return;
		//��尡 �ϳ��� �ִٸ�
		if(head.next==null) {
			removeFirst();
		}else {//��尡 ������ �ִ� ���
			Node<T> ptr=head;
			while(ptr.next.next!=null) {//������ ��� 2���� ���������� ������ ��� �̵�(Ž��)
				ptr=ptr.next;//Ž��
			}
			//[2] ��尡 2�� �ִ��� �Ǻ���?: ptr --->[A:next]--->[B.next]--->null
			ptr.next=null;
			currentN=ptr;
			
		}
		
	}
	
	//Ư�� ��带 �����ϴ� �޼���
	private void remove(Node<T> p) {
		if(head==null) return;
		if(p==head) {
			removeFirst();
		}else {
			Node<T> ptr=head;
			while(ptr.next != p) {
				ptr=ptr.next;
				if(ptr.next==null) return;//���� ������ �̵��ߴµ� ��ã�ҵ��� ����
			}
			ptr.next=p.next;
		}
	}
	//������ ��带 �����ϴ� �޼���
	public void removeCurrentNode() {
		remove(currentN);
	}
	//��ü ��带 �����ϴ� �޼���
	public void clear() {
		while(head!=null) {
			removeFirst();
		}
		currentN=null;
	}
	
	//������ ��带 ����ϴ� �޼���
	public void printCurrentNode() {
		System.out.println("----------------");
		if(currentN==null) {
			System.out.println("������ ��尡 �����ϴ�");
		}else {
			System.out.println("������ ��� ->" + currentN.data);
		}
	}
	
	
	//��ü ��带 ����ϴ� �޼���
	public void printAllNode() {
		System.out.println("****************");
		Node<T> ptr= head;
		while(ptr!=null && ptr.next!=null) {
			System.out.print(ptr.data+"->");//�����Ͱ� �����
			ptr=ptr.next;
		}
		
		if(ptr!=null) {
			System.out.println(ptr.data);
		}
	}
	
	//������ ��带 ��ĭ �ڷ� �̵���Ű�� �޼���
	public boolean next() {
		if(currentN==null||currentN.next==null) {
			return false;
		}
		currentN=currentN.next;
		return true;
	}
	
	public T search(T obj,Comparator<T> comparator) {
		Node<T> ptr=head;
		while(ptr!=null) {
			if(comparator.compare(obj, ptr.data)==0) {
				currentN=ptr;
				return ptr.data;
			}
			ptr=ptr.next;
		}
		return null;
	}
	
	
}
