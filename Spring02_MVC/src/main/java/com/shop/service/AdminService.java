package com.shop.service;

import java.util.List;

import com.shop.domain.CategoryVO;
import com.shop.domain.ProductVO;

public interface AdminService {
	/** [������ ���]- ī�װ� ���� */
	public List<CategoryVO> getUpcategory();

	public List<CategoryVO> getDowncategory(int upCg_code);

	public int categoryAdd(CategoryVO cvo);

	public int categoryDelete(int cg_code);

	/** [������ ���]- ��ǰ ���� ����ϱ� */
	public int productInsert(ProductVO prod);

	public List<ProductVO> productList();

	public ProductVO getProduct(int pnum);
	
	public int productUpdate(ProductVO prod);
	
	public int productDelete(int pnum);
}
