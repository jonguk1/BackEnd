package com.memo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.memo.model.MemoVO;
import com.multi.mapper.MemoMapper;
//비즈니스계층, 서비스 계층
@Service("memoService") //memoServiceImpl <=객체이름
public class MemoServiceImpl implements MemoService {

	@Inject
	private MemoMapper memoMapper;
	
	@Override
	public int insertMemo(MemoVO vo) {
		return memoMapper.insertMemo(vo);
	}

	@Override
	public List<MemoVO> listMemo() {
		return memoMapper.listMemo();
	}

	@Override
	public MemoVO getMemo(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMemo(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMemo(MemoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
