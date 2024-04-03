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
		
		//Emp객체 3개 저장한 후, 전체 노드 출력하세요
		Emp emp1 = new Emp("홍길동", 180, 1000);
		Emp emp2 = new Emp("김길동", 170, 2000);
		Emp emp3 = new Emp("이길동", 160, 3000);
	    MyLinkedList<Emp> list2 = new MyLinkedList<>();
	    list2.addFirst(emp1);
	    list2.addLast(emp2);
	    list2.addLast(emp3);
	    list2.printAllNode();
		//Emp 1개 더 생성한 후 맨 앞에 추가하세요
	    Emp emp4 = new Emp("김영희",150,4000);
	    list2.addFirst(emp4);
	    list2.printAllNode();
		//중간 지점에 있는 Emp객체를 하나 삭제하세요, 전체 출력
	    list2.removeCurrentNode();
	    list2.printAllNode();
		//급여가 3000인 사원이 있는지 검색해서 있다면 해당 사원 정보를 출력하세요
	    Emp findEmp=new Emp("",0,3000);
	    Comparator<Emp> comp =new SalaryOrderComparator():
	    Emp obj = list2.search(findEmp,comp);
	    
	    if(obj==null) {
	    	System.out.println("검색한 사원은 없습니다");
	    }else {
	    	System.out.println(obj);
	    }
		
	}

}
