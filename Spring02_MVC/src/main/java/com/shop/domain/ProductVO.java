package com.shop.domain;

import lombok.Data;

@Data
public class ProductVO {

	private int upCg_code;
	private String upCg_name;
	
	private int downCg_code;
	private String downCg_name;
	
	private int pnum;
	private String pname;
	private String pimage1;
	private String pimage2;
	private String pimage3;
	
	private int price;
	private int saleprice;
	private int point;
	private int pqty;
	
	private String pspec;//HIT, NEW, BEST
	private String pcontents;
	private String pcompany;
	
	private int totalPrice;//���ǸŰ� =�ǸŰ�*����
	private int totalPoint;//������Ʈ =����Ʈ*����
	
	//�ֹ������� �������� ���ǸŰ�, ������Ʈ�� ��������
	public void setPqty(int pqty) {
		this.pqty = pqty;
		this.totalPrice = this.saleprice * this.pqty;
		this.totalPoint = this.point * this.pqty;
	}
	
	//������
	public int getPercent() {
		int percent=(price-saleprice)*100/price;
		return percent;
	}
	
	
	
	
	
}
