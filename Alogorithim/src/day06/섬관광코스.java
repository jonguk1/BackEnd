package day06;

//Node努贰胶 备泅秦辑 级阑 楷搬茄 第
//3俺狼 包堡内胶甫 父甸绢 免仿窍技夸
public class 级包堡内胶 {
	
	Node root;
	
	class Node{
		String data;
		Node left, right;
		public Node(String data) {
			this.data=data;
			left=null;
			right=null;
		}
		
	}
	
	public Node makeTree() {
		Node root=new Node("H");
		root.left=new Node("F");
		root.right=new Node("S");
		
		root.left.left=new Node("U");
		root.left.right=new Node("E");
		
		root.right.left=new Node("Z");
		root.right.right=new Node("K");
		
		root.left.left.left=new Node("N");
		root.left.right.left=new Node("A");
		
		root.right.right.right=new Node("Y");
		root.left.right.left.right=new Node("T");
		
		return root;
	}
	
	public void aCourse(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data + "->");
		aCourse(root.left);
		aCourse(root.right);
	}
	
	public void bCourse(Node root) {
		if(root==null) {
			return;
		}
		bCourse(root.left);
		System.out.print(root.data + "->");
		bCourse(root.right);
	}
	
	public void cCourse(Node root) {
		if(root==null) {
			return;
		}
		cCourse(root.left);
		cCourse(root.right);
		System.out.print(root.data + "->");
	}
	
	
	
	public static void main(String[] args) {
		级包堡内胶 app =new 级包堡内胶();
		Node root =app.makeTree();
		System.out.println("------包堡内胶A-------");
		app.aCourse(root);
		System.out.println();
		System.out.println("------包堡内胶B-------");
		app.bCourse(root);
		System.out.println();
		System.out.println("------包堡内胶C-------");
		app.cCourse(root);

	}

}
