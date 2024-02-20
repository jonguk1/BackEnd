package day09;
/*사용자 정의 예외 클래스 만들기
 * [1] Exception을 상속받는다
 * [2] 생성자를 구성하고 그 안에서 super("예외메시지");를 호출한다
 * 
 * */
public class NotSupportNameException extends Exception{
	
	public NotSupportNameException() {
		super("NotSupportNameException");
	}
	
	public NotSupportNameException(String msg) {
		super(msg);
	}
}
