package com.baseball.infra.lecture;

import java.util.Date;

public class LectureDto {
	
	private String lecSeq;
    private String lecType;
	private String lecName;
	private String lecPrice;
	private String lecTeacher;
	private Date lecApplyStart;
	private Date lecApplyEnd;
	private Date lecStudyStart;
	private Date lecStudyEnd;
	private String lecPlace;
	private String lecContent;
	private Integer lecDelNy;
	private Date lecRegist;
	private Date lecEdit;
	
//	----- getter / setter -----
	
	public String getLecSeq() {
		return lecSeq;
	}
	public void setLecSeq(String lecSeq) {
		this.lecSeq = lecSeq;
	}
	public String getLecType() {
		return lecType;
	}
	public void setLecType(String lecType) {
		this.lecType = lecType;
	}
	public String getLecName() {
		return lecName;
	}
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}
	public String getLecPrice() {
		return lecPrice;
	}
	public void setLecPrice(String lecPrice) {
		this.lecPrice = lecPrice;
	}
	public String getLecTeacher() {
		return lecTeacher;
	}
	public void setLecTeacher(String lecTeacher) {
		this.lecTeacher = lecTeacher;
	}
	public Date getLecApplyStart() {
		return lecApplyStart;
	}
	public void setLecApplyStart(Date lecApplyStart) {
		this.lecApplyStart = lecApplyStart;
	}
	public Date getLecApplyEnd() {
		return lecApplyEnd;
	}
	public void setLecApplyEnd(Date lecApplyEnd) {
		this.lecApplyEnd = lecApplyEnd;
	}
	public Date getLecStudyStart() {
		return lecStudyStart;
	}
	public void setLecStudyStart(Date lecStudyStart) {
		this.lecStudyStart = lecStudyStart;
	}
	public Date getLecStudyEnd() {
		return lecStudyEnd;
	}
	public void setLecStudyEnd(Date lecStudyEnd) {
		this.lecStudyEnd = lecStudyEnd;
	}
	public String getLecPlace() {
		return lecPlace;
	}
	public void setLecPlace(String lecPlace) {
		this.lecPlace = lecPlace;
	}
	public String getLecContent() {
		return lecContent;
	}
	public void setLecContent(String lecContent) {
		this.lecContent = lecContent;
	}
	public Integer getLecDelNy() {
		return lecDelNy;
	}
	public void setLecDelNy(Integer lecDelNy) {
		this.lecDelNy = lecDelNy;
	}
	public Date getLecRegist() {
		return lecRegist;
	}
	public void setLecRegist(Date lecRegist) {
		this.lecRegist = lecRegist;
	}
	public Date getLecEdit() {
		return lecEdit;
	}
	public void setLecEdit(Date lecEdit) {
		this.lecEdit = lecEdit;
	}
	
	
}
