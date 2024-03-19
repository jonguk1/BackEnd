package com.user.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.common.exception.NotUserException;
import com.multi.mapper.MemberMapper;
import com.user.domain.MemberVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service("memberService")
@RequiredArgsConstructor //������ �����ϰ��� �� ��==> ���Ե� �������� ���� ��ü�� final �ʵ忩�� �Ѵ�
@Log4j
public class MemberServiceImpl implements MemberService {

	//@Inject
	//private MemberMapper mMapper;//Field Injection
	private final MemberMapper mMapper;//final field ==> ������ ����(@RequiredArgsConstructor)
	
	private final BCryptPasswordEncoder passwordEncoder; //==> ������ ����
	
	//����ڰ� �Է��� ����� ��Ʈ(�����ϰ� ����)�� �����̰� �̸� �ؽ��Ͽ� ��ȣȭ�� ��й�ȣ�� ������ش�(��ȣȭ)
	//<=> ��ȣȭ(��ȣȭ �� ���� Ǫ�� ��)
	@Override
	public int insertMember(MemberVO vo) {
		log.info("passwordEncoder: "+passwordEncoder);
		//��й�ȣ ��ȣȭ ó��
		vo.setPwd(passwordEncoder.encode(vo.getPwd()));
		log.info("��ȣȭ�� ��й�ȣ: " + vo.getPwd());
		return mMapper.insertMember(vo);
	}

	@Override
	public boolean idCheck(String userid) {
	    int n = mMapper.idCheck(userid);
		return (n>0)? false:true;
	}
	
	@Override
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectByUserid(String userid) {
		// TODO Auto-generated method stub
		return mMapper.selectByUserid(userid);
	}

	@Override
	public MemberVO loginCheck(MemberVO tmpUser) throws NotUserException {
		MemberVO dbUser = this.selectByUserid(tmpUser.getUserid());
		if(dbUser == null) {
			//���̵� ���� ��� => ����� ���� ���� �߻�
			throw new NotUserException("���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʾƿ�");
		}
		//��й�ȣ ��ġ���� üũ
		boolean isMatch=passwordEncoder.matches(tmpUser.getPwd(), dbUser.getPwd());
		log.info("tmpUser.getPwd(): " + tmpUser.getPwd());
		log.info("dbUser.getPwd(): " + dbUser.getPwd());
		
		if(!isMatch) throw new NotUserException("���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʾƿ�");
		
		return dbUser;//ȸ���� �´ٸ� ȸ������ ��ȯ
	}

}
