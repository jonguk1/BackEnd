package com.user.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberVO {

	private String userid;
	private String name;
	private String pwd;
	private String hp1;
	private String hp2;
	private String hp3;
	
	private String post;
	private String addr1;
	private String addr2;
	private Date indate;
	private int mileage;
	private int mstate;//0:�Ϲ�ȸ��, -1:����ȸ��, -2:Ż��ȸ��
	private String mstateStr;
	
	
	public String getAllHp() {
		return hp1 + "-" + hp2 + "-" + hp3;
	}
	
	public String getAddr() {
		return "[" + post + "]" + addr1+" "+addr2;
	}
	
	public String getMstateStr() {
		if(mstate==0) return "�Ϲ�ȸ��";
		else if(mstate==-1) return "����ȸ��";
		else if(mstate==-2) return "Ż��ȸ��";
		else if(mstate==9) return "������";
		else return "";
	}
	
	
}
