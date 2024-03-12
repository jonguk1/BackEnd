package com.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.memo.model.MemoVO;
import com.memo.service.MemoService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j//log��ü ��밡��
public class MemoController {
	
	@Autowired
	private MemoService memoService;

	@RequestMapping(value = "/memo", method=RequestMethod.GET)
	public String memoForm( ) {
		
		return "memo/input";
		//servlet-context.xml�� ��ϵ� InternalResourceViewResolver����
		//����� �տ� ���ξ�("/WEB-INF/views/")�� ���̾�(.jsp)�� �ٿ��ش�
		///WEB-INF/views/memo/input.jsp
	}
	
	@RequestMapping(value = "/memo", method=RequestMethod.POST)
	public String memoInsert(Model model, MemoVO vo) {
		
		if(vo.getName() == null||vo.getName().trim().isBlank()) {
			return "redirect:memo";//redirect������� �̵� 
		}
		
		int n=this.memoService.insertMemo(vo);
		
		String msg=(n>0)?"�� ��� ����":"�۵�� ����";
		String loc=(n>0)?"memoList":"javascript:history.back()";
		
		model.addAttribute("msg",msg);
		model.addAttribute("loc",loc);
		return "message";
	}
	
	@RequestMapping(value="/memoList" , method=RequestMethod.GET)
	public String memoList(Model model) {
		//���� listMemo()ȣ��. ��ȯ�� model�� ����
		List<MemoVO> arr = memoService.listMemo();
		
		model.addAttribute("memoList",arr);
		
		return "memo/list";
	}
	
	
	
	
}
