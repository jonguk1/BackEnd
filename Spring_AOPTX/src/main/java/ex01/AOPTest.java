package ex01;

import org.springframework.aop.framework.ProxyFactory;

public class AOPTest {

	public static void main(String[] args) {
		//1. 핵심로직을 갖는 객체 ==> Target
		ServiceImpl target = new ServiceImpl();
		
		//2. 공통관심 사항 ==> Aspect(추상적개념) ==> Advice(실제구현한 코드)
		AroundAdvice advice = new AroundAdvice();
		
		//3. Proxy 객체 얻기==> ProxyFactory
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(advice);
		
		//4. Proxy통해서 메서드 호출
		ServiceImpl proxy = (ServiceImpl)pf.getProxy();
		proxy.sayHello("아이유","블랙핑크","비비");
	}

}
