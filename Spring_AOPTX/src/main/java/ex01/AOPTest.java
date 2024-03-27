package ex01;

import org.springframework.aop.framework.ProxyFactory;

public class AOPTest {

	public static void main(String[] args) {
		//1. �ٽɷ����� ���� ��ü ==> Target
		ServiceImpl target = new ServiceImpl();
		
		//2. ������� ���� ==> Aspect(�߻�������) ==> Advice(���������� �ڵ�)
		AroundAdvice advice = new AroundAdvice();
		
		//3. Proxy ��ü ���==> ProxyFactory
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(advice);
		
		//4. Proxy���ؼ� �޼��� ȣ��
		ServiceImpl proxy = (ServiceImpl)pf.getProxy();
		proxy.sayHello("������","����ũ","���");
	}

}
