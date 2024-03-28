package day01;

import java.util.Scanner;

public class 양꼬치 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("양꼬치을 입력해세요=>");
		int n = sc.nextInt();
		System.out.println("음료수을 입력해세요=>");
		int k =sc.nextInt();
		Solution2 st = new Solution2();
		int res = st.solution(n, k);
		System.out.println(res);
	}

}
//양꼬치
class Solution2 {
    public int solution(int n, int k) {
        int answer = 0;
        
        answer= n*12000+k*2000-((n/10)*2000);
        
        return answer;
    }
}