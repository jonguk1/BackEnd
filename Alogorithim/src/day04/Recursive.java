package day04;

public class Recursive {

	public static void recursive(int n) {
		if(n<=0) {//�⺻�ܰ�(��������)
			return;
		}
		System.out.println("recursive() n: " + n);
		recursive(n-1);//��� �ܰ� 
	}
	
	
	public static void main(String[] args) {
		recursive(4);
	}

}
