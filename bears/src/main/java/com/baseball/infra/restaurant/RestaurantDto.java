package com.baseball.infra.restaurant;

import java.util.Date;

public class RestaurantDto {
	private String resSeq;
    private String resType;
    private String resName;
    private	Date resOpen;
    private Date resClose;
    private String resTel;
    private String resEAdress;
    private Integer resParkingNy;
    private Integer resReservationNy;
    private Integer resColchageNy;
    private String resAbout;
    private Integer resDelNy;
    private Date resRegist;
    private Date resEdit;
    
//  ----- getter / setter -----
    
	public String getResSeq() {
		return resSeq;
	}
	public void setResSeq(String resSeq) {
		this.resSeq = resSeq;
	}
	public String getResType() {
		return resType;
	}
	public void setResType(String resType) {
		this.resType = resType;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public Date getResOpen() {
		return resOpen;
	}
	public void setResOpen(Date resOpen) {
		this.resOpen = resOpen;
	}
	public Date getResClose() {
		return resClose;
	}
	public void setResClose(Date resClose) {
		this.resClose = resClose;
	}
	public String getResTel() {
		return resTel;
	}
	public void setResTel(String resTel) {
		this.resTel = resTel;
	}
	public String getResEAdress() {
		return resEAdress;
	}
	public void setResEAdress(String resEAdress) {
		this.resEAdress = resEAdress;
	}
	public Integer getResParkingNy() {
		return resParkingNy;
	}
	public void setResParkingNy(Integer resParkingNy) {
		this.resParkingNy = resParkingNy;
	}
	public Integer getResReservationNy() {
		return resReservationNy;
	}
	public void setResReservationNy(Integer resReservationNy) {
		this.resReservationNy = resReservationNy;
	}
	public Integer getResColchageNy() {
		return resColchageNy;
	}
	public void setResColchageNy(Integer resColchageNy) {
		this.resColchageNy = resColchageNy;
	}
	public String getResAbout() {
		return resAbout;
	}
	public void setResAbout(String resAbout) {
		this.resAbout = resAbout;
	}
	public Integer getResDelNy() {
		return resDelNy;
	}
	public void setResDelNy(Integer resDelNy) {
		this.resDelNy = resDelNy;
	}
	public Date getResRegist() {
		return resRegist;
	}
	public void setResRegist(Date resRegist) {
		this.resRegist = resRegist;
	}
	public Date getResEdit() {
		return resEdit;
	}
	public void setResEdit(Date resEdit) {
		this.resEdit = resEdit;
	}

}
