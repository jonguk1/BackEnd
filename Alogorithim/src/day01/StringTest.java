package day01;

import java.util.Arrays;
import java.util.List;

public class StringTest {

	public static void main(String[] args) {
		String s="���� ���α׷��� ��������";
		String s2 = "��¥";
		//String : final Ŭ����. immutability(�Һ���). ���� �Һ�
		System.out.println(s+s2);//���ڿ� ����
		System.out.println(s.concat(s2));
		System.out.println("s: " + s);
		System.out.println(s.charAt(3));
		System.out.println(s.startsWith("����")+","+s.endsWith("����"));
		//s���� "���α׷���" �ܾ ������ ����ϼ���
		System.out.println(s.substring(3,8));
		//s���� "��" �ڰ� ��ġ�� ���� �ε��� ��ȣ�� ã�� ����ϼ���
		System.out.println(s.indexOf("��"));
		//s���� "��" �ڰ� ��ġ�� ���� �ε��� ��ȣ�� �ڿ��� ã�� ����ϼ���
		System.out.println(s.lastIndexOf("��"));
		
		//���ڿ� ����==> StringBuffer(����ȭ ������), StringBuilder(����ȭ ���� �ȵ�)

		System.out.println(s.replace("��", "��"));
		
	    String[] tokens= s.split(" ");
	    System.out.println(Arrays.toString(tokens));
	    
	    String str="[ 12, 25, 33, 8, 3,50  ]";
	    
	    System.out.println(str);
	    
	    //[1] str�� ����� ������ �հ谪�� ���
		String[] str2 = str.replace("[", "")
			       			.replace("]", "")
			       			.split(",");

		//[2] str�� ����� ������ int[] �迭�� ��Ƽ� �������� ������ ����ϼ���
		int[] numbers = new int[str2.length];
		
		int sum=0;
		
		for(int i=0;i<numbers.length;i++) {
			numbers[i] = Integer.parseInt(str2[i].trim());
			sum += numbers[i];
		}
		
		System.out.println("�հ�: " + sum);
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		
		String s3="Happy";
		
		char[] ch = s3.toCharArray();
		System.out.println(Arrays.toString(ch));
		
		String s4=" '����', '��� ����','���찳',+=-,'����','Happy','0101'";
		
		//s4 Ư������(+=-') �������� ���
		s4=s4.replaceAll("[^��-����-�Ӱ�-�R,a-zA-z0-9]","");//�ѱ��� �ƴϸ� ��� ���ڿ� ��ü
		
		System.out.println(s4);
		
	}

}
