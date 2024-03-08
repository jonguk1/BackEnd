package common.mapper;

import org.apache.ibatis.annotations.Mapper;
//spring이 인터페이스를 상속받는 클래스 객체를 대신 생성해준다.
//==>Proxy객체
@Mapper
public interface SampleMapper {

	public int testCnt(); // 추상메서드 
}
