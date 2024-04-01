package day02;

import java.util.Scanner;

/*  ��� 2�� 28��
 *  ���� 2�� 29��
 *  ������ �Ǵ� ����
 *  - �⵵�� 4�� ������ �������鼭 100���δ� ������ �������� �ȵȴ�
 *  - �ٸ� 400���� ������ �������� ����
 * 
 * */
public class Q14_DayOfYear {
	Scanner sc = new Scanner(System.in);
	int[][] mdays= {
			{31,28,31,30,31,30,31,31,30,31,30,31},//����� ���� �ϼ�
			{31,29,31,30,31,30,31,31,30,31,30,31} //������ ���� �ϼ�
	};
	
	public void input_date() {
		int n =0;
		do {
		//�ݺ��� ���鼭 ��,��,��
		System.out.print("��: ");
		int year=sc.nextInt();
		System.out.print("��: ");
		int month=sc.nextInt();
		System.out.print("��: ");
		int day=sc.nextInt();
		
		int days=0;		
		for(int i=1;i<month;i++) {
			if(year%4==0 && year%100 != 0 || year%400 ==0 ) {
				days+=mdays[1][i-1];
				System.out.println(i+"��: " + mdays[1][i-1] + "��");
			}else {
				days+=mdays[0][i-1];
				System.out.println(i+"��: " + mdays[0][i-1] + "��");
			}
		}
		days +=day;
		System.out.println(month+"��: " + day + "��");
		
		System.out.println("total: " + days);
		System.out.println(year + "�� " + days + "��° �Դϴ�.");
		
		System.out.println("�ѹ� �� �Ͻðڽ��ϱ�? 1.�� 2. �ƴϿ�");
		n=sc.nextInt();
		}while(n==1);
		System.out.println("bye bye~~");
	}
	
	
	
	public static void main(String[] args) {
		Q14_DayOfYear app= new Q14_DayOfYear();
		app.input_date();

	}

}
