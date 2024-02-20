package day03;
//Date, Scanner ==> java.util패키지
//import java.util.Date;
//import java.util.Scanner;
import java.util.*;

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		int year= date.getYear()+1900;
		//System.out.println(year+"년");
		int month =date.getMonth()+1;
		//Jan:0 ~ Dec: 11 값을 반환
		int dd=date.getDate();
		
		int hh= date.getHours();
		int mm= date.getMinutes();
		int ss= date.getSeconds();
		
		//요일정보
		int dy = date.getDay();
		//Sun:0, Mon:1,...Sat:6
		
		String[] dayStr= {"일","월","화","수","목","금","토"};
		
		System.out.printf("오늘 날짜는 %d년 %d월 %d일 입니다%n" , year,month,dd);
		System.out.printf("현재 시간은 %d:%d:%d%n",hh,mm,dd);
		System.out.println(dayStr[dy]+"요일");
		
		//[1] month
		//28 : 2월
		//31 : 1, 3, 5, 7,8,10,12
		//30 : 4,5,9,11
		//switch ~case문 이용해서 "9월은 30일까지 있습니다"
		//스캐너로 "월을 입력하세요=>" 입력받은 뒤 해당 월의 일수를 출력하세요
		
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요=>");
		
		int inputMonth = sc.nextInt();
		int day = 30;
		
		switch (inputMonth) {
		case 2:
			day = 28;
			break;
		case 4 :
		case 5 :
		case 9 :
		case 11 :
			day = 30;
			break;
		default:
			day = 31;
			break;
		}
		
		System.out.println(inputMonth + "월은 " + day + "일까지 있습니다");
		
	}

}
