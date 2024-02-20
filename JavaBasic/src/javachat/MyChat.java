package javachat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

import javax.swing.border.*;
/*[실습]
 * - 입력 버튼에 대한 이벤트 처리=> ActionEvent
 * - 버튼을 누르면 tf에 입력한 값을 가져와서
 *   ta에 붙여주고
 * - tf는 다시 비워주기
 * - ta에는 그동안 입력한 내용을 모두 볼 수 있도록 처리하세요   
 * */

public class MyChat extends JFrame implements ActionListener,Runnable{

	Container cp;
	private JTextField tf;
	private JTextArea ta;
	private JButton bt;
	private String nickName = "noname";
	
	private Socket sock;
	private BufferedReader in;
	private PrintWriter out;

	private boolean flag;
	
	public MyChat() {
		super("MyChat");
		cp=this.getContentPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 240, 245));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 360, 502);
		panel.add(scrollPane);
		
		ta = new JTextArea();
		scrollPane.setViewportView(ta);
		ta.setBorder(new LineBorder(Color.blue,3));
		ta.setFont(new Font("sans-serif",Font.BOLD,18));
		ta.setEditable(false);//편집하지 못하도록=>읽기 전용
		
		tf = new JTextField();
		tf.setBounds(12, 522, 360, 52);
		panel.add(tf);
		tf.setColumns(10);
		tf.setFont(new Font("sans-serif",Font.BOLD,18));
		tf.setBorder(new TitledBorder("Message"));
		
		bt = new JButton("퇴    장");
		bt.setBounds(12, 584, 360, 35);
		panel.add(bt);
		bt.setMnemonic('M');//단축키 설정 Alt+M
		
		//리스너 부착
		bt.addActionListener(this);
		tf.addActionListener(this);//엔터 칠때 ActionEvent가 발생함
		
		nickName= JOptionPane.showInputDialog("닉네임을 입력하세요");
		if(nickName != null) {
			setTitle(nickName + "님 대화창");
			//챗서버에 접속
			connectChat();
		}
		
		this.setSize(400,665);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//-------------------------
	
	public void connectChat() {
		try {
			sock = new Socket("localhost", 9999);
			ta.append("##챗서버에 연결됨###\n");
			in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(),true);
			out.println(nickName);//서버에 나의 닉네임을 보내자
			//서버에 메시지를 듣는 스레드 동작
			Thread listener = new Thread(this);
			listener.start();
		} catch (Exception e) {
			ta.setText("채팅 서버 연결 실패\n"+e+"\n");
		}
	}
	/**서버가 보내오는 메세지를 듣고 ta에 메세지를 출력하는 스레드*/
	public void run() {
		String serverMsg="";
		try {
			while(!flag) {
				serverMsg = in.readLine();
				if(serverMsg == null) return;
				ta.append(serverMsg + "\n");
				//커서의 위치를 ta의 끝으로 이동시키자
				ta.setCaretPosition(ta.getText().length());
			}	
		}catch(IOException e) {
			ta.append("\n서버와 연결 끊김: " + e);
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == tf) {
			sendMsg();
		}else if(obj == bt) {
			exitChat();
		}
	}//-----------------------
    /**서버에 메세지를 보내는 메서드*/
	private void sendMsg() {
		String input=tf.getText();
		//서버에 입력한 내용 보내기
		out.println(input);
		tf.setText("");
		tf.requestFocus();
	}
	/**퇴장 처리하는 메서드*/
	public void exitChat() {
		String msg = "##[" + this.nickName + "님이 퇴장합니다]##";
		out.println(msg);
		ta.setText("");
		tf.setText("");
		tf.setEnabled(false);//입력박스 비활성화
		//서버 메세지 듣는 스레드 중지시키기
		try {
			flag =true;
			//자원반납
			if(in != null) in.close();
			if(out != null) out.close();
			if(sock != null) sock.close();
		}catch(Exception e) {
			System.out.println("퇴장처리중 예외: " + e);
		}
	}

	public static void main(String[] args) {
		new MyChat();
	}
}

