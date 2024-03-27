package ex02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
//Target
public class BoardServiceImpl implements BoardService {

	List<String> dbArr=new ArrayList<>();
	
	@Override
	public int insertBoard(String msg) {
		System.out.println("핵심로직 수행하는 메서드 insertBoard(): " + msg);
		dbArr.add(msg);
		int a= 10/0;
		System.out.println(a);
		return dbArr.size();
	}

}
