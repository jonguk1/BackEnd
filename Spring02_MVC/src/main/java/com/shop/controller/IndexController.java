package com.shop.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.domain.ProductVO;
import com.shop.service.ShopService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class IndexController {

	@Resource(name="shopService") // ��ü �̸����� �����Ѵ�
	private ShopService shopService;
	
	//�޼��尡 ������� ��ȯ���� �ʴ´ٸ�(void) =>@RequestMapping()�� ��ϵ� url-pattern "/index"
	//�� ������� �ȴ�
	@RequestMapping("/index")
	public void showIndex(Model m) {	
		List<ProductVO> newItems = shopService.selectByPspec("NEW");
		//log.info("NEW��ǰ: " + newItems.size() + "��");
		
		List<ProductVO> hitItems= shopService.selectByPspec("HIT");
		//log.info("HIT��ǰ: " + hitItems.size() + "��");
		
		m.addAttribute("hitItems",hitItems);
		m.addAttribute("newItems",newItems);
		// "/WEB-INF/views/index.jsp"
	}
	
	@GetMapping("/prodDetail")
	public String productDetail(Model m, @RequestParam(defaultValue = "0") int pnum) {
		if(pnum==0) {
			return "redirect:index";
		}

		ProductVO item = shopService.selectByPnum(pnum);
		
		m.addAttribute("item",item);
		
		return "shop/prodDetail";
	}
	
}
