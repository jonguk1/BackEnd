package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.util.CommonUtil;
import user.model.MemberDAOMyBatis;

public class MemberDeleteAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("id");
		
		if(id ==null || id.trim().isBlank()) {
			this.setViewName("/member/list.jsp");
			this.setRedirect(true);
			return;
		}
		
		MemberDAOMyBatis dao = new MemberDAOMyBatis();
		int n = dao.deleteMember(id);
		
		String msg = (n>0)?"삭제가 완료되었습니다":"삭제가 완료되지 않았습니다";
		String loc = (n>0)?"/admin/memberList.do":"history.back()";

		String viewName = CommonUtil.addMsgLoc(req, msg, loc);
		
		this.setViewName(viewName);
		this.setRedirect(false);
	}

}
