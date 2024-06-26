package day01;

import java.util.Arrays;
import java.util.List;

public class StringTest {

	public static void main(String[] args) {
		String s="나는 프로그래머 스머프야";
		String s2 = "진짜";
		//String : final 클래스. immutability(불변성). 원본 불변
		System.out.println(s+s2);//문자열 결합
		System.out.println(s.concat(s2));
		System.out.println("s: " + s);
		System.out.println(s.charAt(3));
		System.out.println(s.startsWith("나는")+","+s.endsWith("나는"));
		//s에서 "프로그래머" 단어를 추출해 출력하세요
		System.out.println(s.substring(3,8));
		//s에서 "프" 자가 위치한 곳의 인덱스 번호를 찾아 출력하세요
		System.out.println(s.indexOf("프"));
		//s에서 "프" 자가 위치한 곳의 인덱스 번호를 뒤에서 찾아 출력하세요
		System.out.println(s.lastIndexOf("프"));
		
		//문자열 편집==> StringBuffer(동기화 구현됨), StringBuilder(동기화 구현 안됨)

		System.out.println(s.replace("나", "너"));
		
	    String[] tokens= s.split(" ");
	    System.out.println(Arrays.toString(tokens));
	    
	    String str="[ 12, 25, 33, 8, 3,50  ]";
	    
	    System.out.println(str);
	    
	    //[1] str에 저장된 값들의 합계값을 출력
		String[] str2 = str.replace("[", "")
			       			.replace("]", "")
			       			.split(",");

		//[2] str에 저장된 값들을 int[] 배열에 담아서 오름차순 정렬해 출력하세요
		int[] numbers = new int[str2.length];
		
		int sum=0;
		
		for(int i=0;i<numbers.length;i++) {
			numbers[i] = Integer.parseInt(str2[i].trim());
			sum += numbers[i];
		}
		
		System.out.println("합계: " + sum);
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		
		String s3="Happy";
		
		char[] ch = s3.toCharArray();
		System.out.println(Arrays.toString(ch));
		
		String s4=" '휴지', '블루 볼펜','지우개',+=-,'ㅋㅋ','Happy','0101'";
		
		//s4 특수문자(+=-') 제거한후 출력
		s4=s4.replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣,a-zA-z0-9]","");//한글이 아니면 모두 빈문자열 교체
		
		System.out.println(s4);
		
	}

}
