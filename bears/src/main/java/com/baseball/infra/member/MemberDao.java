package com.baseball.infra.member;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {

	// 추상 메서드
	// select
	public List<MemberDto> selectMember();
	
	// insert
	public int insert(MemberDto memberDto);
	
	// Mfom
	public MemberDto selectOne(MemberDto memberDto);
	
	// update
	public int update(MemberDto memberDto);
}
