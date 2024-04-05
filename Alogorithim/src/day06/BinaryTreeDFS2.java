package day06;

import day06.BinaryTreeDFS.Node;

public class BinaryTreeDFS2 {
	
	Node root;
	
	class Node{
		int data;
		Node left, right;
		public Node(int data) {
			this.data=data;
			left=null;
			right=null;
		}
		
	}
	public Node makeTree() {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		
		return root;
	}
	//말단노드를 만날때 까지 Level값을 구한뒤,최소레벨값으로 전한한다
	public int DFS(int level,Node root) {
		if(root.left==null&&root.right==null) {
			//말단 노드라면
			System.out.println(root.data+"->말단");
			return level;
		}
		System.out.println(root.data+"->");
		int L1=DFS(level+1,root.left);
		System.out.println("L1: " + L1);
		
		int L2=DFS(level+1,root.right);
		System.out.println("L2: " + L2);
		
		int min=Math.min(L1, L2);
		return min;
	}
	
	
	public static void main(String[] args) {
		BinaryTreeDFS2 app=new BinaryTreeDFS2();
		Node root=app.makeTree();
		int minL=app.DFS(0,root);
		
		System.out.println(minL);

	}

}
