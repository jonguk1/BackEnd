package day01;
//https://school.programmers.co.kr/learn/courses/30/lessons/120829
import java.util.*;
public class ������ {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("angle�� �Է��ؼ���=>");
		int angle=sc.nextInt();
		
		Solution1 st= new Solution1();
		int res = st.solution(angle);
		System.out.println(res);
	}

}
//������
class Solution1 {
    public int solution(int angle) {
        int answer = 0;
        if(angle >0 && angle<90) {
        	answer=1;
        }else if(angle==90) {
        	answer=2;
        }else if(angle >90 && angle<180) {
        	answer=3;
        }else if(angle==180) {
        	answer=4;
        }
        return answer;
    }
}
