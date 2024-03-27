package com.shop.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.memo.model.MemoVO;
import com.multi.mapper.SampleMapper1;
import com.multi.mapper.SampleMapper2;
import com.user.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SampleTxServiceImpl implements SampleTxService {

	@Inject
	private SampleMapper1 mapper1;//Memo����
	
	@Inject
	private SampleMapper2 mapper2;//Member����
	
	@Transactional(rollbackFor = {RuntimeException.class,SQLException.class})
	@Override
	public void addMemo(MemoVO vo, MemberVO user) {
		// TODO Auto-generated method stub
		log.info("mapper2 ���ϸ��� ����------------------------");
		log.info("user: " + user);
		mapper2.updateMemberMileage(user);
		
		log.info("mapper1 �޸�� ���-------------------------");
		log.info("memo: " + vo);
		mapper1.insertMemo(vo);
		
	}

}
