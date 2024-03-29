package day01;
import java.util.*;

public class Q4_MinMaxHeight {

	public static int[] min_max(int[] heights) {
		
		Arrays.sort(heights);

		int min= heights[0];
		int max= heights[heights.length-1];
		
		int[] arr = new int[2];
		
	    arr[0] = min;
	    arr[1] = max;
		
		return arr;//최대,최소값을 담은 배열 전환
	}
	
	public static void main(String[] args) {
		System.out.println("사람 수를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		//배열 생성후
		int[] arr = new int[num];
		//Random 클래스 이용. 배열에 키값을 저장하세요 (100 ~ 190)
		Random rd = new Random();
		for(int i =0;i<arr.length;i++) {
			arr[i] = rd.nextInt(91) + 100;
		}
		//min_max()호출해서 제일 큰 키, 제일 작은 키 값 출력하기
		System.out.println("큰 키: "  + min_max(arr)[1]);
		System.out.println("작은 키: "  + min_max(arr)[0]);
	}

}
