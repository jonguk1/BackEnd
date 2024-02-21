package jdbc.bbs;
import java.sql.*;
import java.util.*;
//DAO (Data Access Object) : Database에 접근하여 CRUD로직을 수행하는 객체 
//=> Data Layer(Persistence Layer) ==> Model에 해당
public class MemberDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/** 회원 가입 처리 - C(INSERT)*/
	public int insertMember(MemberVO user) throws SQLException{
		try {
			con = DBUtil.getCon();
			String sql = "INSERT INTO java_member(id,name,pw,tel,indate)";
			       sql+= " VALUES(?,?,?,?,SYSDATE)";
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPw());
			ps.setString(4, user.getTel());
			
			int n =ps.executeUpdate();
			return n;
		}finally {
			close();
		}
	}
	
	
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
