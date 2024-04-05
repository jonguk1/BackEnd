package day06;

//DFS(���� �켱 Ž��): (����Լ�) �Ǵ� ������ �̿��ؼ� ���� ����
//[1] ������ȸ(preorder)  [2] ������ȸ(inorder)  [3]������ȸ(postorder)
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
	//[1] ���� ��ȸ(preorder) : �θ�->����->������
	public void preorder(Node root) {
		if(root==null) {
			System.out.println("����");
			return;//��������
		}
		System.out.print(root.data + "->");
		preorder(root.left);
		preorder(root.right);
	}
	
	//[2] ���� ��ȸ : ����->�θ�->������
	public void inorder(Node root) {
		if(root==null) {
			System.out.println("����");
			return;//��������
		}
		inorder(root.left);
		System.out.print(root.data+"->");
		inorder(root.right);
	}
	
	//[3] ���� ��ȸ : ����->������->�θ�
	public void postorder(Node root) {
		if(root==null) {
			//System.out.println("����");
			return;//��������
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+"->");
	}
	
	public static void main(String[] args) {
		BinaryTreeDFS app=new BinaryTreeDFS();
		Node root=app.makeTree();
		//app.preorder(root);//����
		//app.inorder(root);//����
		app.postorder(root);//����
	}

}
