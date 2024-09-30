package com.baseball.infra.user;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baseball.common.util.UtilDateTime;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	// SELECTLIST
	@RequestMapping(value="/xdm/v1/infra/user/userXdmList")
	public String userXdmList(Model model, UserVo userVo) {
//		userVo.setShStartDate(userVo.getShStartDate() + " 00:00:00");
//		userVo.setShEndDate(userVo.getShEndDate() + " 23:59:59");
		// 초기값 세팅이 없는 경우 사용
		userVo.setShStartDate(userVo.getShStartDate() == null || userVo.getShStartDate() == "" ? null : UtilDateTime.add00TimeString(userVo.getShStartDate()));
		userVo.setShEndDate(userVo.getShEndDate() == null || userVo.getShEndDate() == "" ? null : UtilDateTime.add59TimeString(userVo.getShEndDate()));
		userVo.setParamsPaging(userService.selectOneCount(userVo));
		if(userVo.getTotalRows() > 0) {
			model.addAttribute("usrList", userService.usrSelectList(userVo));
			model.addAttribute("vo", userVo);
		}
		return "/xdm/v1/infra/user/userXdmList";
	}
	
	// FROM
	@RequestMapping(value="/xdm/v1/infra/user/userXdmForm")
	public String userXdmFrom() {
		return "/xdm/v1/infra/user/userXdmForm";
	}
	
	// INSERT
	@RequestMapping(value="/xdm/v1/infra/user/userXdmInst")
	public String userXdmInst(UserDto userDto) {
		userService.usrInsert(userDto);
		return "redirect:/xdm/v1/infra/user/userXdmList";
	}
	
	// MFOM
	@RequestMapping(value="/xdm/v1/infra/user/userXdmMfom")
	public String userXdmMfom(UserDto userDto, Model model) {
		model.addAttribute("usrItem", userService.usrSelectOne(userDto));
		return "/xdm/v1/infra/user/userXdmMfom";
	}
	
	// UPDATE
	@RequestMapping(value="/xdm/v1/infra/user/userXdmUpdt")
	public String userXdmUpdt(UserDto userDto) {
		userService.usrUpdate(userDto);
		return "redirect:/xdm/v1/infra/user/userXdmList";
	}
	
	// UELETE
	@RequestMapping(value="/xdm/v1/infra/user/userXdmUel")
	public String userXdmUel(UserDto userDto) {	 
		userService.usrUelete(userDto);
		return "redirect:/xdm/v1/infra/user/userXdmList";
	}
	
	// DELETE
	@RequestMapping(value="/xdm/v1/infra/user/userXdmDel")
	public String userXdmDel(UserDto userDto) {
		System.out.println("delete 확인~");
		userService.usrDelete(userDto);
		return "redirect:/xdm/v1/infra/user/userXdmList";
	}
	
	// LOGIN
	@RequestMapping(value="/xdm/v1/infra/user/userXdmLogin")
	public String userXdmLogin(UserDto userDto) {
		userService.usrSelectOneLogin(userDto);
		return "/xdm/v1/infra/user/userXdmLogin";
	}
	
	@ResponseBody
	@RequestMapping(value="/xdm/v1/infra/user/userXdmLoginProc")
	public Map<String, Object> userXdmLoginProc(UserDto userDto) {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();	// 결과를 담기 위한 맵 생성
			
		UserDto rtUser = userService.usrSelectOneLogin(userDto);	// 사용자 정보 조회
		
		if(rtUser != null) {
			returnMap.put("rt", "success");	// 성공 응답 설정
		} else {
			returnMap.put("rt", "fail");	// 실패 응답 설정
		}
		
		return returnMap;
	}

}
