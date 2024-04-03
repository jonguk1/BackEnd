package day02;

import java.util.Arrays;

public class TestClass {

	public static void main(String[] args) {
		Solution sl = new Solution();
		int[] array= {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] result=sl.solution(array, commands);
		System.out.println(Arrays.toString(result));
		
		//Solution2 s2 = new Solution2();
		//System.out.println(s2.solution("hello"));

	}
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        System.out.println(Arrays.toString(array));
        for(int m=0;m<commands.length;m++) {
        	int start= commands[m][0];//2
        	int end= commands[m][1];//5
        	int find=commands[m][2];
        	int[] arr= new int[(end-start)+1];
        	System.out.println( arr.length);
        	for(int i=start-1;i<end;i++) {
        		arr[i-start+1] = array[i];
        	}
        	Arrays.sort(arr);
        	answer[m] = arr[find-1];
        	
        }
        return answer;
    }
}

class Solution2 {
    public String solution(String s) {
        String answer = "";
        char[] arr = new char[s.length()];

        for(int i=0;i<s.length();i++) {
        	if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
        		arr[i] = s.charAt(i);
        	}
        }
        
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length;i++) {
    		answer+=arr[i];
        }
        answer = answer.trim();
        
        return answer;
    }
}
