package com.baseball.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	// select
	public List<MemberDto> selectMember(){
		return memberDao.selectMember();
	}
	
	// insert
//	public int insert(MemberDto memberDto) {
//		int result = memberDao.insert(memberDto);
//		return result;
//	}
	public int insert(MemberDto memberDto) {
		return memberDao.insert(memberDto);
	}
	
	// Mfom
	public MemberDto selectOne(MemberDto memberDto) {
		return memberDao.selectOne(memberDto);
	}

	// update
	public int update(MemberDto memberDto) {
		System.out.println(memberDto.getMemGender());
		return memberDao.update(memberDto);
	}
	
}
