package com.multi.mapper;

import java.util.List;

import com.multi.domain.ReviewVO;

public interface ReviewMapper {
	
	int insertReview(ReviewVO rvo);
	
	List<ReviewVO> getReviewList(int pnum);//Ư����ǰ�� ���� ����۸��
	int getReviewCount(int pnum);
	
	ReviewVO getReview(int no);//����۹�ȣ(PK)�� ��ǰ�� ��������
	int deleteReview(int no);
	int updateReview(ReviewVO rvo);
}
