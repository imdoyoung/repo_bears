package com.baseball.infra.kakaoLogin;

public class KakaoLoginDto {
	
//	----- field -----
	private String id;
	private String nickname;
	private String email;

//	----- getter / setter -----
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

//	----- 생성자 -----
	public KakaoLoginDto(String id, String nickname, String email) {
		this.id = id;
		this.nickname = nickname;
		this.email = email;
	}
}
