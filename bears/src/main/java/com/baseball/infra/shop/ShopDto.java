package com.baseball.infra.shop;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ShopDto {
//	----- feild -----
	private String nsSeq;
	private String nsName;
	private String nsTel;
	private String nsOwnerName;
	private String nsOwnerTel;
	@DateTimeFormat(pattern="HH:mm")
	private Date nsOpenTime;
	@DateTimeFormat(pattern="HH:mm")
	private Date nsClosTime;
	private Integer nsMulti;
	private String nsLogo;
	private String nsGallery;
	private String nsInfoText;
	private Integer nsZipCode;
	private String nsAddr;
	private String nsAddrDetail;
	private Integer nsAddrCode;
	private String nsInfoWalk;
	private Integer nsInfoPrice;
	private String nsInfoEvent;
	private String nsInfoDetail;
	private Integer nsAddParkingNy;
	private Integer nsAddDogNy;
	private Integer nsAddArtOfMonthNy;
	private Integer nsAddDrillcareNy;
	private Integer nsAddWetcareNy;
	private Integer nsStar;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date nsRegDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date nsEditDate;
	private Integer nsDelNy;
	

//	----- getter/setter -----

	public String getNsSeq() {
		return nsSeq;
	}
	public void setNsSeq(String nsSeq) {
		this.nsSeq = nsSeq;
	}
	public String getNsName() {
		return nsName;
	}
	public void setNsName(String nsName) {
		this.nsName = nsName;
	}
	public String getNsTel() {
		return nsTel;
	}
	public void setNsTel(String nsTel) {
		this.nsTel = nsTel;
	}
	public String getNsOwnerName() {
		return nsOwnerName;
	}
	public void setNsOwnerName(String nsOwnerName) {
		this.nsOwnerName = nsOwnerName;
	}
	public String getNsOwnerTel() {
		return nsOwnerTel;
	}
	public void setNsOwnerTel(String nsOwnerTel) {
		this.nsOwnerTel = nsOwnerTel;
	}
	public Date getNsOpenTime() {
		return nsOpenTime;
	}
	public void setNsOpenTime(Date nsOpenTime) {
		this.nsOpenTime = nsOpenTime;
	}
	public Date getNsClosTime() {
		return nsClosTime;
	}
	public void setNsClosTime(Date nsClosTime) {
		this.nsClosTime = nsClosTime;
	}
	public Integer getNsMulti() {
		return nsMulti;
	}
	public void setNsMulti(Integer nsMulti) {
		this.nsMulti = nsMulti;
	}
	public String getNsLogo() {
		return nsLogo;
	}
	public void setNsLogo(String nsLogo) {
		this.nsLogo = nsLogo;
	}
	public String getNsGallery() {
		return nsGallery;
	}
	public void setNsGallery(String nsGallery) {
		this.nsGallery = nsGallery;
	}
	public String getNsInfoText() {
		return nsInfoText;
	}
	public void setNsInfoText(String nsInfoText) {
		this.nsInfoText = nsInfoText;
	}
	public Integer getNsZipCode() {
		return nsZipCode;
	}
	public void setNsZipCode(Integer nsZipCode) {
		this.nsZipCode = nsZipCode;
	}
	public String getNsAddr() {
		return nsAddr;
	}
	public void setNsAddr(String nsAddr) {
		this.nsAddr = nsAddr;
	}
	public String getNsAddrDetail() {
		return nsAddrDetail;
	}
	public void setNsAddrDetail(String nsAddrDetail) {
		this.nsAddrDetail = nsAddrDetail;
	}
	public Integer getNsAddrCode() {
		return nsAddrCode;
	}
	public void setNsAddrCode(Integer nsAddrCode) {
		this.nsAddrCode = nsAddrCode;
	}
	public String getNsInfoWalk() {
		return nsInfoWalk;
	}
	public void setNsInfoWalk(String nsInfoWalk) {
		this.nsInfoWalk = nsInfoWalk;
	}
	public Integer getNsInfoPrice() {
		return nsInfoPrice;
	}
	public void setNsInfoPrice(Integer nsInfoPrice) {
		this.nsInfoPrice = nsInfoPrice;
	}
	public String getNsInfoEvent() {
		return nsInfoEvent;
	}
	public void setNsInfoEvent(String nsInfoEvent) {
		this.nsInfoEvent = nsInfoEvent;
	}
	public String getNsInfoDetail() {
		return nsInfoDetail;
	}
	public void setNsInfoDetail(String nsInfoDetail) {
		this.nsInfoDetail = nsInfoDetail;
	}
	public Integer getNsAddParkingNy() {
		return nsAddParkingNy;
	}
	public void setNsAddParkingNy(Integer nsAddParkingNy) {
		this.nsAddParkingNy = nsAddParkingNy;
	}
	public Integer getNsAddDogNy() {
		return nsAddDogNy;
	}
	public void setNsAddDogNy(Integer nsAddDogNy) {
		this.nsAddDogNy = nsAddDogNy;
	}
	public Integer getNsAddArtOfMonthNy() {
		return nsAddArtOfMonthNy;
	}
	public void setNsAddArtOfMonthNy(Integer nsAddArtOfMonthNy) {
		this.nsAddArtOfMonthNy = nsAddArtOfMonthNy;
	}
	public Integer getNsAddDrillcareNy() {
		return nsAddDrillcareNy;
	}
	public void setNsAddDrillcareNy(Integer nsAddDrillcareNy) {
		this.nsAddDrillcareNy = nsAddDrillcareNy;
	}
	public Integer getNsAddWetcareNy() {
		return nsAddWetcareNy;
	}
	public void setNsAddWetcareNy(Integer nsAddWetcareNy) {
		this.nsAddWetcareNy = nsAddWetcareNy;
	}
	public Integer getNsStar() {
		return nsStar;
	}
	public void setNsStar(Integer nsStar) {
		this.nsStar = nsStar;
	}
	public Date getNsRegDate() {
		return nsRegDate;
	}
	public void setNsRegDate(Date nsRegDate) {
		this.nsRegDate = nsRegDate;
	}
	public Date getNsEditDate() {
		return nsEditDate;
	}
	public void setNsEditDate(Date nsEditDate) {
		this.nsEditDate = nsEditDate;
	}
	public Integer getNsDelNy() {
		return nsDelNy;
	}
	public void setNsDelNy(Integer nsDelNy) {
		this.nsDelNy = nsDelNy;
	}

}
