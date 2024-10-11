package com.baseball.infra.user;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserDto {
//	----- field -----
	private String usrSeq;
	private Integer usrXdmNy;
	private String usrName;
	private String usrId;
	private String usrPw;
	private Integer usrGender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date usrBirth;
	private String usrEmail;
	private String usrPhone;
	private Integer usrGrade;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date usrRegDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date usrEditdate;
	private Integer usrTosNy;
	private Integer usrMktNy;
	private Integer usrDelNy;

//	----- getter / setter -----
	public String getUsrSeq() {
		return usrSeq;
	}
	public void setUsrSeq(String usrSeq) {
		this.usrSeq = usrSeq;
	}
	public Integer getUsrXdmNy() {
		return usrXdmNy;
	}
	public void setUsrXdmNy(Integer usrXdmNy) {
		this.usrXdmNy = usrXdmNy;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getUsrPw() {
		return usrPw;
	}
	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
	}
	public Integer getUsrGender() {
		return usrGender;
	}
	public void setUsrGender(Integer usrGender) {
		this.usrGender = usrGender;
	}
	public Date getUsrBirth() {
		return usrBirth;
	}
	public void setUsrBirth(Date usrBirth) {
		this.usrBirth = usrBirth;
	}
	public String getUsrEmail() {
		return usrEmail;
	}
	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}
	public String getUsrPhone() {
		return usrPhone;
	}
	public void setUsrPhone(String usrPhone) {
		this.usrPhone = usrPhone;
	}
	public Integer getUsrGrade() {
		return usrGrade;
	}
	public void setUsrGrade(Integer usrGrade) {
		this.usrGrade = usrGrade;
	}
	public Date getUsrRegDate() {
		return usrRegDate;
	}
	public void setUsrRegDate(Date usrRegDate) {
		this.usrRegDate = usrRegDate;
	}
	public Date getUsrEditdate() {
		return usrEditdate;
	}
	public void setUsrEditdate(Date usrEditdate) {
		this.usrEditdate = usrEditdate;
	}
	public Integer getUsrTosNy() {
		return usrTosNy;
	}
	public void setUsrTosNy(Integer usrTosNy) {
		this.usrTosNy = usrTosNy;
	}
	public Integer getUsrMktNy() {
		return usrMktNy;
	}
	public void setUsrMktNy(Integer usrMktNy) {
		this.usrMktNy = usrMktNy;
	}
	public Integer getUsrDelNy() {
		return usrDelNy;
	}
	public void setUsrDelNy(Integer usrDelNy) {
		this.usrDelNy = usrDelNy;
	}

}
