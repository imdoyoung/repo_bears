package com.baseball.infra.user;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	
	public List<UserDto> usrSelectList(UserVo userVo);
	
	public int usrInsert(UserDto userDto);
	
	public UserDto usrSelectOne(UserDto userDto);
	
	public int usrUpdate(UserDto userDto);
	
	public int usrUelete(UserDto userDto);
	
	public int usrDelete(UserDto userDto);
	
	public int selectOneCount(UserVo userVo);
	
	public UserDto usrSelectOneSignin(UserDto userDto);
	
	public UserDto usrSelectOneId(UserDto userDto);
}
