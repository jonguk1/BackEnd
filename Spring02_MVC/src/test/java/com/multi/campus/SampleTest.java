package com.multi.campus;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.multi.mapper.SampleMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTest {
	
	@Resource(name="dataSource-dbcp")
	private DataSource ds;
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private SampleMapper mapper;
	
	@Test
	public void testConnection() {
		System.out.println("ds��� ����: "+ ds);
		try (Connection con = ds.getConnection()){
			System.out.println("con��� ����: " + con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSqlSessionTemplate() {
		System.out.println("sqlSessionTemplate����: " + sqlSession);
	}//------------

	@Test
	public void testSampleMapper() {
		int cnt= mapper.getMemberCount();
		System.out.println("java_memberȸ����: " + cnt);
	}
	
	@Test
	public void testMemberNames() {
		List<String> names =mapper.getMemberNames();
		System.out.println("java_member names: " + names);
	}
	
}
