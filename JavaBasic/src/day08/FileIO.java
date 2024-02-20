package day08;
import javax.swing.*;
import java.io.*;
//파일을 읽어서 콘솔에 출력해보자
//절대경로
//C:\multicampus\Java-workspace\JavaBasic\src\day07\Superman.java

//상대경로
//src/day01/HelloWorld.java

//FileInputStream(1byte) 또는 FileReader(2byte-char) : 파일을 읽기 위한 클래스
//FileOutputStream(1byte) 또는 FileWriter(2byte-char) : 파일에 쓰기 위한 클래스
//FileReader 를 이용해 파일을 일어보자.
public class FileIO {

	public static void main(String[] args) {
		String fileName=JOptionPane.showInputDialog("읽을 파일명을 입력하세요");
		if(fileName == null) return;
		System.out.println("파일명: " + fileName);
		String content = reading(fileName);
		System.out.println(content);
	}
	/* 		Object
	 * 			|
	 * 		Throwable		
	 * 		|		|
	 * Exception	Error
	 * 		|
	 * 	IOException
	 * 		|
	 *  FileNotFoundException
	 * 
	 * */
	//[1] 발생한 예외를 try~catch로 처리해 보자
	public static String reading(String fileName){
		String str = "";
		FileReader fr = null;
		char[] data = new char[1000];//파일내용을 담을 배열
		
		try {
			//읽은 파일과 노드 연결
			fr=new FileReader(fileName);//FileNotFoundException이 발생됨
			
			int n =0;
			while((n=fr.read(data)) != -1) {//파일끝에 도달하면 -1을 반환
				//파일 내용은 data배열에 담긴다
				String content = new String(data,0,n);//n: 읽은 바이트수
				str += content;
			}//while------
			//중요한 코드
			if(fr != null) {
				fr.close();
			}
		}catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다");
		}catch(IOException e) {
			System.out.println("파일을 읽을수 없습니다");
		}
		return str;
	}
}
