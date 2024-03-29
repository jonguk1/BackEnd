package com.memo.service;

import java.util.List;

import com.memo.model.MemoVO;

public interface MemoService {

	int insertMemo(MemoVO vo);//C
	
	List<MemoVO> listMemo(int start, int end);//R oracle일 경우
	
	List<MemoVO> listMemoMySQL(int limit, int offset);//mySQL일 경우
	
	MemoVO getMemo(int no);//R
	
	int deleteMemo(int no);//D
	
	int updateMemo(MemoVO vo);//U

	int getMemoTotalCount();
}
