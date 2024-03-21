package com.multi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //인자 생성자
@NoArgsConstructor //기본 생성자
public class UserVO {
	private int no;
	private String name;
	private String addr;
	private String phone;
	
}
