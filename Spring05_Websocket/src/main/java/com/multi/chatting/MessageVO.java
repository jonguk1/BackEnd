package com.multi.chatting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//�����͸� �����Ҷ� MessageVO�� ��� �޴´�
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageVO {
	
	private String from;//������ ��
	private String to;//�޴� ��
	private String text;//��ȭ����
	private String mode;//all one
}
