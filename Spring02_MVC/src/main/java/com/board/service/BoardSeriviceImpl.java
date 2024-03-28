package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.board.domain.BoardVO;
import com.board.domain.PagingVO;
import com.multi.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
@Service("boardService")
@RequiredArgsConstructor
@Log4j
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
		return bmapper.selectBoardByNum(num);
	}

	@Override
	public int updateReadnum(int num) {
		// TODO Auto-generated method stub
		return bmapper.updateReadnum(num);
	}

	@Override
	public int deleteBoard(int num) {
		// TODO Auto-generated method stub
		return bmapper.deleteBoard(num);
	}

	@Override
	public int updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return bmapper.updateBoard(board);
	}

	//�亯 �۾���
	@Override
	public int rewriteBoard(BoardVO board) {
		//[1] �θ���� �۹�ȣ(num)�� �θ���� refer(�۱׷��ȣ), lev(�亯����), sunbun(����) �������� ==>select��
		BoardVO parent = this.selectRefLevSunbun(board.getNum());
		log.info("parent: " + parent);
		//[2] ������ �޸� �亯�۵��� �ִٸ�, �� �亯���� insert�ϱ� ���� ���� �亯�۵��� sunbun�� �ϳ��� ������Ű��
		this.updateSunbun(parent);
		
		//[3] ���� �� �亯 ���� insert�Ѵ� ==> insert��
		//���� �� �亯��==> board
		//�θ�� ==> parent (�θ�� refer, lev, sunbun)
		board.setRefer(parent.getRefer());//�θ���� �۱׷��ȣ�� �����ϰ�
		board.setLev(parent.getLev()+1);//�亯����=�θ�lev+1
		board.setSunbun(parent.getSunbun()+1);//����=�θ�sunbun+1
		
		return bmapper.rewriteBoard(board);
	}

	@Override
	public BoardVO selectRefLevSunbun(int num) {
		return bmapper.selectRefLevSunbun(num);
	}

	@Override
	public int updateSunbun(BoardVO parent) {
		return bmapper.updateBoard(parent);
	}

}
