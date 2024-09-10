package com.baseball.infra.member;

import java.util.Date;

public class MemberDto {
	
	private String memSeq;
	private Integer memXdmNy;
    private String memName;
    private String memId;
    private String memPassword;
    private String memGender;
    private Date memBirth;
    private String memEmail;
    private String memPhone;
    private String memDesc;
    private Integer memDelNy;
    private Date memRegist;
    private Date memEdit;
    
//  ----- getter / setter -----
    
	public String getMemSeq() {
		return memSeq;
	}
	public void setMemSeq(String memSeq) {
		this.memSeq = memSeq;
	}
	public Integer getMemXdmNy() {
		return memXdmNy;
	}
	public void setMemXdmNy(Integer memXdmNy) {
		this.memXdmNy = memXdmNy;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public String getMemGender() {
		return memGender;
	}
	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}
	public Date getMemBirth() {
		return memBirth;
	}
	public void setMemBirth(Date memBirth) {
		this.memBirth = memBirth;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemDesc() {
		return memDesc;
	}
	public void setMemDesc(String memDesc) {
		this.memDesc = memDesc;
	}
	public Integer getMemDelNy() {
		return memDelNy;
	}
	public void setMemDelNy(Integer memDelNy) {
		this.memDelNy = memDelNy;
	}
	public Date getMemRegist() {
		return memRegist;
	}
	public void setMemRegist(Date memRegist) {
		this.memRegist = memRegist;
	}
	public Date getMemEdit() {
		return memEdit;
	}
	public void setMemEdit(Date memEdit) {
		this.memEdit = memEdit;
	}

}
