package jdbc.bbs;
//이벤트 핸들러 ==> Application Layer == Controller
//UI<=== Application Layer ===> Data Layer ===>DB
import java.awt.event.*;
import java.sql.SQLException;

public class MyEventHandler implements ActionListener{

    private MyBoardApp gui;//View
    private MemberDAO userDao;//Model
    private BbsDAO bbsDao;//Model
    
    public MyEventHandler(MyBoardApp app) {
    	this.gui = app;
    	userDao = new MemberDAO();
    	bbsDao = new BbsDAO();
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == gui.btJoin) {//회원가입
			joinMember();
		}else if(obj == gui.btClear) {//지우기
			gui.clear1();
		}else if(obj == gui.btList) {//회원목록
			
		}else if(obj == gui.btDel) {//회원탈퇴
			
		}
		
	}
	
	private void joinMember(){
		//1.입력값 받기
		String id = gui.tfId.getText();
		String pw = gui.tfPw.getText();
		String name = gui.tfName.getText();
		String tel = gui.tfTel.getText();
		//2.유효성 체크 (id,pw,name)
		if(id == null || id.trim().isEmpty()) {
			gui.showMsg("아이디를 입력하세요");
			gui.tfId.requestFocus();
			return;
		}else if(pw == null || pw.trim().isEmpty()) {
			gui.showMsg("패스워드를 입력하세요");
			gui.tfPw.requestFocus();
			return;
		}else if(name == null || name.trim().isEmpty()) {
			gui.showMsg("이름을 입력하세요");
			gui.tfName.requestFocus();
			return;
		}
		//3.입력값들을 MemberVO객체에 담아주기
	    MemberVO user = new MemberVO(id,pw,name,tel,null);
		
		//4.userDao의 insertMember()호출
	    try {
	    	int n = userDao.insertMember(user);
	    	
	    	//5.결과에 따른 메세지 처리
	    	String msg = (n>0)? "회원가입 완료- 로그인으로 이동합니다":"회원가입 실패";
	    	gui.showMsg(msg);
	    	if(n>0) {
	    		gui.tabbedPane.setSelectedIndex(0);
	    		//로그인 탭 선택
	    		gui.clear1();
	    	}
	    	
	    }catch(SQLException e) {
	    	gui.showMsg("아이디는 이미 사용중 입니다: "+ e.getMessage());
	    }
	}
	
	
}
