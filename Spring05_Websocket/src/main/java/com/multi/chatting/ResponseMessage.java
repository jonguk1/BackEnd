package com.multi.chatting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ê������ ���� �޽����� ���۵� ��ä
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {

	private String from;
	private String text;
	private String menu;
	private String time;
	
}
