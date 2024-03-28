package day01;

import java.util.Scanner;

public class ÇÇÀÚ³ª´²¸Ô±â1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("»ç¶÷¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä=>");
		int n=sc.nextInt();
		
		//Solution3 st = new Solution3();
		Solution5 st = new Solution5();
		int result = st.solution(n);
		System.out.println(result);
		
	}

}
//ÇÇÀÚ³ª´²¸Ô±â1 
class Solution3 {
    public int solution(int n) {
        int answer = 0;
        for(int i=0;i<=n;i++) {
        	if(i % 7 ==1) {
        		answer++;
        	}
        }
        
        return answer;
    }
}
//ÇÇÀÚ³ª´²¸Ô±â2
class Solution5 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= 6 * n;i++){
            if(6 * i % n == 0){
                answer = i;
                break;
            }
        }
        
        
        return answer;
    }
}
