package day01;

import java.util.Scanner;

public class 피자나눠먹기3 {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("조각수를 입력하세요=>");
		int slice=sc.nextInt();
		System.out.println("사람수를 입력하세요=>");
		int n=sc.nextInt();
		
		Solution4 st = new Solution4();
		int result = st.solution(slice, n);
		System.out.println(result);
	}

	}
	//피자나눠먹기3
	class Solution4{
	    public int solution(int slice, int n) {
	        int answer = 0;
	        if(n % slice == 0 ) {
	        	answer=n/slice;
	        }else {
	        	answer=n/slice+1;
	        }
	        
	        return answer;
	    }
	}

