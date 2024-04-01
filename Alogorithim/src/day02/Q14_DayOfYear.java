package day02;

import java.util.Scanner;

/*  평년 2월 28일
 *  윤년 2월 29일
 *  윤년의 판단 기준
 *  - 년도를 4로 나누어 떨어지면서 100으로는 나누어 떨어지면 안된다
 *  - 다만 400으로 나누어 떨어지면 윤년
 * 
 * */
public class Q14_DayOfYear {
	Scanner sc = new Scanner(System.in);
	int[][] mdays= {
			{31,28,31,30,31,30,31,31,30,31,30,31},//평년의 월별 일수
			{31,29,31,30,31,30,31,31,30,31,30,31} //윤년의 월별 일수
	};
	
	public void input_date() {
		int n =0;
		do {
		//반복문 돌면서 년,월,일
		System.out.print("년: ");
		int year=sc.nextInt();
		System.out.print("월: ");
		int month=sc.nextInt();
		System.out.print("일: ");
		int day=sc.nextInt();
		
		int days=0;		
		for(int i=1;i<month;i++) {
			if(year%4==0 && year%100 != 0 || year%400 ==0 ) {
				days+=mdays[1][i-1];
				System.out.println(i+"월: " + mdays[1][i-1] + "일");
			}else {
				days+=mdays[0][i-1];
				System.out.println(i+"월: " + mdays[0][i-1] + "일");
			}
		}
		days +=day;
		System.out.println(month+"월: " + day + "일");
		
		System.out.println("total: " + days);
		System.out.println(year + "년 " + days + "일째 입니다.");
		
		System.out.println("한번 더 하시겠습니까? 1.예 2. 아니요");
		n=sc.nextInt();
		}while(n==1);
		System.out.println("bye bye~~");
	}
	
	
	
	public static void main(String[] args) {
		Q14_DayOfYear app= new Q14_DayOfYear();
		app.input_date();

	}

}
