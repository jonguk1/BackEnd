package user.model;
/*
 * SqlSession : DB관련한 crud 관련한 메서드를 가지고 있다
 * # Factory Pattern
 * [1] SqlSessionFactoryBuilder 를 통해 공장을 짓고(설계도 참조-mybatis-config.xml)
 * [2] SqlSessionFactory 가 생성되면 공장을 통해 SQLSession(제품)을 얻는다
 * */

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAOMyBatis {

	//Namespace : 어떤 mapper를 사용할 지 네임스페이스 보고 찾는다 (네임스페이스 지정 필수)
	private final String NS="user.model.MemberMapper";
	
	private SqlSession ses;//제품, 공장에서 만들어짐
	
	public SqlSessionFactory getSessionFactory() {
		String resource="common/config/mybatis-config.xml";//설계도 파일
		InputStream is = null;
		try {
		is=Resources.getResourceAsStream(resource);
		//설계도 파일을 읽을 수 있는 스트림 얻기
		}catch(IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();//건축가
		SqlSessionFactory factory = builder.build(is);//공장을 짓는다
		return factory;
	}
	
	public int getMemberCount() {
		try {
			ses = this.getSessionFactory().openSession();//수동 커밋
			int count = ses.selectOne(NS+".userCount");
			return count;
		}finally{
			if(ses!=null) ses.close();
		}
	}///////////

	public int insertMember(MemberVO user) {
		try {
			//ses=this.getSessionFactory().openSession();//수동 커밋
			ses=this.getSessionFactory().openSession(true);//자동 커밋<=true
			int n=ses.insert(NS+".insertMember", user);
			/*//수동 커밋일떄 트랜잭션 처리
			 * if(n>0) { ses.commit(); }else { ses.rollback(); }
			 */
			return n;
			
		} finally {
			close();
		}
	}//----------------

	private void close() {
		if(ses!=null) ses.close();
	}

	public List<MemberVO> listMember(int start,int end) {
		try {
			Map<String,Object> map = new HashMap<>();
			map.put("start", start);//Integer객체
			map.put("end", end);
			
			ses=this.getSessionFactory().openSession(true);
			List<MemberVO> arr =ses.selectList(NS + ".listMember",map);
			
			return arr;
		} finally {
			close();
		}
	}

	public int deleteMember(String id) {
		try {
			ses = this.getSessionFactory().openSession(true);
			int n = ses.delete(NS+".deleteMember",id );
			
			return n;
		} finally {
			close();
		}
	}

	public MemberVO getMember(String id) {
		try {
			ses= this.getSessionFactory().openSession(true);
			MemberVO user = ses.selectOne(NS+".getMember",id);
			return user;
		} finally {
			close();
		}
	}

	public int updateMember(MemberVO user) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n =ses.update(NS+".updateMember",user);
			return n;
		} finally {
			close();
		}
	}

	public boolean idCheck(String id) {
		try {
			ses=this.getSessionFactory().openSession();
			int cnt=ses.selectOne(NS+".idCheck",id);
			return (cnt==1) ? false:true;
		}finally {
			close();
		}
	}
	
}////////////
