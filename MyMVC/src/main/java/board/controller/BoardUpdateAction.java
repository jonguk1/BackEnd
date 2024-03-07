package board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class BoardUpdateAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//0. 파일 업로드 처리
		String upDir=req.getServletContext().getRealPath("/upload");
		System.out.println("upDir: "+upDir);
		
		MultipartRequest mreq=new MultipartRequest(req,
				upDir,100*1024*1024,"utf-8",new DefaultFileRenamePolicy());
		
		//1. 글번호,제목,작성자,내용, 비번, 첨부파일 받기
		String numStr=mreq.getParameter("num");
		String name=mreq.getParameter("name");
		String passwd=mreq.getParameter("passwd");
		String title=mreq.getParameter("title");
		String content=mreq.getParameter("content");
		String old_fileName=mreq.getParameter("old_fileName");//예전 첨부파일명
		
		//첨부파일명,파일크기 받기 => 나중에
		String fileName=mreq.getFilesystemName("fileName");//새로 첨부하는 파일명
		long fileSize=0;
		File file=mreq.getFile("fileName");
		if(file!=null) {
			fileSize=file.length();
		}
		
		//2. 유효성 체크
		if(numStr==null||name==null||passwd==null||title==null||name.trim().isBlank()
				||passwd.trim().isBlank() || title.trim().isBlank()) {
			this.setRedirect(true);
			this.setViewName("update.do");//update.do로 redirect이동
			return;
		}
		int num=Integer.parseInt(numStr.trim());
		
		//3. 1번에서 받은 값을 BoardVO에 담기
		BoardVO vo=new BoardVO(num,name,passwd,title,content,null,0,fileName,fileSize);
		//4. BoardDAO의 updateBoard(vo) 호출
		BoardDAO dao=new BoardDAO();
		int n=dao.updateBoard(vo);
		
		//4_2.새파일을 업로드 했다면=> 예전에 업로드 했던 파일은 서버에서 지우자
		if(fileName!=null&& old_fileName!=null) {
			File delFile=new File(upDir, old_fileName);
			if(delFile.exists()) {
				boolean b=delFile.delete();
				System.out.println("옛파일 삭제 여부: "+b);
			}
		}
		//5. 그 결과 메시지,이동경로 처리
		String msg=(n>0)?"글수정 성공":"글수정 실패";
		String loc=(n>0)?"list.do":"javascript:history.back()";
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		this.setViewName("/board/message.jsp");
		this.setRedirect(false);
	}

}
