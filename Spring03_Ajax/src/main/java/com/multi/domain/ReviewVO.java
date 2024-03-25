package com.multi.domain;

import lombok.Data;

@Data
public class ReviewVO {
	
	private int no;
	private String userid;
	private int num;
	private int pnum;
	
	private String title;
	private String content;
	private int score;
	private String filename;
	
	private java.sql.Date wdate;
}
