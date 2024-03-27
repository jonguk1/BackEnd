package ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTestEx03 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex03/aop_ex03.xml");
		
		BoardService bs = ctx.getBean("boardSvc",BoardService.class);
		
		bs.insertBoard("ù��° �Խñ��� ���~~");
		
		bs.insertBoard("�ι�° �Խñ��� ���~~");
	}

}
