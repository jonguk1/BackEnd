package day03;

import java.util.Comparator;

import day02.Emp;

public class MyLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.addFirst("A");
		list.addLast("B");
		list.printCurrentNode();
		list.addLast("C");
		list.addLast("D");
		list.printCurrentNode();
		
		list.printAllNode();
		list.addFirst("E");
		list.printCurrentNode();
		list.printAllNode();
		
		list.removeLast();
		list.printCurrentNode();
		list.printAllNode();
		
		list.addFirst("F");
		list.printAllNode();
		
		list.printCurrentNode();
		list.next();
		list.next();
		list.next();
		list.printCurrentNode();

		list.removeCurrentNode();
		list.printAllNode();
		
		list.clear();
		list.printCurrentNode();
		list.printAllNode();
		
		//Emp��ü 3�� ������ ��, ��ü ��� ����ϼ���
		Emp emp1 = new Emp("ȫ�浿", 180, 1000);
		Emp emp2 = new Emp("��浿", 170, 2000);
		Emp emp3 = new Emp("�̱浿", 160, 3000);
	    MyLinkedList<Emp> list2 = new MyLinkedList<>();
	    list2.addFirst(emp1);
	    list2.addLast(emp2);
	    list2.addLast(emp3);
	    list2.printAllNode();
		//Emp 1�� �� ������ �� �� �տ� �߰��ϼ���
	    Emp emp4 = new Emp("�迵��",150,4000);
	    list2.addFirst(emp4);
	    list2.printAllNode();
		//�߰� ������ �ִ� Emp��ü�� �ϳ� �����ϼ���, ��ü ���
	    list2.removeCurrentNode();
	    list2.printAllNode();
		//�޿��� 3000�� ����� �ִ��� �˻��ؼ� �ִٸ� �ش� ��� ������ ����ϼ���
	    Emp findEmp=new Emp("",0,3000);
	    Comparator<Emp> comp =new SalaryOrderComparator():
	    Emp obj = list2.search(findEmp,comp);
	    
	    if(obj==null) {
	    	System.out.println("�˻��� ����� �����ϴ�");
	    }else {
	    	System.out.println(obj);
	    }
		
	}

}
