package ex01;

//Target : �ٽɷ����� ���� ��ü
public class ServiceImpl implements Service {

	//�ٽɷ����� �����ϴ� �޼���
	@Override
	public void sayHello(String... names) {
		if(names!=null) {
			for(String name:names) {
				System.out.println("Hello ~~~" + name);
			}
		}

	}

}
