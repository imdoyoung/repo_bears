package com.baseball.infra.kakaoLogin;

import org.springframework.beans.factory.annotation.Autowired;

public class KakaoLoginController {

	// KakaoLoginService 에서 사용자 정보를 가져오고 KakaoLoginController 에서 이를 처리함
	// 카카오 로그인 요청을 처리하고 콜백을 통해 사용자 정보를 받아 세션에 저장
	
	@Autowired
	private KakaoLoginService kakaoLoginService;
}
