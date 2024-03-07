package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class BoardListAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//0. pageNum 파라미터값 받기
		String pageNumStr=req.getParameter("pageNum");
		if(pageNumStr==null) {
			pageNumStr="1";//디폴트 페이지 1페이지로 지정
		}
		int pageNum=Integer.parseInt(pageNumStr.trim());
		if(pageNum<1) {//0이나 음수값이라면
			pageNum=1;
		}
		
		//BoardDAO 생성 listBoard() 호출
		BoardDAO dao=new BoardDAO();
		//1. 총 게시글 수 가져오기
		int totalCount=dao.getTotalCount();
		
		//2. 한 페이지 당 보여줄 목록 개수 정하기=> 5개씩 보여주기
		int oneRecordPage=5;
		
		//3. 총 페이지 수 구하기
		/*
		int pageCount=1;
		if(totalCount%oneRecordPage==0) {
			pageCount=totalCount/oneRecordPage;
		}else {
			pageCount=totalCount/oneRecordPage+1;
		}
		*/
		int pageCount=(totalCount-1)/oneRecordPage+1;		
		System.out.println("pageCount: "+pageCount);
		//4. jsp에서 페이지 네비게이션 출력=> 링크==>pageNum파라미터 전달
		if(pageNum>pageCount) {
			pageNum=pageCount;//마지막 페이지로 지정
		}
		//5. pageNum을 이용해서 DB에서 끊어올 범위 정하기
		int end=pageNum * oneRecordPage;
		int start=end -(oneRecordPage-1);
		
		//5. 게시글 목록 가져오기
		List<BoardVO> boardList=dao.listBoard(start, end);
		
		//반환하는 List<BoardVO> 객체를 req에 저장
		req.setAttribute("boardAll", boardList);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("pageNum", pageNum);
		
		
		this.setViewName("list.jsp");
		this.setRedirect(false);
	}

}
