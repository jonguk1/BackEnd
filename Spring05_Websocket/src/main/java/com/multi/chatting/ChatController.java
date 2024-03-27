package com.multi.chatting;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ChatController {

	@GetMapping("/chatForm")
	public String chatForm() {
		
		return "webChat/chatUI";
	}
	
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessageVO send(MessageVO vo) {
		//log.info("������ ���� ����=>"+ vo.toString());
		System.out.println("������ ���� ����11=>"+ vo.toString());

		OutputMessageVO message=new OutputMessageVO("server","client","������ ������ �޽���","");
		return message;
	}
}
