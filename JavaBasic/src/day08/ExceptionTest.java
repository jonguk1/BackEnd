package day08;
/*예외 처리 방법
 * [1] 직접 handle하는 방법
 * 		try~ catch절을 이용
 * [2] 선언(declare)하는 방법
 * 		throws 절을 이용
 * 
 * */
public class ExceptionTest {

	public static void main(String[] args) {
		String[] fruits = {"Apple","Grape","Orange"};
		try {
			for(int i=0; i<=3;i++) {
				System.out.println(fruits[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			//예외 처리 코드
			System.out.println("배열 인덱스가 초과되었어요. 확인해보세요~");
		}
		System.out.println("##반드시 실행되어야 할 코드###");
	}

}
