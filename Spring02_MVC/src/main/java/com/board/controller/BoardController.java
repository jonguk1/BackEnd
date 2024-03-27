package com.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.board.domain.BoardVO;
import com.board.domain.PagingVO;
import com.board.service.BoardService;
import com.common.util.CommonUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
public class BoardController {

	public final CommonUtil util;
	
	public final BoardService bService;
	
	@GetMapping("/board/write")
	public String boardForm() {
		return "board/boardWrite";
	}
	
	@PostMapping("/user/write")
	public String boardInsert(Model m,BoardVO vo,
			@RequestParam("mfilename") MultipartFile mfilename, HttpSession ses) {
		
		log.info("vo: " +vo);
		//0 ��ȿ�� üũ (userid,passwd)
		if(vo.getUserid() == null || vo.getPasswd()== null||
				vo.getUserid().trim().isBlank() || vo.getPasswd().trim().isBlank()) {
			return "redirect:../board/write";
		}
		
		//1.���� ���ε� ó��
	    ServletContext app = ses.getServletContext();
		String upDir= app.getRealPath("/resources/board_upload");
		log.info("upDir: " + upDir);
		
		File dir = new File(upDir);
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		if(!mfilename.isEmpty()) {
			String fname=mfilename.getOriginalFilename();
			long fsize=mfilename.getSize();//÷������ ũ��
			UUID uuid = UUID.randomUUID();
			String filename=uuid.toString()+"_"+ fname;//������ ���ϸ�
			log.info("fname: " + fname);
			log.info("filename: " + filename);
			
			vo.setFilename(filename);
			vo.setOriginFilename(fname);
			vo.setFilesize(fsize);
			
			//���ε� ó��
			try {
				mfilename.transferTo(new File(upDir,filename));
			}catch(IOException e) {
				log.error("���� ���ε� ����: "+e);
			}
			
		}
		
		int n=0;
		String msg="�׽�Ʈ";
		String loc= "../board/list";
		
		if("write".equals(vo.getMode())) {
			n=bService	.insertBoard(vo);
			msg="�۾��� ";
		}else if("edit".equals(vo.getMode())) {
			n=bService.updateBoard(vo);
			msg="�ۼ��� ";
		}else if ("rewrite".equals(vo.getMode())) {
			n=bService.rewriteBoard(vo);
			msg="��� ���� ";
		}
		msg+=(n>0)?"����":"����";
		if(n<=0) {
			loc="javascript:history.back()";
		}
		
		return util.addMsgLoc(m, msg, loc);
	}
	
	@GetMapping("/board/list")
	public String boardList(Model m, PagingVO page) {
		//1.�� �Խñ� �� ��������
		int totalCount = bService.getTotalCount(null);
		
		//2.�Խñ� ��� ��������
		List<BoardVO> arr = bService.getBoardAll(page);
		
		m.addAttribute("boardList",arr);
		m.addAttribute("totalCount",totalCount);
		
		return "board/boardList";
	}
	
}
