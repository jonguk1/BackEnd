package com.multi.posts;

import java.util.List;

public interface PostsService {

	int insertPosts(PostsVO vo);
	
	List<PostsVO> listsPosts();
	
	PostsVO selectPosts(String id);
	
	int deletePosts(String id);
	
	int updatePosts(PostsVO vo);
	
}
