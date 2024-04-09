package day07;

import java.util.Stack;

public class 카카오인형뽑기 {

	public static void main(String[] args) {
		카카오인형뽑기 app = new 카카오인형뽑기();
		int[][] board= {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves= {1,5,3,5,1,2,1,4};
		int qty=app.solution(board, moves);
		System.out.println("폭파된 인형 갯수: " + qty);
	}
	
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int mvs:moves) {//크레인이 움직이는 위치값
        	for(int i=0;i<board.length;i++) {//board의 행의 크기만큼 반복
        		if(board[i][mvs-1]==0) continue;
        		int tmp=board[i][mvs-1];//해당 위치의 인형을 꺼내 임시변수로 저장
        		board[i][mvs-1]=0;//꺼낸 인형은 0으로 만든다
        		if(!stack.isEmpty()&&tmp==stack.peek()) {//tmp와 동일한 인형이 스택에 있다면
        			answer+=2;
        			stack.pop();//동일한 인형 제거
        		}else {
        			stack.push(tmp);
        		}
        		break;
        	}
        	
        }
        return answer;
    }

}
