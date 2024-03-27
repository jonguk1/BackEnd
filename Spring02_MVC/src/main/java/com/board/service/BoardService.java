package com.board.service;

import java.util.List;

import com.board.domain.BoardVO;
import com.board.domain.PagingVO;

public interface BoardService {
	
	int insertBoard(BoardVO board);
	// 게시목록 가져오기

	List<BoardVO> getBoardAll(PagingVO paging);

	int getTotalCount(PagingVO paging);//검색한 총 게시글 수 가져오기

	// 글번호에 해당하는 글 가져오기
	BoardVO selectBoardByNum(int num);   
	// 조회수 증가하기
	int updateReadnum(int num);
	   
	
	int deleteBoard(int num);
	int updateBoard(BoardVO board);

	// 답변형(계층형) 게시판에서 답변글 달기
	int rewriteBoard(BoardVO board); //[답변형]
	BoardVO selectRefLevSunbun(int num);//[답변형]
	int updateSunbun(BoardVO parent);//[답변형]
}
