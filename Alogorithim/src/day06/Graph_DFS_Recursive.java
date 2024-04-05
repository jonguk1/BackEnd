package day06;

public class Graph_DFS_Recursive {
		  //0  1       2      3     4     5       6   7     8
	static int[][] graph= {{},{2,3,8},{1,6,8},{1,5},{5,7},{3,4,7},{2},{4,5},{1,2}};
	static boolean visited[]= new boolean[9];//디폴트값 false가 저장되어있다.
	
	
	public static void main(String[] args) {
		dfs(1);

	}
	//1->2->6->8->3->5->4->7->
	static void dfs(int index) {
		visited[index]=true;
		//방문노드 출력
		System.out.print(index+"->");
		for(int node:graph[index]) {
			if(!visited[node]) {
				//인접노드를 방문한 적이 없다면 dfs()호출
				dfs(node);//재귀호출
			}
		}
	}

}
