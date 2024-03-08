package common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.mapper.SampleMapper;

@Controller
public class SampleController {
	
	@Autowired
	private SampleMapper sampleMapper;
	//SampleMapper를 구현한 객체==>스프링이 알아서 함==>@Autowired 어노테이션을 붙이면 	
	//스프링이 알아서 해당 객체를 주입해준다 ==> DI(Dependency Injection)
	
	@RequestMapping("/sample.do")
	public String testMyBatis(Model model) {
		System.out.println("sampleMapper: " + sampleMapper);
		
		int tableCount=sampleMapper.testCnt();
		
		model.addAttribute("msg", "scott계정의 테이블 수를 알아봅시다");
		model.addAttribute("tableCount", tableCount);
		
		return "sample";
	}
}
