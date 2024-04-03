package day03;

public class MyQueue {

	private Object[] que;//�迭 ==> ť
	private int capacity;//ť�� ũ��, �뷮
	private int front;//�� �� ��� ������(Ŀ��). deque�Ҷ� front���� ���;��� front++
	private int rear;//�� �� ��� ������. enque�Ҷ� ��(rear) ���� ���� ������ rear++
	private int cnt;//���� ������ ��
	
	
	public MyQueue(int capa) {
		this.capacity=capa;
		que=new Object[this.capacity];
		front=0;
		rear=0;
		cnt=0;
	}
	
	//�����͸� �����ϴ� �޼���=>��ť. �� �ڿ��� ����
	public Object enque(Object val) {
		if(cnt>=this.capacity) throw new RuntimeException("OverflowException");
		que[rear++]=val;
		cnt++;
		if(rear>=this.capacity) {
			rear=0;
		}
		
		return val;
	}
	
	//�����͸� ������ �޼��� => ��ť. ��ť�ҋ��� �� ��(front)���� ���´�.FIFO�����̹Ƿ�
	public Object deque() {
		if(cnt<=0) throw new RuntimeException("EmptyException");
		Object val=que[front++];
		cnt--;
		if(front>=this.capacity) {
			front=0;
		}
		return val;
	}
	//front �����͸� ��ȯ�ϴ� �޼���
	public Object peek() {
		if(cnt<=0) throw new RuntimeException("EmptyException");
		return que[front];
	}
	//���� ť�� ����� �����ͼ� ��ȯ
	public int size() {
		return cnt;
	}
	
	public boolean isFull() {
		return cnt>=this.capacity;
	}
	
	public boolean isEmpty() {
		return cnt<=0;
	}
	
	//ť�� ����� �����͸� ����ϴ� �޼���. FIFO ==> frontȰ��
	public void printQueue() {
		for(int i=0;i<cnt;i++) {
			System.out.println(que[(i+front)%capacity]);
			//System.out.println(que[i+front]);
		}
	}
	//ť���� �˻��ϴ� �޼���
	public int indexOf(Object val) {
		for(int i=0;i<cnt;i++) {
			int index=(i+front)%capacity;
			if(que[index].equals(val)) {
				return index;
			}
		}
		return -1;
	}	
	
}
