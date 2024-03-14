package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.domain.CategoryVO;
import com.shop.domain.ProductVO;

@Mapper
public interface ProductMapper {
	//���� ī�װ� ��� ��������
	List<CategoryVO> getUpCategory();
	//���� ī�װ� ��� ��������
	List<CategoryVO> getDownCategory(int upCg_code);
	//��ǰ ���� ���
	int productInsert(ProductVO prod);
	//��ǰ���
	List<ProductVO> productList();
	//��ǰ ����
	int productDelete(int pnum);
	
}
