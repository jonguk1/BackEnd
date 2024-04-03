package day03;
/*#  ť�� ����
1. ť - Queue : Fisrt In First Out ����
    ex) �ý� �ټ��� : ���� ���� �� �� ����� ���� �ýø� ź��.
    - ť���� �����͸� �� �� ����ִ� ������ ��ť(enqueue),
      ť �ȿ� �ִ� �����͸� �� �� ������ ������ ��ť(dequeue)��� ǥ���Ѵ�.
2. ����- Stack : Last In First Out
    ex) ���� �ױ� :  ���ø� �׾� �ø���, ���� �� ���� ������ ���ú��� ������ ��
    - ���ÿ� ������ �ϳ� �ִ� ������ push,
      ���ÿ� �ִ� �����͸� �ϳ� ������ ������ pop��� ǥ���Ѵ�.
 * */
public class IntStack {
	private int capacity;//�뷮
	private int ptr;//�迭�� �ε����� ���Ǵ� ������. push()�Ҷ��� ����, pop()�Ҷ��� ����
	private int [] stk;//�������� ������ �迭
	
	public IntStack(int capa) {
		this.capacity=capa;
		ptr=0;
		stk=new int[this.capacity];
	}
	//���ÿ� ����Ǿ� �ִ� �����ͼ��� ��ȯ
	public int size() {
		return ptr;
	}
	/**�����͸� �����ϴ� �޼���, ����(�迭)�� ���� ���� ���� �߻� */
	public int push(int val) {
		if(ptr>=capacity) throw new RuntimeException("OverflowException");
		return stk[ptr++]=val;//push�� ���� ��ȯ�ϰ� �����Ͱ��� ������Ų��
	}
	/**���ÿ� �����(top)�� �ִ� �����͸� ��ȯ */
	public int pop() {
		if(ptr<=0) throw new RuntimeException("EmptyException");
		return stk[--ptr];
	}
	
	/**���� ����⿡ �ִ� �����͸� ��ȯ�ϴ� �޼���. �����ϴ� ������ �ƴ�*/
	public int peek() {
		if(ptr<=0) throw new RuntimeException("EmptyException");
		return stk[ptr-1];
	}
	
	/**������ ����ִ��� ���θ� �Ǵ��ϴ� �޼���*/
	public boolean empty() {
		return ptr<=0;
	}
	
	/**������ ���� á���� ���θ� �Ǵ��ϴ� �޼���*/
	public boolean full() {
		return ptr>=capacity;
	}
	
	/** ���ÿ� ��� ������ ����*/
	public void clear() {
		ptr=0;
	}
	/**���ÿ� ����� ��Ұ����� ����ϴ� �޼���
	 * LIFO
	 * ������ �� ==> �Ʒ� ������ �����͸� ���
	 * */
	public void printStack() {
		for(int i=0;i<ptr;i++) {
			System.out.println(stk[ptr-i-1]);
		}
	}
	/**�����͸� �˻��Ͽ� �����Ͱ� �ִ� ���� �ε��� ��ȣ�� ��ȯ*/
	public int search(int val) {
		for(int i=ptr-1;i>=0;i--) {
			if(stk[i]==val) {
				return i;
			}
		}
		return -1;
	}
	
}
