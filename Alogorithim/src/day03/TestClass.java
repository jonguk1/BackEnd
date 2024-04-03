package day03;
import java.util.*;
public class TestClass {

	public static void main(String[] args) {
		Solution s1 = new Solution( );
		int[] arr= {1,1,3,3,0,1,1};
		int[] result =s1.solution(arr);
		System.out.println(Arrays.toString(result));

	}

}
class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        st.add(arr[0]);
        
        for(int i=1;i<arr.length;i++) {
        	if(arr[i-1] !=arr[i]) {
        		st.push(arr[i]);
        	}
        }
        
        int[] answer = new int[st.size()];
        
        for(int i=0;i<answer.length;i++) {
        	answer[i]=st.get(i);
        }

        return answer;
    }
}



