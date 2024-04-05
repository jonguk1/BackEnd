package day06;

import java.util.Stack;

public class Graph_DFS_Stack {

						  //0  1       2      3     4     5       6   7     8
	static int[][] graph= {{},{2,3,8},{1,6,8},{1,5},{5,7},{3,4,7},{2},{4,5},{1,2}};
	static boolean visited[]= new boolean[9];//디폴트값 false가 저장되어있다.
	//스택에 넣을때 이미 방문한 숫자는 넣지 않도록 방문 여부를 체크할 예정. 방문하면 true값
	static Stack<Integer> sk=new Stack<>();
			
	public static void main(String[] args) {
		sk.push(1);//시작 노드 저장
		visited[1]=true;//스택에 저장한 노드 방문 처리
		
		while(!sk.isEmpty()) {
			//스택에서 노드를 하나 꺼내자(LIFO)
			int i=sk.pop();
			System.out.print(i+"->");
			//꺼낸 노드와 인접한 노드를 찾는다. 방문하지 않는 노드라면 스택에 푸시하자
			//graph[1][0], graph[1][1],graph[1][2]
			for(int node:graph[i]) {
				if(!visited[node]) {
					sk.push(node);
					visited[node]=true;//방문자리
				}
			}
			
		}

	}

}
