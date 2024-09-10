package com.baseball.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
	
	@Autowired
	private CodeDao codeDao;
	
	// selectList
	public List<CodeDto> selectList(){
		return codeDao.selectList();
	}
	
	// selectListCode
	// code - codegroup 연결
	public List<CodeDto> selectListCodeGroup(){
//		List<CodeDto> codeGroups = codeDao.selectListCodeGroup();
		return codeDao.selectListCodeGroup();
	}

	//insert
	public int insert(CodeDto codeDto) {
		return codeDao.insert(codeDto);
	}
	
	// selectOne
	public CodeDto selectOne(CodeDto codeDto) {
		return codeDao.selectOne(codeDto);
	}
	
	// update
	public int update(CodeDto codedto) {
		return codeDao.update(codedto);
	}
	
	// uelete
	public int uelete(CodeDto codeDto) {
		return codeDao.uelete(codeDto);
	}
	
	// delete
	public int delet(CodeDto codeDto) {
		return codeDao.delete(codeDto);
	}
}
