package com.multi.posts;

import java.util.List;

public interface PostsDAO {

	int insertPosts(PostsVO vo);
	
	List<PostsVO> listsPosts();
	
	PostsVO selectPosts(String id);
	
	int deletePosts(String id);
	
	int updatePosts(PostsVO vo);
}
