package com.multi.posts;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class PostsServiceImpl implements PostsService {

	@Inject
	private PostsDAO pDao;
	
	@Override
	public int insertPosts(PostsVO vo) {
		// TODO Auto-generated method stub
		return pDao.insertPosts(vo);
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
