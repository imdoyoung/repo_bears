package com.baseball.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.baseball.infra.constants.Constants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 인터페이스를 구현하는 클래스
// HandlerInterceptor : 특정 URI 호출을 '가로채는' 역할, 이를 이용하여 기존 컨트롤러의 로직을 수정하기도 않고도, 사전이나 사후 제어가 가능
public class CheckLoginSessionInterceptor implements HandlerInterceptor {
	
	// 로그인 여부를 체크해서 로그인이 되었을때만 페이지에 접근을 허용한다.
	@Override
	// HandlerInterceptor에서 제공하는 메서드
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
//		System.out.println("로그인 확인, xdmSeq : " + request.getSession().getAttribute("sessSeqXdm"));
//		
//		if(request.getSession().getAttribute("sessSeqXdm") != null) {	// 로그인이 되어 있을 때
////			by pass
//		} else {
//			response.sendRedirect(Constants.XDM_URL_LOGINFORM);		// 로그인 페이지 경로로 이동
//			return false;	// 함수 탈출
//		}
		
		// 현재 요청 URL
		String requestURI = request.getRequestURI();
		HttpSession session = request.getSession();
		
		// 관리자 페이지 요청일 경우
		if(requestURI.startsWith("/xdm")) {
			System.out.println("관리자 로그인 확인, xdmSeq : " + request.getSession().getAttribute("sessSeqXdm"));
			if(session.getAttribute("sessSeqXdm") == null) {			// 관리자가 로그인하지 않았을 경우
				response.sendRedirect(Constants.XDM_URL_LOGINFORM);		// 관리자 로그인 페이지로 리다이렉트
				return false;
			}
		}
		
		// 사용자 페이지 요청일 경우
		if(requestURI.startsWith("/usr")) {
			System.out.println("사용자 로그인 확인, UsrSeq : " + request.getSession().getAttribute("sessSeqXdm"));
			if(session.getAttribute("sessSeqXdm") == null) {			// 사용자가 로그인하지 않았을 경우
				response.sendRedirect(Constants.USR_URL_LOGINFORM);		// 사용자 로그인 페이지로 리다이렉트
				return false;
			}
		}
		
		// 요청을 계속 처리
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
