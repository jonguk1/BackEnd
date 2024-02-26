package jdbc.bbs;
//이벤트 핸들러 ==> Application Layer == Controller
//UI<=== Application Layer ===> Data Layer ===>DB
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

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
			listMember();
		}else if(obj == gui.btDel) {//회원탈퇴
			removeMember();
		}else if(obj == gui.bbsWrite) {//게시판 글쓰기
			writeList();
		}else if(obj == gui.btLogin) {//로그인 처리
			login();
		}else if(obj == gui.bbsList) {//게시판 글목록
			
		}else if(obj == gui.bbsDel) {//게시글 삭제
			//로그인한 사람이 자신만 쓴 글만 삭제
		}else if(obj == gui.bbsFind) {
			//title로 검색
		}
		
	}
	
	private void writeList() {
		String title = gui.tfTitle.getText();
		String writer = gui.tfWriter.getText();
		String content = gui.taContent.getText();
		
		if(title == null || title.trim().isEmpty()) {
			gui.showMsg("타이틀을 입력하세요");
			gui.tfTitle.requestFocus();
			return;
		}
		BbsVO write = new BbsVO(0, title, writer, content, null);
		
		try {
			int n = bbsDao.insertBbs(write);
			
	    	String msg = (n>0)? "글작성 완료- 글목록으로 이동합니다":"글작성 실패";
	    	gui.showMsg(msg);
	    	if(n>0) {
	    		gui.tabbedPane.setSelectedIndex(3);
	    		gui.clear2();
	    	}	
		}catch(SQLException e) {
			gui.showMsg(e.getMessage());
		}
		
	}

	private void login() {
		//id,pw값 받기
		String loginId = gui.loginId.getText();
		char[] pw = gui.loginPwd.getPassword();
		String loginPwd = new String(pw);
		
		//유효성 체크
		if(loginId ==null|| loginPwd == null || loginId.trim().isEmpty() || loginPwd.trim().isEmpty()) {
			gui.showMsg("로그인 아이디와 비밀번호를 입력하세요");
			gui.loginId.requestFocus();
			return;
		}
		try {
			//userDao의 logionCheck(loginId,loginPwd) 호출
			int result =userDao.loginCheck(loginId, loginPwd);
			System.out.println("result: " + result);
			if(result > 0) {
				//결과값이 1이면 로그인 성공
				gui.showMsg(loginId+ "님 환영합니다");
				gui.tabbedPane.setEnabledAt(2,true);//게시판 탭 활성화
				gui.tabbedPane.setEnabledAt(3,true);//게시판 탭 활성화
				gui.setTitle(loginId + "님 로그인 중...");
				gui.tfWriter.setText(loginId);//게시글 작성자를 로그인한 사람의 아이디로 설정
				gui.tabbedPane.setSelectedIndex(3);
			}else {
				gui.showMsg("아이디 또는 비밀번호가 일치하지 않습니다");
				gui.tabbedPane.setEnabledAt(2, false);
				gui.tabbedPane.setEnabledAt(3, false);
			}
		}catch(SQLException e) {
			gui.showMsg(e.getMessage());
		}
		
	}

	private void listMember() {
		try {
			//userDao의 selectAll()호출
			ArrayList<MemberVO> userList = userDao.selectAll();
			//반환 받은 ArrayList에서 회원정보 꺼내서 taMembers에 출력
			gui.showMembers(userList);
		}catch(SQLException e) {
			gui.showMsg(e.getMessage());
		}
	}

	private void removeMember() {
		//1. 입력한 id값 받기
		String id = gui.tfId.getText();
		//2. 유효성 체크
		if(id == null || id.trim().isEmpty()) {
			gui.showMsg("아이디를 입력해주세요");
			gui.tfId.requestFocus();
			return;
		}
		//3. userDao의 deleteMember(id) 호출
	    try {
	    	int n = userDao.deleteMember(id.trim());
	    	
	    	//4. 그 결과 메세지 처리	
	    	String msg = (n>0)?"회원탈퇴가 완료되었습니다":"탈퇴 실패- 없는 아이디입니다" ;
	    	gui.showMsg(msg);
	    	
	    	if(n>0) {
	    		gui.tabbedPane.setEnabledAt(2, false);
	    		gui.tabbedPane.setEnabledAt(3, false);
	    		gui.clear1();
	    		gui.tabbedPane.setSelectedIndex(0);//로그인 탭 선택
	    	}
	    }catch(SQLException e) {
	    	gui.showMsg("아이디는 이미 사용중 입니다: "+ e.getMessage());
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
