package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.board.domain.BoardVO;
import com.board.domain.PagingVO;
import com.multi.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
@Service("boardService")
@RequiredArgsConstructor
public class BoardSeriviceImpl implements BoardService {

	private final BoardMapper bmapper;
	
	@Override
	public int insertBoard(BoardVO board) {
		return bmapper.insertBoard(board);
	}

	@Override
	public List<BoardVO> getBoardAll(PagingVO paging) {
		// TODO Auto-generated method stub
		return bmapper.getBoardAll(paging);
	}

	@Override
	public int getTotalCount(PagingVO paging) {
		// TODO Auto-generated method stub
		return bmapper.getTotalCount(paging);
	}

	@Override
	public BoardVO selectBoardByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReadnum(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rewriteBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO selectRefLevSunbun(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateSunbun(BoardVO parent) {
		// TODO Auto-generated method stub
		return 0;
	}

}
