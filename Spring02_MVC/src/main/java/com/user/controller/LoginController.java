package com.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.common.exception.NotUserException;
import com.common.util.CommonUtil;
import com.user.domain.MemberVO;
import com.user.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor //=>������ ����
public class LoginController {

	public final MemberService mService;
	public final CommonUtil util;
	
	@GetMapping("/login")
	public String loginForm() {
		
		return "member/login";
	}
	
	@PostMapping("/login")
	public String loginEnd(Model m, HttpSession session, 
			MemberVO tmpUser, boolean saveId, HttpServletResponse response) 
	throws NotUserException
	{
		log.info("tmpUser: " + tmpUser);
		log.info("saveId: " + saveId);//���̵� ���� üũ�ڽ���
		if(tmpUser.getUserid() ==null || tmpUser.getPwd()==null
				||tmpUser.getUserid().trim().isBlank()
				||tmpUser.getPwd().trim().isBlank()
				) {
			return util.addMsgBack(m, "���̵�� ��й�ȣ�� ��� �Է��ؾ� �ؿ�");
		}
		
		MemberVO loginUser= mService.loginCheck(tmpUser);
		//���̵�, ����� ��ġ���� ������ NotUserException�� �߻��Ѵ�
		if(loginUser!=null) {
			session.setAttribute("loginUser", loginUser);
			Cookie ck = new Cookie("uid", loginUser.getUserid());//key, value
			if(saveId) {
				ck.setMaxAge(7*24*60*60);
			}else {
				ck.setMaxAge(0);
			}
			ck.setPath("/");
			//���� ��ü�� ��Ű ���� �ֱ�
			response.addCookie(ck);
			
		}
		return "redirect:index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//���Ǻ��� ��� ��ȿȭ
		session.invalidate();
		
		return "redirect:index";
		
	}
	
	
	
}
