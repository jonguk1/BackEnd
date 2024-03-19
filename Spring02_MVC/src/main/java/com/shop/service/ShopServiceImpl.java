package com.shop.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.common.util.CommonUtil;
import com.multi.mapper.CartMapper;
import com.multi.mapper.ProductMapper;
import com.shop.domain.CartVO;
import com.shop.domain.ProductVO;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

	@Inject
	private ProductMapper productMapper;
	
	@Inject
	private CartMapper cartMapper;
	
	@Inject
	private CommonUtil util;
	
	@Override
	public List<ProductVO> selectByPspec(String pspec) {
		// TODO Auto-generated method stub
		return productMapper.selectByPspec(pspec);
	}

	@Override
	public List<ProductVO> selectByCategory(int cg_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductVO selectByPnum(int pnum) {
		return productMapper.getProduct(pnum);
	}

	@Override
	public int addCart(CartVO cartVo) {
		//1. �߰��� ��ǰ�� �̹� ��ٱ��Ͽ� ����ִ� ���==> ������ ���� ==>update��
		//2. �߰��� ��ǰ�� ��ٱ��Ͽ� ���� ��� ===> insert��
		//[1] userid�� pnum���� cart���̺��� ��ٱ��� ��ȣ�� ��������
		Integer cnum = cartMapper.selectCartNum(cartVo);
		int n=0;
		if(cnum==null) {
			n=cartMapper.addCart(cartVo);
		}else {
			n=cartMapper.updateCartQty(cartVo);
		}
		return n;
	}

	@Override
	public int updateCartQty(CartVO cartVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editCart(CartVO cartVo) {
		//������ ��� => ����ó��
		//������ 0 ==> ����ó��
		//������ ���� ==> ����ó��
		int qty=cartVo.getPqty();
		if(qty >50) {
			//Runtime�迭 ���ܴ� throws�� �����ص� �ȴ�
			throw new NumberFormatException("������ 50�� �̳��θ� ���� �����մϴ�");
		}else if(qty >0) {
			return cartMapper.editCart(cartVo);	
		}else if(qty == 0) {
			return cartMapper.delCart(cartVo.getCnum());	
		}else {
			throw new NumberFormatException("������ ������ �Է��ϸ� �ȵ˴ϴ�");
		}
	}

	@Override
	public List<CartVO> selectCartView(String userid) {
		return cartMapper.selectCartView(userid);
	}

	@Override
	public int delCart(int cartNum) {
		return cartMapper.delCart(cartNum);
	}

	@Override
	public int delCartAll(CartVO cartVo) {
		return cartMapper.delCartAll(cartVo.getUserid());
	}

	@Override
	public int delCartOrder(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CartVO getCartTotal(String userid) {
		return cartMapper.getCartTotal(userid);
	}

	@Override
	public void delCartByOrder(String userid, int pnum) {
		// TODO Auto-generated method stub

	}

}
