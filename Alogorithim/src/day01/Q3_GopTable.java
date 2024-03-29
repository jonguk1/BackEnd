package day01;

public class Q3_GopTable {

	//°ö¼À Å×ÀÌºí
	public static void solution() {
		
		System.out.print("   |");
		for(int i =1; i<=9;i++) {
			System.out.printf("%3d",i);
		}
		System.out.println("");
		System.out.println("---+-----------------------------");
		
		for(int j=1;j<=9;j++) {
			System.out.printf("%2d |",j);
			for(int k=1;k<=9;k++) {
				System.out.printf("%3d",j*k);
			}
			System.out.println("");
		}
		
	}
	
	public static void main(String[] args) {
		
		solution();

	}

}
