package com.memo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.memo.model.MemoVO;
import com.multi.mapper.MemoMapper;
//ºñÁî´Ï½º°èÃþ, ¼­ºñ½º °èÃþ
@Service("memoService") //memoServiceImpl <=°´Ã¼ÀÌ¸§
public class MemoServiceImpl implements MemoService {

	@Inject
	private MemoMapper memoMapper;
	
	@Override
	public int insertMemo(MemoVO vo) {
		return memoMapper.insertMemo(vo);
	}

	@Override
	public List<MemoVO> listMemo(int start, int end) {
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		return memoMapper.listMemoPaging(map);
	}
	
	public List<MemoVO> listMemoMySQL(int limit, int offset){
		Map<String, Object> map = new HashMap<>();
		map.put("limit", limit);
		map.put("offset", offset);
		return memoMapper.listMemoPaging(map);
	}

	@Override
	public MemoVO getMemo(int no) {
		return memoMapper.getMemo(no);
	}

	@Override
	public int deleteMemo(int no) {
		return memoMapper.deleteMemo(no);
	}

	@Override
	public int updateMemo(MemoVO vo) {
		return memoMapper.updateMemo(vo);
	}

	@Override
	public int getMemoTotalCount() {
		return memoMapper.getMemoTotalCount();
	}

}
