package ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//Advice : �ֺ������� ���� ������ɻ����� ������ ��ü
public class AroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invo) throws Throwable{
		
		System.out.println("====I am AroundAdvice1" + invo.getMethod() + "ȣ�� ��===");
		Object obj = invo.proceed();
		System.out.println("====I am AroundAdvice1" + invo.getMethod() + "ȣ�� ��===");
		return obj;
	}
	
}
