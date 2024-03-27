package com.board.service;

import java.util.List;

import com.board.domain.BoardVO;
import com.board.domain.PagingVO;

public interface BoardService {
	
	int insertBoard(BoardVO board);
	// �Խø�� ��������

	List<BoardVO> getBoardAll(PagingVO paging);

	int getTotalCount(PagingVO paging);//�˻��� �� �Խñ� �� ��������

	// �۹�ȣ�� �ش��ϴ� �� ��������
	BoardVO selectBoardByNum(int num);   
	// ��ȸ�� �����ϱ�
	int updateReadnum(int num);
	   
	
	int deleteBoard(int num);
	int updateBoard(BoardVO board);

	// �亯��(������) �Խ��ǿ��� �亯�� �ޱ�
	int rewriteBoard(BoardVO board); //[�亯��]
	BoardVO selectRefLevSunbun(int num);//[�亯��]
	int updateSunbun(BoardVO parent);//[�亯��]
}
