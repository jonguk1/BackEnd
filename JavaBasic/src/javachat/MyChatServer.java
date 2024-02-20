package javachat;
import java.net.*;
import java.io.*;
import java.util.*;
/** 
 * 특정 포트로 클라이언트의 연결을 무한정 기다린다.
	클과  연결이  이루어지면 클라이언트와 통신을 담당할 스레드(ChatHandler)
	를 생성한 후 스레드를 동작시킨다.
	또한 여러 명의 클라이언트와 통신하는 ChatHandler를 ArrayList에 저장하여
	관리한다.
*/
public class MyChatServer extends Thread{

	private ServerSocket server;
	private final int port =9999;
	private ArrayList<ChatHandler> userList;
	
	public MyChatServer() {
		try {
			server= new ServerSocket(port);
			userList=new ArrayList<>();
			System.out.println("###챗 서버가 시작됐어요###############");
			System.out.println("###[" + port + "]번 포트에서 대기중##");
		}catch(IOException e) {
			System.out.println("챗서버 시작 중 예외: " + e);
			return;
		}
		
	}
	
	public void run() {
		System.out.println("##Ready...");
		while(true) {
			try {
			Socket sock = server.accept();
			System.out.println("##클이 접속했어요###");
			//클과 통신을 담당할 스레드 생성, 동작//////////////
			ChatHandler handler = new ChatHandler(sock, userList);
			userList.add(handler);
			handler.start();//스레드 동작
			}catch(IOException e) {
				System.out.println("#클의 소켓 생성 실패: " + e);
			}
		}
	}
	
	public static void main(String[] args) {
		MyChatServer chat = new MyChatServer();
		chat.start();
	}

}
