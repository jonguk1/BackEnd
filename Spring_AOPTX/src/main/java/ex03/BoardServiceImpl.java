package ex03;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
//Target
@Service
public class BoardServiceImpl implements BoardService {

	List<String> dbArr=new ArrayList<>();
	
	@Override
	public int insertBoard(String msg) {
		System.out.println("핵심로직 수행하는 메서드 insertBoard(): " + msg);
		dbArr.add(msg);
		return dbArr.size();
	}

}
