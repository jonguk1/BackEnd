package ex02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
//Target
public class BoardServiceImpl implements BoardService {

	List<String> dbArr=new ArrayList<>();
	
	@Override
	public int insertBoard(String msg) {
		System.out.println("�ٽɷ��� �����ϴ� �޼��� insertBoard(): " + msg);
		dbArr.add(msg);
		int a= 10/0;
		System.out.println(a);
		return dbArr.size();
	}

}
