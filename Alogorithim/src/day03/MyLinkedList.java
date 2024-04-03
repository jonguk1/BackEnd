package day03;
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
	
}
