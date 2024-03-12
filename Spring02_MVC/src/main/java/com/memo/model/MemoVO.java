package com.memo.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class MemoVO {
	@Getter @Setter
	private int no;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String msg;
	@Getter @Setter
	private Date wdate;
	
}
