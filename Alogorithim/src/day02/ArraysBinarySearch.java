package day02;
import java.util.Arrays;
import java.util.Scanner;
//ArraysŬ������ ���� �˻� �޼��� binarySearch() Ȱ��
public class ArraysBinarySearch {
	static Scanner sc = new Scanner(System.in);
	
	public static void floatBinarySearch() {
		float[] arr= {1.3f, 3.14f, 20e-2f, 25,-73.8f,'A','a'};
		System.out.println(Arrays.toString(arr));
		System.out.println("---�������� ���� ��----------------");
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("�˻��� �Ǽ� ���� �Է��ϼ���: ");
		float key=sc.nextFloat();
		
		int idx=Arrays.binarySearch(arr, key);
		System.out.println("idx: " + idx);
		if(idx<0) {
			System.out.println(key+"���� �迭�� �����");
		}else {
			System.out.println(key+"���� �������� �迭 " + idx + "�� �ε����� �־��");
		}
		
	}
	
	public static void main(String[] args) {
		//floatBinarySearch();
		//stringBinarySearch();
		memberBinarySearch();
		//empBinarySearch();
	}
	
	private static void empBinarySearch() {
		//1. Emp��ü 4�� �����ؼ� �迭�� ������ �� �迭�� ����ϼ���
		Emp e1= new Emp("ȫ�浿", 178, 1000);
		Emp e2= new Emp("��ö��", 173, 2000);
		Emp e3= new Emp("�ֵ���", 181, 3000);
		Emp e4= new Emp("�迵��", 170, 4000);
		
		Emp[] emps= {e1,e2,e3,e4};
		System.out.println(Arrays.toString(emps));
		System.out.println("------------Ű �������� sort ��--------------");
		final HeightOrderComparator comp1 = new HeightOrderComparator();
		Arrays.sort(emps,comp1);
		System.out.println(Arrays.toString(emps));
		
		System.out.println("------------�޿� �������� sort ��--------------");
		final SalaryOrderComparator comp2= new SalaryOrderComparator();
		Arrays.sort(emps, comp2);
		System.out.println(Arrays.toString(emps));
		
		//�޿��� �˻��Ͽ� ��� ����ϱ�
		System.out.println("�޿��� ���� ����� �˻��Ͻó���?");
		int findSal=sc.nextInt();
		int idx= Arrays.binarySearch(emps, new Emp("",0,findSal),comp2);
		System.out.println("idx: " + idx);
		if(idx>=0) {
			System.out.println(emps[idx]);
		}
		//�迭 sort ==> Arrays.sort()
		//ArrayList sort ==> Collections.sort(list)
	}

	private static void memberBinarySearch() {
		// Member��ü 4�� �����ؼ� �迭�� �����ϼ���
		Member m1= new Member("ȫ�浿", 22, 178);
		Member m2= new Member("��ö��", 25, 173);
		Member m3= new Member("�ֵ���", 20, 181);
		Member m4= new Member("�迵��", 28, 170);
		Member m5= new Member("��ö��", 25, 173);
		
		System.out.println("�ּҰ� �� m2==m5: " + (m2==m5));
		System.out.println("���� �� m2.equals(m5): " + (m2.equals(m5)));
		
		Member[] users= {m1,m2,m3,m4,m5};
		System.out.println(Arrays.toString(users));
		System.out.println("----sort��--------------------------");
		Arrays.sort(users);//�����Ϸ��� �ش� ��ü�� Comparable�� �����ϴ���, Comparator�� �����ؾ� �Ѵ�
		System.out.println(Arrays.toString(users));
		System.out.println("�˻��� ȸ���� �̸� �Է�: ");
		String findName=sc.next();
		int idx= Arrays.binarySearch(users, new Member(findName,0,0));
		if(idx<0) {
			System.out.println(findName+"���� �����");
		}else {
			System.out.println(findName + "�� ������ "+users[idx]+"�Դϴ�");
		}
		System.out.println("idx: " + idx);
	}

	/*StringŬ������ Comparable�������̽�(compareTo()�޼��带 �����ϰ� ����)�� ��ӹ޾� �����ϰ� �ֱ� ������ �����̵ȴ�. 
	 * => ������ �Ǹ� �����˻� �����ϴ�.
	 * */
	private static void stringBinarySearch() {
		String[] str= {
				"abstract",   "assert",  "native",     "boolean",   "break",      "byte",
	            "case",       "catch",        "char",      "class",      "const",
	            "continue",   "default",      "do",        "double",     "else",
	            "enum",       "extends",      "final",     "finally",    "float",
	            "for",        "goto",         "if",    "void",    "implements", "import",
	            "instanceof", "int",          "interface", "long",       
	            "new",        "package",      "private",   "protected",  "public",
	            "return",     "short",        "static",    "strictfp",   "super",
	            "switch",     "synchronized", "this",      "throw",      "throws",
	            "transient",  "try",    "volatile",   "while"
		};
		
		Arrays.sort(str);
		System.out.println("---�������� ���� ��----------------");
		System.out.println(Arrays.toString(str));
		//�˻��� �Է� �޾� Arrays.binarySearch()�̿��ؼ� �˻��� ��ġ ����ϼ���
		System.out.println("�˻��� ���� �Է��ϼ���: ");
		String key=sc.next();
		int idx=Arrays.binarySearch(str, key);
		String msg=(idx<0)? key+"�� �����ϴ�":key+"�� �迭"+idx+"���� �־��";
		System.out.println(msg);
		
	}

}
