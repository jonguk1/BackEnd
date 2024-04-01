package day02;
//에라토스테네스의 체 를 이용해 소수를 구해 출력해봅시다
public class Q15_PrimeNum {

	public static void solution() {
		int [] prime = new int[1001];
		int cnt=0;
		//1. 반복문을 돌면서 2~1000까지의 값을 저장
		for(int i=2;i<1001;i++) {
			prime[i]=i;
		}
		//2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 지우자 ==> 0으로 수정
		for(int i=2;(i*i)<prime.length;i++) {
			if(prime[i]!=0) {
				for(int j=i*i;j<prime.length;j+=i) {
					prime[j]=0;
					cnt++;
				}
			}
		}
		//3. prime에 남은 0이 아닌 값들을 출력==>소수
		for(int i=2;i<prime.length;i++) {
			if(prime[i]==0) continue;
			System.out.print(prime[i] + ", ");
		}
		System.out.println();
		System.out.println("수행횟수 : " + cnt);
		
	}
	
	public static void main(String[] args) {
		solution();

	}

}
