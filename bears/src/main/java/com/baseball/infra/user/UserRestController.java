package com.baseball.infra.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/user")
public class UserRestController {

	@Autowired
	UserService userService;
	
//	@RequestMapping(value="", method = RequestMethod.GET) // 이건 옛날 방식
	@GetMapping("")
	public List<UserDto> selectList(UserVo userVo) throws Exception{
		List<UserDto> list = userService.usrSelectList(userVo);
		System.out.println("list : " + list + "@@@@@@@@@@@@");
		return list;
	}
	
	@GetMapping("/{usrSeq}")
	public UserDto selectOne(UserDto userDto) throws Exception{
		UserDto item = userService.usrSelectOne(userDto);
		return item;
	}
	
}
