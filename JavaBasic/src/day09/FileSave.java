package day09;
//FileInputStream(1byte) 또는 FileReader(2byte-char) : 파일을 읽기 위한 클래스

//FileOutputStream(1byte) 또는 FileWriter(2byte-char) : 파일에 쓰기 위한 클래스
//FileWriter 를 이용해 파일을 써보자.

import java.io.*;
import java.util.*;

public class FileSave {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("저장할 파일명을 입력하세요=>");
		String fileName = sc.nextLine();

		System.out.println("저장할 내용을 입력하세요=>");
		String content = sc.nextLine();

		try {
			// 1. 파일과 노드 연결 => FileWriter객체 생성 => 예외 발생
			FileWriter fw = new FileWriter(fileName,true);
			//true를 주면 기존 파일 내용에 덧붙여 쓴다(append기능)
			
			// 2. FileWriter의 write()메서드 호출=> 예외 발생
			fw.write(content + "\n");
			fw.flush();//스트림에 데이터가 남아있으면 밀어내기를 해준다
			
			// 3. 파일과 노드 연결 닫기 => close() => 예외 발생
			if (fw != null) {
				fw.close();
			}
			System.out.println(fileName + "에 쓰기 완료");
		} catch (IOException e) {
			System.out.println("파일 쓰기 중 에러: " + e.getMessage());
		}
		// Ctrl+Shift+F : 자동 코드 정렬

	}

}
