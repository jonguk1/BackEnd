package day02;

import java.util.Comparator;

//Comparator �������̽��� ������ Ŭ������ ������ �غ���
public class Emp {
	String name;
	int height;
	int salary;
	
	public Emp() {
		
	}
	public Emp(String n, int h, int s) {
		name=n; height=h; salary=s;
	}
	
	public String toString() {
		return name+": "+height+"cm, �޿�: "+salary;
	}
}

class HeightOrderComparator implements Comparator<Emp>{

	@Override
	public int compare(Emp o1, Emp o2) {
		if(o1.height == o2.height) {
			return 0;
		}else if(o1.height>o2.height) {
			return 1; //Ű ��������
		}else {
			return-1; 
		}
	}
}

//�޿� �������� �����ϵ��� �����غ���
class SalaryOrderComparator implements Comparator<Emp>{

	@Override
	public int compare(Emp o1, Emp o2) {
		/*if(o1.salary==o2.salary) {
			return 0;
		}else if(o2.salary>o1.salary) {
			return 1;
		}else {
			return -1;
		}*/
		return o2.salary-o1.salary;//��������
	}
	
}



