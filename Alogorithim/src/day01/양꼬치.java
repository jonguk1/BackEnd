package day01;

import java.util.Scanner;

public class �粿ġ {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("�粿ġ�� �Է��ؼ���=>");
		int n = sc.nextInt();
		System.out.println("������� �Է��ؼ���=>");
		int k =sc.nextInt();
		Solution2 st = new Solution2();
		int res = st.solution(n, k);
		System.out.println(res);
	}

}
//�粿ġ
class Solution2 {
    public int solution(int n, int k) {
        int answer = 0;
        
        answer= n*12000+k*2000-((n/10)*2000);
        
        return answer;
    }
}