package day10;
import java.io.FileInputStream;
import java.io.IOException;
/*Map계열
 * Properties
 * xxx.properties 유형의 파일을 읽어서 해당 파일에 저장된 내용을 자바로
 * 옮기고자 할 때 사용한다.
 * 
 * */
import java.util.*;
public class PropertiesTest {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		prop.setProperty("OS", "Windows");
		prop.setProperty("Lang", "Java");
		System.out.println("사용하는 운영체제: " + prop.getProperty("OS"));
		System.out.println("사용하는 언   어: " + prop.getProperty("Lang"));
		System.out.println(prop);
		System.out.println("------------------------------");
		FileInputStream fis = new FileInputStream("src/day10/database.properties");
		prop.load(fis);
		///xxx.properties파일을 읽어서 Properties객체로 옮겨 놓는다
		fis.close();
		System.out.println(prop);
		
		//DbUser와 DbPwd만 가져와서 출력하세요
		System.out.println(prop.getProperty("DbUser"));
		System.out.println(prop.getProperty("DbPwd"));
		System.out.println(prop.getProperty("WAS","TomCat(디폴트값)"));
	}

}
