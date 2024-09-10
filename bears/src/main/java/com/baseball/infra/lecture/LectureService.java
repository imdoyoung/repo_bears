package com.baseball.infra.lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureService {
	
	@Autowired
	private LectureDao lectureDao;
	
	// select
	public List<LectureDto> selectLecture(){
		return lectureDao.selectLecture();
	}
	
	// insert
	public int insert(LectureDto lectureDto) {
		return lectureDao.insert(lectureDto);
	}
	
	// Mfom
	public LectureDto selectOne(LectureDto lectureDto) {
		return lectureDao.selectOne(lectureDto);
	}

	// update
	public int update(LectureDto lectureDto) {
		return lectureDao.update(lectureDto);
	}
}
