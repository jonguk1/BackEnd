package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.util.CommonUtil;
import com.user.domain.MemberVO;
import com.user.service.MemberService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MemberController {

	@Autowired //byType
	private CommonUtil util;
	
	@Autowired
	private MemberService mService;
	
	@GetMapping("/signup")
	public String joinForm() {
		
		return "member/join";
	}
	
	@PostMapping("/signup")
	public String joinEnd(Model m, MemberVO user) {
		log.info("user"+user);
		//��ȿ�� üũ
		if(user.getUserid()==null||user.getName()==null
				||user.getUserid().trim().isBlank()
				||user.getName().trim().isBlank()) {
			return "redirect:signup";
		}
		int n=mService.insertMember(user);
		
		String msg=(n>0)?"ȸ������ �Ϸ�-�α��� �ϼ���!":"ȸ������ ����- ���̵� �ߺ�üũ �ϼ���";
		String loc=(n>0)?"index":"javascript:history.back()";
		return util.addMsgLoc(m, msg, loc);
	}
	
	//@GetMapping("/idCheck"),  @PostMapping("/idCheck")
	@GetMapping("/idCheck")
	public String idCheck() {
		return "member/idCheck";
	}
	
	@PostMapping("/idCheck")
	public String idCheckEnd(Model m, @RequestParam("id") String id) {
		if(id ==null || id.trim().isBlank()) {
			String msg="���̵� �Է��ϼ���";
			return util.addMsgBack(m, msg);
		}
		
		log.info("id: " + id);
		
		boolean isUse = mService.idCheck(id);
		
		String msg= (isUse)?id+"�� ��� �����մϴ�": id+"�� �̹� ����� �Դϴ�";
		String result= (isUse)?"ok":"fail";
		
		m.addAttribute("msg",msg);
		m.addAttribute("result",result);
		m.addAttribute("uid",id);
		
		return "member/idCheckResult";
		
	}
	
	
}
