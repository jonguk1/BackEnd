package day04;
import java.sql.*;
import java.util.*;
import jdbc.util.*;
public class Select_Java_Member {

	public static void main(String[] args)
	throws Exception
	{
	     Connection con = DBUtil.getCon();
	     System.out.println("DB연결 성공");
	     
	     con.close();
		
	}

}
