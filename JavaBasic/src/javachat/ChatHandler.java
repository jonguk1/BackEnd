package javachat;
import java.net.*;
import java.io.*;
import java.util.*;
public class ChatHandler extends Thread{
	
	private Socket sock;
	private ArrayList<ChatHandler> userList;
	
	private BufferedReader in;
	private PrintWriter out;
	private boolean isStop=false;
	
	public ChatHandler(Socket s, ArrayList<ChatHandler> arr) {
		sock = s;
		userList=arr;
		try {
			in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(), true);
		} catch (Exception e) {
			System.out.println("error 1" + e);
		}
	}
	
	public void run() {
		try {
			//입장한 클의 닉네임 받기
			String nick = in.readLine();
			System.out.println(nick + "님 입장함");
			//모든 접속자에게 방금 입장한 사람의 닉네임을 쏴줍시다
			String msg ="##[" + nick + "]님이 입장했습니다##";
			broadcast(msg);
			while(!isStop) {
				//클이 보내오는 메세지를 듣고
				//모든 접속자에게 해당 메세지를 보내주자
				String cmsg = in.readLine();
				broadcast(nick + ">>" + cmsg);
				//퇴장 메세지가 온 경우
				if(cmsg.startsWith("##[") && cmsg.contains("퇴장")) {
					closeAll();
					//퇴장하는 이와 통신하는 챗핸들러를 userList에서 삭제
					break;
				}
				
			}
		}catch(Exception e) {
			System.out.println("run error 2: " + e);
			closeAll();
		}
	}
	
	public void closeAll(){
		isStop = true;
		try {
			if(in != null) in.close();
			if(out != null) out.close();
			if(sock != null) sock.close();
			userList.remove(this);
		}catch(Exception e) {}
	}
	//여러 스레드가 동시접속하여 메세지를 보낼때 대화 메시지를 순차적으로 전송하기 위해
	//synchronized 제한자를 붙인다
	private synchronized void broadcast(String msg) {
		for(ChatHandler chat:userList) {
			chat.out.println(msg);//모든 클에게 메세지를 쏜다
		}
		
	}
	
}
