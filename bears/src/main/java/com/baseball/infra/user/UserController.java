package com.baseball.infra.user;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baseball.common.util.UtilDateTime;
import com.baseball.infra.constants.Constants;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	
//=================== XDM ===================//
	
	// SELECTLIST
	@RequestMapping(value="/xdm/v1/infra/user/userXdmList")
	public String userXdmList(@ModelAttribute("vo") UserVo userVo, Model model) {
//		System.out.println(userVo.getThisPage());
		
		// 날짜
//		userVo.setShStartDate(userVo.getShStartDate() + " 00:00:00");
//		userVo.setShEndDate(userVo.getShEndDate() + " 23:59:59");
		// 초기값 세팅이 없는 경우 사용
		userVo.setShStartDate(userVo.getShStartDate() == null || userVo.getShStartDate() == "" ? null : UtilDateTime.add00TimeString(userVo.getShStartDate()));
		userVo.setShEndDate(userVo.getShEndDate() == null || userVo.getShEndDate() == "" ? null : UtilDateTime.add59TimeString(userVo.getShEndDate()));
		
		userVo.setParamsPaging(userService.selectOneCount(userVo));
		if(userVo.getTotalRows() > 0) {
			model.addAttribute("usrList", userService.usrSelectList(userVo));
//			model.addAttribute("vo", userVo);
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
	public String userXdmMain(UserVo userVo, Model model) {
		model.addAttribute("usrList", userService.usrSelectList(userVo));
		return "/xdm/v1/infra/user/userXdmMain";
	}
	
	// LOGIN
	@RequestMapping(value="/xdm/v1/infra/user/userXdmSignin")
	public String userXdmSignin(UserDto userDto) {
		userService.usrSelectOneSignin(userDto);
		return "/xdm/v1/infra/user/userXdmSignin";
	}
	
	// LoginProc
	@ResponseBody
	@RequestMapping(value="/xdm/v1/infra/user/userXdmSigninProc")
	public Map<String, Object> userXdmSigninProc(UserDto userDto, HttpSession httpSession) {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();	// 결과를 담기 위한 맵 생성
			
		UserDto rtUser = userService.usrSelectOneSignin(userDto);	// 사용자 정보 조회
		
		
		if(rtUser != null) {	// 객체를 대상으로 null을 검사
			
			UserDto rtUser2 = userService.usrSelectOneId(userDto);	// 로그인 후 세션 정보 저장
			
			if(rtUser2 != null) {
				// 세션값 저장
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqXdm", rtUser2.getUsrSeq());
				httpSession.setAttribute("sessIdXdm", rtUser2.getUsrId());
				httpSession.setAttribute("sessNameXdm", rtUser2.getUsrName());
				httpSession.setAttribute("sessGradeXdm", rtUser2.getUsrGrade());
				// 성공 응답 설정
				returnMap.put("rt", "success");	
				// 저장된 세션값 확인
				System.out.println("sessSeqXdm: " + httpSession.getAttribute("sessSeqXdm"));
				System.out.println("sessIdXdm: " + httpSession.getAttribute("sessIdXdm"));
				System.out.println("sessNameXdm: " + httpSession.getAttribute("sessNameXdm"));
				System.out.println("sessGradeXdm: " + httpSession.getAttribute("sessGradeXdm"));
			}
		} else {
			returnMap.put("rt", "fail");	// 실패 응답 설정
		}
		return returnMap;
	}
	
	// LogoutProc
	@ResponseBody
	@RequestMapping(value="/xdm/v1/infra/user/userXdmSignoutProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	
//=================== USR ===================//
	
	// Main
	@RequestMapping(value="/usr/v1/infra/user/userUsrMain")
	public String userUsrMain() {
		return "/usr/v1/infra/user/userUsrMain";
	}
	
	// Sign up
	@RequestMapping(value="/usr/v1/infra/user/userUsrSignup")
	public String userUsrSignup() {
		return "/usr/v1/infra/user/userUsrSignup";
	}
	
	// UsrINSERT
	@RequestMapping(value="/usr/v1/infra/user/userUsrInst")
	public String userUsrInst(UserDto userDto) {
		userService.usrInsert(userDto);
		return "redirect:/usr/v1/infra/user/userUsrSignin";
	}

	// Sign in
	@RequestMapping(value="/usr/v1/infra/user/userUsrSignin")
	public String userUsrSignin(UserDto userDto) {
		userService.usrSelectOneSignin(userDto);
		return "/usr/v1/infra/user/userUsrSignin";
	}
	
	// UsrLoginProc
	@ResponseBody
	@RequestMapping(value="/usr/v1/infra/user/userUsrSigninProc")
	public Map<String, Object> userUsrSigninProc(UserDto userDto, HttpSession httpSession) {
			
		Map<String, Object> returnMap = new HashMap<String, Object>();	// 결과를 담기 위한 맵 생성
			
		UserDto rtUser = userService.usrSelectOneSignin(userDto);	// 사용자 정보 조회
		
		
		if(rtUser != null) {	// 객체를 대상으로 null을 검사
			
			UserDto rtUser2 = userService.usrSelectOneId(userDto);	// 로그인 후 세션 정보 저장
			
			if(rtUser2 != null) {
				// 세션값 저장
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqXdm", rtUser2.getUsrSeq());
				httpSession.setAttribute("sessIdXdm", rtUser2.getUsrId());
				httpSession.setAttribute("sessNameXdm", rtUser2.getUsrName());
				httpSession.setAttribute("sessGradeXdm", rtUser2.getUsrGrade());
				// 성공 응답 설정
				returnMap.put("rt", "success");	
				// 저장된 세션값 확인
				System.out.println("sessSeqXdm: " + httpSession.getAttribute("sessSeqXdm"));
				System.out.println("sessIdXdm: " + httpSession.getAttribute("sessIdXdm"));
				System.out.println("sessNameXdm: " + httpSession.getAttribute("sessNameXdm"));
				System.out.println("sessGradeXdm: " + httpSession.getAttribute("sessGradeXdm"));
			}
		} else {
			returnMap.put("rt", "fail");	// 실패 응답 설정
		}
		return returnMap;
	}
	
	
	// List
	@RequestMapping(value="/usr/v1/infra/user/userUsrList")
	public String userUsrList() {
		return "/usr/v1/infra/user/userUsrList";
	}
	

}
