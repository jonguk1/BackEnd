package com.multi.chatting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputMessageVO {

	private String from;//������ ��
	private String to;//�޴���
	private String text;//��ȭ����
	private String time;//������ �ð�
}
