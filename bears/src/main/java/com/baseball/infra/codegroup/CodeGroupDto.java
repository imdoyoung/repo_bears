package com.baseball.infra.codegroup;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CodeGroupDto {
	
	private String ifcgSeq;
	private String ifcgName;
	private Integer ifcgUseNy;
	private Integer ifcgOrder;
	private String ifcgDesc;
	private Integer ifcgDelNy;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date ifcgRegist;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date ifcgEdit;
	
	// count 추가
	private Integer xifcdSeqCount;
	
	

//	----- getter / setter -----
	
	
	public String getIfcgSeq() {
		return ifcgSeq;
	}
	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	public Integer getIfcgUseNy() {
		return ifcgUseNy;
	}
	public void setIfcgUseNy(Integer ifcgUseNy) {
		this.ifcgUseNy = ifcgUseNy;
	}
	public Integer getIfcgOrder() {
		return ifcgOrder;
	}
	public void setIfcgOrder(Integer ifcgOrder) {
		this.ifcgOrder = ifcgOrder;
	}
	public String getIfcgDesc() {
		return ifcgDesc;
	}
	public void setIfcgDesc(String ifcgDesc) {
		this.ifcgDesc = ifcgDesc;
	}
	public Integer getIfcgDelNy() {
		return ifcgDelNy;
	}
	public void setIfcgDelNy(Integer ifcgDelNy) {
		this.ifcgDelNy = ifcgDelNy;
	}
	public Date getIfcgRegist() {
		return ifcgRegist;
	}
	public void setIfcgRegist(Date ifcgRegist) {
		this.ifcgRegist = ifcgRegist;
	}
	public Date getIfcgEdit() {
		return ifcgEdit;
	}
	public void setIfcgEdit(Date ifcgEdit) {
		this.ifcgEdit = ifcgEdit;
	}
	public Integer getXifcdSeqCount() {
		return xifcdSeqCount;
	}
	public void setXifcdSeqCount(Integer xifcdSeqCount) {
		this.xifcdSeqCount = xifcdSeqCount;
	}
	
	
	
}
