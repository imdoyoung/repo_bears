package com.baseball.infra.user;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baseball.common.util.UtilDateTime;
import com.baseball.infra.constants.Constants;

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
	
	// Main
	@RequestMapping(value="/xdm/v1/infra/user/userXdmMain")
	public String userXdmMain() {
		return "/xdm/v1/infra/user/userXdmMain";
	}
	
	// LOGIN
	@RequestMapping(value="/xdm/v1/infra/user/userXdmLogin")
	public String userXdmLogin(UserDto userDto) {
		userService.usrSelectOneLogin(userDto);
		return "/xdm/v1/infra/user/userXdmLogin";
	}
	
	// LoginProc
	@ResponseBody
	@RequestMapping(value="/xdm/v1/infra/user/userXdmLoginProc")
	public Map<String, Object> userXdmLoginProc(UserDto userDto, HttpSession httpSession) {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();	// 결과를 담기 위한 맵 생성
			
		UserDto rtUser = userService.usrSelectOneLogin(userDto);	// 사용자 정보 조회
		
		
		if(rtUser != null) {	// 객체를 대상으로 null을 검사
			
			UserDto rtUser2 = userService.usrSelectOneId(userDto);	// 로그인 후 세션 정보 저장
			
			if(rtUser2 != null) {
				// 세션값 저장
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqXdm", rtUser2.getUsrSeq());
				httpSession.setAttribute("sessIdXdm", rtUser2.getUsrId());
				httpSession.setAttribute("sessNameXdm", rtUser2.getUsrName());
				
				returnMap.put("rt", "success");	// 성공 응답 설정
				
				// 저장된 세션값 확인
				System.out.println("sessSeqXdm: " + httpSession.getAttribute("sessSeqXdm"));
				System.out.println("sessIdXdm: " + httpSession.getAttribute("sessIdXdm"));
				System.out.println("sessNameXdm: " + httpSession.getAttribute("sessNameXdm"));
			}
			
		} else {
			returnMap.put("rt", "fail");	// 실패 응답 설정
		}
		return returnMap;
	}

}
