package com.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.common.util.CommonUtil;
import com.shop.domain.CategoryVO;
import com.shop.domain.ProductVO;
import com.shop.service.AdminService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin")
public class AdminController {

	@Inject
	private CommonUtil util;
	
	@Inject
	private AdminService adminService;
	
	@GetMapping("prodForm")
	public String productForm(Model m) {
		
		List<CategoryVO> upCgList = adminService.getUpcategory();
		m.addAttribute("upCgList",upCgList);
		
		return "admin/prodInput";
	}
	
	@GetMapping("/downCgList")
	public String getDownCategory(Model m, int upCg_code) {
		log.info("upCg_code" + upCg_code);
		
		List<CategoryVO> cgList = adminService.getDowncategory(upCg_code);
		m.addAttribute("cgList",cgList);
		
		return "admin/downCategory";
	}
	
	@GetMapping(value="/downCgListJSON",produces = {"application/json;charset=UTF-8"})//produces�� ������ ������ ����ƮŸ���� ����
	@ResponseBody //������� ��ȯ�ϴ� ���� �ƴ϶� ���� �����͸� ��ȯ�Ѵٴ� �ǹ̷� �ٿ�����
	public List<CategoryVO> getDownCategoryJSON(int upCg_code) {
		log.info("upCg_code" + upCg_code);
		
		List<CategoryVO> cgList = adminService.getDowncategory(upCg_code);
		
		return cgList;
	}
	
	//servlet-context.xml�� multipartResolver�� ����ؾ� ��
	@PostMapping("/prodInsert")
	public String productInsert(Model m, ProductVO item,
			@RequestParam("pimage") List<MultipartFile> pimage,
			@RequestParam(value="mode",defaultValue = "insert") String mode,
			HttpServletRequest req) {
		log.info("mode: "+mode);
		log.info("item: " + item);
		log.info("pimage: " + pimage);
		//1. ���ε��� ���丮�� ������ ���
		ServletContext app=req.getServletContext();
		String upDir=app.getRealPath("/resources/product_images");
		log.info("upDir: " + upDir);
		
		//2. ���� ���ε� ó��=> MultipartFile�� transferTo(File��ü)�޼��带 �̿�
		if(pimage!=null) {
			for(int i=0;i<pimage.size();i++) {
				MultipartFile mf = pimage.get(i);
				if(!mf.isEmpty()) {//���ε��ߴٸ�
					try {
						String fileName=mf.getOriginalFilename();//÷�����ϸ�
						mf.transferTo(new File(upDir,fileName));//���ε� ó��
						//3. ���ε��� ���ϸ��� ProductVO�� pimage1,pimage2,pimage3�� setting
						if(i==0) {
							item.setPimage1(fileName);
						}else if(i==1) {
							item.setPimage2(fileName);
						}else if(i==2){
							item.setPimage3(fileName);
						}
						
					}catch(IOException e) {
						log.error("���� ���ε� �� ����: " + e);
					}
				}
			}
		}
		log.info("item2: " + item);
		
		int n=0;
		if(mode.equals("insert")) {
			n=adminService.productInsert(item);//��� ó��
		}else if(mode.equals("edit")) {
			n=adminService.productUpdate(item);//���� ó��
		}
		
		String msg = (n>0)?"����":"����";
		String loc = (n>0)?"prodList":"javascript:history.back()";
		return util.addMsgLoc(m, msg, loc);
	}
	
	@GetMapping("/prodList")
	public String productList(Model m) {
		
		List<ProductVO> itemList = adminService.productList();
		m.addAttribute("itemList",itemList);
		
		return "admin/prodList";
	}
	
	@PostMapping("/prodDel")
	public String productDelete(Model m,@RequestParam(defaultValue = "0") int pnum) {
		if(pnum == 0) {
			return "redirect:prodList";
		}
		adminService.productDelete(pnum);
		
		return "redirect:prodList";
	}
	
	@PostMapping("/prodEditForm")
	public String prodEditForm(Model m,@RequestParam(defaultValue = "0")  int pnum) {
		log.info("pnum" + pnum);
		if(pnum==0) {
			return "redirect:prodList";
		}
		
		List<CategoryVO> upCgList = adminService.getUpcategory();
		ProductVO item = adminService.getProduct(pnum);
		
		m.addAttribute("item",item);
		m.addAttribute("upCgList",upCgList);
		
		return "admin/prodEdit";
	}
	
	
	
	
	
	
}
