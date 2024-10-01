package com.baseball.infra.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<UserDto> usrSelectList(UserVo userVo){
		return userDao.usrSelectList(userVo);
	}
	
	public int usrInsert(UserDto userDto) {
		return userDao.usrInsert(userDto);
	}
	
	public UserDto usrSelectOne(UserDto userDto) {
		return userDao.usrSelectOne(userDto);
	}
	
	public int usrUpdate(UserDto userDto) {
		return userDao.usrUpdate(userDto);
	}
	
	public int usrUelete(UserDto userDto) {
		return userDao.usrUelete(userDto);
	}
	
	public int usrDelete(UserDto userDto) {
		return userDao.usrDelete(userDto);
	}
	
	public int selectOneCount(UserVo userVo) {
		return userDao.selectOneCount(userVo);
	}
	
	public UserDto usrSelectOneLogin(UserDto userDto){
		return userDao.usrSelectOneLogin(userDto);
	}
	
	public UserDto usrSelectOneId(UserDto userDto) {
		return userDao.usrSelectOneId(userDto);
	}

}
