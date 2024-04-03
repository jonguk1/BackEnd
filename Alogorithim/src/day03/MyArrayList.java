package day03;

public class MyArrayList<E> {
	
	private Object[] data;
	private int capacity;
	private int index;
	
	public MyArrayList() {
		this(5);//�ʱ�뷮 5�� ����
	}
	
	public MyArrayList(int capa) {
		this.capacity=capa;
		data=new Object[this.capacity];
		index=0;
	}
	//����� �����ͼ�
	public int size() {
		return index;
	}
	
	//������ ����
	public E add(E obj) {
		//�����Ͱ� �� á�ٸ� => ��������� �ι�� ������Ű��
		if(index >= capacity-1) {
			doubling();
		}
		
		data[index++]=obj;
		return obj;
	}
	
	private void doubling() {
		//2�� �뷮�� ���ο� �迭�� �����ؼ� ������ �����ߴ� ������ �ű��
		this.capacity = this.capacity*2;
		
		Object[] newData= new Object[this.capacity];
		//������ �����ߴ� ������ �ű��
		for(int i=0;i<data.length;i++) {
			newData[i]=data[i];
		}
		//������� data�� ���� ���� �迭�� �ּҰ��� �Ҵ�
		this.data=newData;
		System.out.printf("double()=> index: %d, capacity: %d, size: %d%n",index,capacity,size());
	}
	
	//������ ������
	public E get(int i) {
		if(i<0) {
			throw new RuntimeException("Negative Index Value");
		}else if(i>=index) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Object val= data[i];
		return (E)val;
	}
	
	//������ �˻�
	public int indexOf(E obj) {
		for(int i=0;i<size();i++) {
			if(data[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}
	
	//������ ����
	public void remove(int i) {
		if(i<0) {
			throw new RuntimeException("Negative Index Value");
		}else if(i>=index) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if(i<size()) {
			for(int k=i;k<size();k++) {
				data[k]=data[k+1];
			}
			index--;
		}
		
	}
	
	
	
}
