package day02;
//�����佺�׳׽��� ü �� �̿��� �Ҽ��� ���� ����غ��ô�
public class Q15_PrimeNum {

	public static void solution() {
		int [] prime = new int[1001];
		int cnt=0;
		//1. �ݺ����� ���鼭 2~1000������ ���� ����
		for(int i=2;i<1001;i++) {
			prime[i]=i;
		}
		//2. 2���� �����ؼ� Ư�� ���� ����� �ش��ϴ� ���� ������ ==> 0���� ����
		for(int i=2;(i*i)<prime.length;i++) {
			if(prime[i]!=0) {
				for(int j=i*i;j<prime.length;j+=i) {
					prime[j]=0;
					cnt++;
				}
			}
		}
		//3. prime�� ���� 0�� �ƴ� ������ ���==>�Ҽ�
		for(int i=2;i<prime.length;i++) {
			if(prime[i]==0) continue;
			System.out.print(prime[i] + ", ");
		}
		System.out.println();
		System.out.println("����Ƚ�� : " + cnt);
		
	}
	
	public static void main(String[] args) {
		solution();

	}

}
