package day06;

//DFS(깊이 우선 탐색): (재귀함수) 또는 스택을 이용해서 구현 가능
//[1] 전위순회(preorder)  [2] 중위순회(inorder)  [3]후위순회(postorder)
public class BinaryTreeDFS {

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
		
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		
		return root;
	}
	//[1] 전위 순회(preorder) : 부모->왼쪽->오른쪽
	public void preorder(Node root) {
		if(root==null) {
			System.out.println("종료");
			return;//종료조건
		}
		System.out.print(root.data + "->");
		preorder(root.left);
		preorder(root.right);
	}
	
	//[2] 중위 순회 : 왼쪽->부모->오른쪽
	public void inorder(Node root) {
		if(root==null) {
			System.out.println("종료");
			return;//종료조건
		}
		inorder(root.left);
		System.out.print(root.data+"->");
		inorder(root.right);
	}
	
	//[3] 후위 순회 : 왼쪽->오른쪽->부모
	public void postorder(Node root) {
		if(root==null) {
			//System.out.println("종료");
			return;//종료조건
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+"->");
	}
	
	public static void main(String[] args) {
		BinaryTreeDFS app=new BinaryTreeDFS();
		Node root=app.makeTree();
		//app.preorder(root);//전위
		//app.inorder(root);//중위
		app.postorder(root);//후위
	}

}
