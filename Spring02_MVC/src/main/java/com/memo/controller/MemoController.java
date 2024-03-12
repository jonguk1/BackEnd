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
@Log4j//log객체 사용가능
public class MemoController {
	
	@Autowired
	private MemoService memoService;

	@RequestMapping(value = "/memo", method=RequestMethod.GET)
	public String memoForm( ) {
		
		return "memo/input";
		//servlet-context.xml에 등록된 InternalResourceViewResolver빈이
		//뷰네임 앞에 접두어("/WEB-INF/views/")와 접미어(.jsp)를 붙여준다
		///WEB-INF/views/memo/input.jsp
	}
	
	@RequestMapping(value = "/memo", method=RequestMethod.POST)
	public String memoInsert(Model model, MemoVO vo) {
		
		if(vo.getName() == null||vo.getName().trim().isBlank()) {
			return "redirect:memo";//redirect방식으로 이동 
		}
		
		int n=this.memoService.insertMemo(vo);
		
		String msg=(n>0)?"글 등록 성공":"글등록 실패";
		String loc=(n>0)?"memoList":"javascript:history.back()";
		
		model.addAttribute("msg",msg);
		model.addAttribute("loc",loc);
		return "message";
	}
	
	@RequestMapping(value="/memoList" , method=RequestMethod.GET)
	public String memoList(Model model) {
		//서비스 listMemo()호출. 반환값 model에 저장
		List<MemoVO> arr = memoService.listMemo();
		
		model.addAttribute("memoList",arr);
		
		return "memo/list";
	}
	
	
	
	
}
