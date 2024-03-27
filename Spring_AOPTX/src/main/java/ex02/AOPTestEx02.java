package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTestEx02 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex02/aop.xml");
		BoardService bs= ctx.getBean("boardService",BoardService.class);

		bs.insertBoard("ù��° ���� ����մϴ�");
		
		bs.insertBoard("�ι�° �۵� �����");
	}

}
