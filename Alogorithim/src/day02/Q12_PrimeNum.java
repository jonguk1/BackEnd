package day02;
//�Ҽ� ���ϱ�
//�Ҽ�: 1�� �ڽ����θ� ���������� ��
//1 ~ 1000������ ���� �� �Ҽ��� ���� ����ϼ���
public class Q12_PrimeNum {

	public static void solution() {
		int cnt=0;
		for(int i=2;i<=1000;i++) {
			int j;
			for(j=2;j<=i;j++) {
				cnt++;
				if(i%j==0) break;
			}
			if(i==j) {
				System.out.print(i+", ");
			}
		}
		System.out.println();
		System.out.println("����Ƚ��: " + cnt);
	}
	
	public static void main(String[] args) {
		solution();
		
	}

}
