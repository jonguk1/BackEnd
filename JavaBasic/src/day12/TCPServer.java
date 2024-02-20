package day12;

import java.net.*;
import java.util.Date;
import java.io.*;

/*서버단
 *  - ServerSocket => port번호(0~ 65535)
 *  - Socket
 * */
/*[구현할 내용]
 * - Client가 Server에 접속하면
 * [1] 서버로부터 먼저 "안녕하세요? 클라이언트님~~" 이란 메시지를 받는다.
 * [2] 그러면 클라이언트는 키보드 입력을 통해 메시지를 보낸다.
 * [3] 그러면 서버는 클라이언트로 부터 받은 메시지를 분석해서
 *     (1) "안녕하세요?" 또는 "하이" 란 메시지가 오면
 *         ==> "반가워요~~ 클님!!!" 이라 답변하고
 *     (2) "오늘 날짜는" 이란 메시지가 오면
 *        ==> 오늘 날짜를 알려주고
 *     (3) 그외 다른 메시지가 오면
 *        "~~~님, 어여 가!!"란 메시지를 보내자.      
 * */
public class TCPServer {

	public static void main(String[] args) throws IOException {
		// 1. 서버 소캣 생성
		ServerSocket server = new ServerSocket(8000);
		System.out.println("클라이언트 연결 기다리는 중...");
		while (true) {
			Socket sock = server.accept();
			InetAddress ip = sock.getInetAddress();
			System.out.println("클라이언트가 접속함.." + ip.getHostAddress());

			OutputStream os = sock.getOutputStream();// 1byte단위로 데이터를 내보냄
			PrintWriter out = new PrintWriter(os, true);// 2byte단위로
			// true를 주면 new line을 만나면 auto flush를 함
			out.println("안녕하세요 클님?");

			// 클이 보내오는 메세지를 들을 스트림
			InputStream is = sock.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String clientMsg = "";
			while ((clientMsg = in.readLine()) != null) {
				System.out.println("From Client>>" + clientMsg);
				if (clientMsg.contains("안녕") || clientMsg.contains("하이")) {
					out.println("반가워요~~ 클님!!!");
				} else if (clientMsg.contains("오늘 날짜")) {
					Date today = new Date();
					out.println(today.toString());
				} else {
					out.println("~~~님, 어여 가!!");
				}
				// 클의 메시지를 분석해서 메아리 답변을 보내자
				// out.println("How are you?");
			}
			if (clientMsg == null) {
				System.out.println("클이 접속을 끊었어요");
				break;
			}
		}
		server.close();

	}

}
