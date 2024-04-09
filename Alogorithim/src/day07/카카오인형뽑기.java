package day07;

import java.util.Stack;

public class īī�������̱� {

	public static void main(String[] args) {
		īī�������̱� app = new īī�������̱�();
		int[][] board= {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves= {1,5,3,5,1,2,1,4};
		int qty=app.solution(board, moves);
		System.out.println("���ĵ� ���� ����: " + qty);
	}
	
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int mvs:moves) {//ũ������ �����̴� ��ġ��
        	for(int i=0;i<board.length;i++) {//board�� ���� ũ�⸸ŭ �ݺ�
        		if(board[i][mvs-1]==0) continue;
        		int tmp=board[i][mvs-1];//�ش� ��ġ�� ������ ���� �ӽú����� ����
        		board[i][mvs-1]=0;//���� ������ 0���� �����
        		if(!stack.isEmpty()&&tmp==stack.peek()) {//tmp�� ������ ������ ���ÿ� �ִٸ�
        			answer+=2;
        			stack.pop();//������ ���� ����
        		}else {
        			stack.push(tmp);
        		}
        		break;
        	}
        	
        }
        return answer;
    }

}
