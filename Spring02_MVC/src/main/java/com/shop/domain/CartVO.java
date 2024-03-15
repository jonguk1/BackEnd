package com.shop.domain;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class CartVO {

	private int cnum;//��ٱ��� ��ȣ
	private String userid;//ȸ�����̵�(fk)
	private int pnum;//��ǰ��ȣ(fk)
	private int pqty;//���� (1~50�� ������ ����)
	private Date cdate;//��ٱ��� ���� ��¥
	
	//��ٱ��Ͽ� ��� ��ǰ����
	private List<ProductVO> items;
	
	private int cartTotalPrice;//��ٱ��Ͽ� ��� ��� ��ǰ�� �ѱݾ�
	private int cartTotalPoint;//������Ʈ
	
	//private String pname;
	//private String pimage1;
	//private int price;
	//private int saleprice;
	//private int point;
	
}
