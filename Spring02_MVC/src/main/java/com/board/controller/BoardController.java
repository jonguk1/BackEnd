package com.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
			/* for(int i =0;i<20;i++) */
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
	public String boardList(Model m, PagingVO page, HttpServletRequest req) {
		log.info("page1: " + page);
		//1.�� �Խñ� �� ��������
		int totalCount = bService.getTotalCount(page);
		
		page.setTotalCount(totalCount);//�Խñ� ��
		page.setOneRecordPage(5);//�� �������� ������ ��� ����
		page.setPagingBlock(5);//����¡ �� ������ ����
		
		page.init();//����¡ ó������ ������ �����ϴ� �޼��� ȣ��
		log.info("page2: " + page);
		
		//2.�Խñ� ��� ��������
		List<BoardVO> arr = bService.getBoardAll(page);
		
		//3.����¡ �׺���̼� ���ڿ� �޾ƿ���
		String myctx=req.getContextPath();
		String loc ="board/list";
		
		String pageNavi=page.getPageNavi(myctx, loc);
		
		m.addAttribute("boardList",arr);
		m.addAttribute("totalCount",totalCount);
		m.addAttribute("page",page);
		m.addAttribute("pageNavi",pageNavi);
		
		//return "board/boardList";
		return "board/boardList2";
	}
	
	@GetMapping("/board/view/{num}")
	public String boardView(Model m, @PathVariable("num") int num) {
		log.info("num: " + num);
		//1. ��ȸ�� ����
		bService.updateReadnum(num);
		
		//2. �� ��ȣ�� �� ���� ��������
		BoardVO board=bService.selectBoardByNum(num);
		
		m.addAttribute("vo",board);
		
		return "board/boardView";
	}
	
	
	//�亯 �۾���
	@PostMapping("/user/rewrite")
	public String boardRewriteForm(Model m, BoardVO vo) {
		log.info("vo: " + vo);
		m.addAttribute("vo",vo);
		return "board/boardRewrite";
	}
	
	@PostMapping("/user/edit")
    public String boardEditForm(Model m,BoardVO vo) {
        log.info("vo: "+vo);
        if(vo.getNum()==0||vo.getPasswd()==null) {
            return "redirect:/campus/board/list";
        }
        BoardVO dbVo=this.bService.selectBoardByNum(vo.getNum());
        if(dbVo==null) {
            return util.addMsgBack(m, "�ش� ���� �����");
        }
        //��� üũ
        if(!dbVo.getPasswd().equals(vo.getPasswd())) {
            return util.addMsgBack(m, "��й�ȣ�� ��ġ���� �ʾƿ�");
        }
        m.addAttribute("vo",dbVo);
        return "board/boardEdit";
    }//--------------------------------------
    
    @PostMapping("/user/delete")
    public String boardDelete(Model m,@RequestParam(defaultValue="0") int num,
            @RequestParam(defaultValue = "") String passwd, HttpSession session) {
        log.info("num: "+num+", passwd: "+passwd);
        if(num==0||passwd.isEmpty()) {
            return "redirect:../board/list";
        }
        //�ش� ���� DB���� ��������
        BoardVO vo=this.bService.selectBoardByNum(num);
        //��й�ȣ üũ
        String dbPasswd=vo.getPasswd();
        if(!dbPasswd.equals(passwd)) {
            return util.addMsgBack(m, "��й�ȣ�� ��ġ���� �ʾƿ�");
        }
        //db���� �� ����ó��
        int n=bService.deleteBoard(num);
        
        String upDir=session.getServletContext().getRealPath("/resources/board_upload");
        
        //������ ÷���� ������ �ִٸ� �������� ���� ó��
        if(n>0 && vo.getFilename()!=null) {
            File f=new File(upDir, vo.getFilename());
            if(f.exists()) {
                boolean b=f.delete();
                log.info("���� ���� ����: "+ b);
            }
        }
        
        String str=(n>0)? "���� ����":"���� ����";
        String loc=(n>0)?"../board/list":"javascript:history.back()";
        return util.addMsgLoc(m, str, loc);
    }//-----------------------------------
	
	
}
