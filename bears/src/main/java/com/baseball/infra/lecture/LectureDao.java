package com.baseball.infra.lecture;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface LectureDao {
	
	// 추상메서드
	// select
	public List<LectureDto> selectLecture();

	// insert
	public int insert(LectureDto lectureDto);
	
	// Mfom
	public LectureDto selectOne(LectureDto lectureDto);
	
	// update
	public int update(LectureDto lectureDto);
}
