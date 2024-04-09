package com.multi.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository(value="postsDAOImpl")
public class PostsDaoImpl implements PostsDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public int insertPosts(PostsVO vo) {
		
		PostsVO tmp=mongoTemplate.insert(vo,"posts");
		System.out.println("tmp: " + tmp);
		return (tmp==null)?0:1;
	}

	@Override
	public List<PostsVO> listsPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostsVO selectPosts(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePosts(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePosts(PostsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
