package jdbc.bbs;

import java.sql.*;
import java.util.*;

//DAO (Data Access Object)
public class BbsDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//게시글 쓰기(시퀀스-BBS_SEQ)
	public int insertBbs(BbsVO vo) throws SQLException{
		try {
			con = DBUtil.getCon();
			String sql = "INSERT INTO BBS(no,title,writer,content,wdate)";
				   sql+= " VALUES(bbs_seq.nextval,?,?,?,sysdate)";
			
		    ps = con.prepareStatement(sql);
		    ps.setString(1, vo.getTitle());
		    ps.setString(2, vo.getWriter());
		    ps.setString(3, vo.getContent());
		    
		    int n = ps.executeUpdate();
		    return n;

		}finally {
			close();
		}
	}
	
	//게시글 목록 가져오기
	public ArrayList<BbsVO> selectAll() throws SQLException {
		try {
			con = DBUtil.getCon();
			String sql = "SELECT no,title,writer,content,wdate FROM bbs ORDER BY no DESC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			return makeList(rs);
		}finally {
			close();
		}
	}
	
	//게시글 검색 하기
	public ArrayList<BbsVO> findList(String no,String title,String writer) throws SQLException {
		try {
			con = DBUtil.getCon();
			String sql = "SELECT no,title,writer,content,wdate FROM bbs";
				   sql +=" WHERE no LIKE '%'||?||'%' and title LIKE '%'||?||'%' and writer LIKE '%'||?||'%' ";
				   sql +=" ORDER BY no DESC";
		    ps=con.prepareStatement(sql);
		    ps.setString(1, no);
		    ps.setString(2, title);
		    ps.setString(3, writer);
		    rs=ps.executeQuery();
		    
			return makeList(rs);
		    
		}finally {
			close();
		}
	}
	
	
	public ArrayList<BbsVO> makeList(ResultSet rs) throws SQLException{
		ArrayList<BbsVO> arr = new ArrayList<>();
		while(rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String content = rs.getString("content");
			java.sql.Date wdate = rs.getDate("wdate");
			
			BbsVO record = new BbsVO(no, title, writer, content, wdate);
			arr.add(record);
		}
		return arr;
		
	}
	//게시글 삭제
	public int deleteList(String title, String writer) throws SQLException {
		try {
			con = DBUtil.getCon();
			String sql = "DELETE FROM bbs WHERE title = ? and writer = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, writer);
			int n = ps.executeUpdate();
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
