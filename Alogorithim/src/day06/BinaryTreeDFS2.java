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
	//���ܳ�带 ������ ���� Level���� ���ѵ�,�ּҷ��������� �����Ѵ�
	public int DFS(int level,Node root) {
		if(root.left==null&&root.right==null) {
			//���� �����
			System.out.println(root.data+"->����");
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
