package day12;
import java.net.*;
import java.io.*;

public class TCPClient {

	public static void main(String[] args) 
	throws IOException
	{
			Socket sock = new Socket("120.50.107.98",8000);
			System.out.println("서버에 접속되었음!!");

	}

}
