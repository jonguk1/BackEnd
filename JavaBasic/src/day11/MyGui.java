package day11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//1)
/*
 * 이벤트 소스: JButton, JTextField, JTextArea, JRadioButton, JCheckbox, Choice
	이벤트: ActionEvent, KeyEvent, ItemEvent
	이벤트 핸들러:==> 이벤트를 처리하는 클래스
		1) 이벤트소스를 갖는 클래스를 이벤트 핸들러로 만든다
		2) 이너 클래스로 이벤트 핸들러를 만든다
		3) Anonymous클래스(이름없는 이너클래스)로 만든다 (=> 람다식으로 처리할 수도 있다)
		4) 외부 클래스로 만드는 방법
	ActionListener
	KeyListener
	ItemListener 
	=> XXXListener인터페이스를 상속받아야 함
 * 
 * *************************************
 * 이벤트 처리 절차
 * [1] import java.awt.event.*;
 * [2] XXXListener 인터페이스를 상속받는다 (ActionListener)
 * [3] 추상메서드를 오버라이딩한다. (빈블럭으로) => 이벤트 처리 메서드(void	actionPerformed(ActionEvent e))
 * [4] 이벤트소스에 리스너를 붙인다. addXXXListener()메서드 이용
 * 		=> b1.addActionListener(핸들러객체)
 * [5] 오버라이딩한 메서드에 이벤트 처리코드를 구현
 * **************************************
 * */
public class MyGui extends JFrame implements ActionListener//2) 
{

	Container cp;
	JPanel panel, northP;
	JButton btR, btG, btB;
	public MyGui() {
		super("::MyGui::");
		cp=this.getContentPane();//동,서,남,북,중앙 영역=>BorderLayout
	    panel=new JPanel();	//FlowLayout 
	    cp.add(panel,"Center");//중앙 붙이기
	    panel.setBackground(Color.white);
	    
	    //northP생성해서 "North"에 붙이고 배경색 주기
	    northP=new JPanel();
	    cp.add(northP,"North");
	    northP.setBackground(Color.magenta);
	    
	    btR=new JButton("Red");
	    btG=new JButton("Green");
	    btB=new JButton("Blue");
	    
	    //northP.setLayout(null);//기본레이아웃(FlowLayout)을 해제	    
	    //btR.setBounds(150, 50, 200, 80);
	    
	    northP.add(btR);
	    northP.add(btG);
	    northP.add(btB);
	    //버튼에 리스너 부착 4)
	    btR.addActionListener(this);//this==> 이벤트핸들러객체(ActionListener를 구현한 객체)=>MyGui객체
	    btG.addActionListener(this);
	    btB.addActionListener(this);
	    //창닫기 처리
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//-----------------------
	@Override
	public void actionPerformed(ActionEvent e) {//3)
		//이벤트 처리 코드  5)
		//이벤트 소스의 주소값을 얻어보자
		Object obj=e.getSource();
		String cmd=e.getActionCommand();//이벤트 소스의 문자열정보를 반환
		setTitle(cmd+"버튼을 눌렀군요~");
		if(obj==btR) {
			panel.setBackground(Color.red);
		}else if(obj==btG) {
			panel.setBackground(Color.green);
		}else if(obj==btB) {
			panel.setBackground(Color.blue);
		}
	}//----------------------------

	public static void main(String[] args) {
		MyGui my=new MyGui();
		//my.setSize(400,700);//w, h
		//my.setLocation(1300,50);//x, y
		my.setBounds(1300,50,400,700);//x,y,w,h
		my.setVisible(true);

	}

}
