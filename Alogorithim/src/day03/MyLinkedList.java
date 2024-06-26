package day03;

import java.util.Comparator;

//제너릭 링크드리스트
/*head --->[A:next]--->[B:next]--->[C:next]-->[D:next]-->null
* 
* [1] 노드가 1개 있는지 판별은?: head --->[A:next]-->null
* 		  (head.next==null)?
* [2] 노드가 2개 있는지 판별은?: head --->[A:next]--->[B:next]--->null
* 		  (head.next.next==null)?
* [3] 선택한 노드가 꼬리노드인지 판별은?
*        (선택한노드.next==null)?
* */
public class MyLinkedList<T> {
	Node<T> head=null;//머리 노드를 참조
	Node<T> currentN=null;//현재 바라보고 있는 노드
	
	class Node<T>{
		T data;//데이터
		Node<T> next;//뒤쪽 노드의 주소값을 참조
		public Node(T data,Node<T> next) {
			this.data=data;
			this.next=next;
		}
	}
	
	//노드를 맨 앞에 삽입하는 메서드
	public void addFirst(T newData) {
		Node<T> tmp=head;//맨 처음 노드 주소값을 임시변수에 저장
		Node<T> newNode=new Node(newData,tmp);
		head = currentN = newNode;
	}
	
	//노드를 맨 뒤에 덧붙이는 메서드
	public void addLast(T newData) {
		if(head==null) {//현재 아무 데이터 노드가 없다면
			addFirst(newData);
		}else {
			Node<T> end=new Node(newData,null);
			
			//마지막 노드를 찾을때까지 검색하자. 왜? 맨 뒤에 붙어야 하므로
			Node<T> ptr=head;
			while(ptr.next!=null) {
				ptr=ptr.next;//포인터 이동
			}
			//ptr.next가 null일경우(꼬리노드인 경우)
			ptr.next=currentN=end;	
		}
	}
	
	//머리 노드를 삭제하는 메서드
	public void removeFirst() {
		if(head !=null) {
			head = currentN= head.next;
		}
	}
	
	//꼬리 노드를 삭제하는 메서드
	public void removeLast() {
		if(head!=null) return;
		//노드가 하나만 있다면
		if(head.next==null) {
			removeFirst();
		}else {//노드가 여러개 있는 경우
			Node<T> ptr=head;
			while(ptr.next.next!=null) {//마지막 노드 2개가 남을때까지 포인터 계속 이동(탐색)
				ptr=ptr.next;//탐색
			}
			//[2] 노드가 2개 있는지 판별은?: ptr --->[A:next]--->[B.next]--->null
			ptr.next=null;
			currentN=ptr;
			
		}
		
	}
	
	//특정 노드를 삭제하는 메서드
	private void remove(Node<T> p) {
		if(head==null) return;
		if(p==head) {
			removeFirst();
		}else {
			Node<T> ptr=head;
			while(ptr.next != p) {
				ptr=ptr.next;
				if(ptr.next==null) return;//꼬리 노드까지 이동했는데 못찾았따면 리턴
			}
			ptr.next=p.next;
		}
	}
	//선택한 노드를 삭제하는 메서드
	public void removeCurrentNode() {
		remove(currentN);
	}
	//전체 노드를 삭제하는 메서드
	public void clear() {
		while(head!=null) {
			removeFirst();
		}
		currentN=null;
	}
	
	//선택한 노드를 출력하는 메서드
	public void printCurrentNode() {
		System.out.println("----------------");
		if(currentN==null) {
			System.out.println("선택한 노드가 없습니다");
		}else {
			System.out.println("선택한 노드 ->" + currentN.data);
		}
	}
	
	
	//전체 노드를 출력하는 메서드
	public void printAllNode() {
		System.out.println("****************");
		Node<T> ptr= head;
		while(ptr!=null && ptr.next!=null) {
			System.out.print(ptr.data+"->");//데이터값 출력후
			ptr=ptr.next;
		}
		
		if(ptr!=null) {
			System.out.println(ptr.data);
		}
	}
	
	//선택한 노드를 한칸 뒤로 이동시키는 메서드
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
