package day03;

public class ForTest2 {

	public static void main(String[] args) {
		//[1]for루프 이용해서 1~10까지의 합과 곱을 구해 출력하세요
		//1+2+3+....+10=55
		//1*2*3* ....*10=3628800
		int sum = 0;
		int gop = 1;
		
		for(int i=1;i<11;i++) {
			sum += i;
			gop *= i;
		}
		System.out.println(sum);
		System.out.println(gop);
		
		//[2] 1~20까지 정수 중 (2 또는 3의 배수)가 아닌 수를
		//출력하고, 이 수들의 총합을 구하세요
		
		int result3= 0;
		
		for(int i=0;i<21;i++) {
			if(i % 2 != 0 && i % 3 !=0) {
				result3 += i;
			}
		}
		System.out.println(result3);
		
		//[3] 알파벳 대문자A,B...Z 를 for루프 이용해 출력하기
		String result4 = "";
		
		for(char ch='A';ch<='Z';ch++) {
			result4 += ch;
		}
		
		System.out.println(result4);
		
	}

}
