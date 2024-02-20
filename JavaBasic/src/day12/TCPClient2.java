package day12;
import java.net.*;
import java.io.*;
import java.util.*;
public class TCPClient2 {
    public static void main(String[] args) 
    throws Exception
    {
        final int port=8000;
        Socket sock=new Socket("localhost",port);
        System.out.println("##서버에 접속 성공!!###");
        //서버가 보내오는 데이터를 들을 스트림 얻어오기
        InputStream is=sock.getInputStream();
        BufferedReader in
        =new BufferedReader(new InputStreamReader(is,"euc-kr"));
        //1. 서버의 인사말 듣기
        String serverMsg=in.readLine();
        System.out.println("From Server>>"+serverMsg);
        
        //2. 서버에게 키보드로 입력하여 메시지를 보내자
        Scanner sc=new Scanner(System.in);//키보드입력
        PrintWriter out=new PrintWriter(sock.getOutputStream(),true);//서버에 출력할 스트림
        String myMsg="";
        while((myMsg=sc.nextLine())!=null) {
            out.println(myMsg);//서버에 나의 메시지 보내기
            serverMsg=in.readLine();//서버의 메시지 듣기
            System.out.println("From Server>>"+serverMsg);//내 콘솔에 출력
        }
        
        if(in!=null) in.close();
        if(is!=null) is.close();
        if(sock!=null) sock.close();
    }
}