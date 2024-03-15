package com.shop.service;

import java.util.List;
import java.util.Map;

import com.shop.domain.CartVO;
import com.shop.domain.ProductVO;

public interface ShopService {
	/*Pspec ���� ��ǰ ���� ��������*/
	public List<ProductVO> selectByPspec(String pspec);
	/*ī�װ��� ��ǰ���� ��������*/
	public List<ProductVO> selectByCategory(int cg_num);
	/**��ǰ��ȣ�� Ư�� ��ǰ ���� ��������*/
	public ProductVO selectByPnum(int pnum);
	
	/**��ٱ��� ���� �޼ҵ�===============*/
	int addCart(CartVO cartVo);//��ٱ��� �߰��ϱ�
	int updateCartQty(CartVO cartVo);//��ٱ��� �߰� ����=>������ ��� ��ǰ�̸� ������ �����ϱ�
	int editCart(CartVO cartVo);// ��ٱ��� �����ϱ�
	List<CartVO> selectCartView(String userid);//Ư�� ȸ���� ��ٱ��� ��Ϻ���
	
	int delCart(int cartNum);
	int delCartAll(CartVO cartVo);
	int delCartOrder(Map<String,Integer>map);
	
	CartVO getCartTotal(String userid);//Ư�� ȸ���� ��ٱ��� �Ѿ�,������Ʈ ���ϱ�

	public void delCartByOrder(String userid, int pnum);
}
