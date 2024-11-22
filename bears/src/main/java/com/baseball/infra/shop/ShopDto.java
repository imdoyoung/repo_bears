package com.baseball.infra.shop;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

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

	
	// 리뷰
	private String reSeq;
	private String reTitle;
	private String reContent;
	private String  reId;
	private Integer reStar;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date reRegDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date reEditDate;
	private Integer reDelNy;
    private String B_user_usrSeq;
    private String B_shop_nsSeq;
    private String usrId;
    private Integer review_count;
    private double average_star;
    
    // menu
    private String meSeq;
    private String meName; 
    private String meDesc; 
    private String meTime;
    private Integer mePrice; 
    private Integer meCount; 
    private Integer meUseNy; 
    private Integer meDelNy;
	
    // booking
    private String boSeq;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date boDate;
    @DateTimeFormat(pattern="HH:mm")
    private Date boTime;
    private Integer boDeposit;
    private Integer boTotalPrice;
    private Integer boPayment;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date boSettleDate;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date boRegDate;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date boEditdate;
    private Integer boDelNy;
    
    // bookingMenu
    private String bmSeq;
    private Integer bmUseNy;
    private Integer bmDelNy;
    private String B_booking_boSeq;
    private String B_menu_meSeq;
    private List<String> menuSeqs;	// checkbox 선택된 meseq 배열
	
    // user
	private String usrSeq;
	private Integer usrXdmNy;
	private String usrName;
	private String usrPw;
	private Integer usrGender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date usrBirth;
	private String usrEmail;
	private String usrPhone;
	private String usrZipCode;
	private String usrAddr;
	private String usrAddrDetail;
	private Integer usrGrade;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date usrRegDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date usrEditdate;
	private Integer usrTosNy;
	private Integer usrMktNy;
	private Integer usrDelNy;
    
	// 파일첨부
	private MultipartFile uploadFile;
	private MultipartFile[] uploadFiles;
	private String nsfSeq;
	private Integer nsfType;
	private Integer nsfDefaultNy;
	private Integer nsfSort;
	private String nsfPath;
	private String nsfOriginalName;
	private String nsfUuidName;
	private String nsfExt;
	private long nsfSize;
	private Integer nsfDelNy;
	private Integer nsfPseq;
	private String nsfRegIp;
	private Integer nsfRegSeq;
	private Integer nsfRegDeviceCd;
	private Date nsfRegDateTime;
	private Date nsfRegDateTimeSvr;
	private String nsfTableName;

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
	public String getReSeq() {
		return reSeq;
	}
	public void setReSeq(String reSeq) {
		this.reSeq = reSeq;
	}
	public String getReTitle() {
		return reTitle;
	}
	public void setReTitle(String reTitle) {
		this.reTitle = reTitle;
	}
	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}
	public String getReId() {
		return reId;
	}
	public void setReId(String reId) {
		this.reId = reId;
	}
	public Integer getReStar() {
		return reStar;
	}
	public void setReStar(Integer reStar) {
		this.reStar = reStar;
	}
	public Date getReRegDate() {
		return reRegDate;
	}
	public void setReRegDate(Date reRegDate) {
		this.reRegDate = reRegDate;
	}
	public Date getReEditDate() {
		return reEditDate;
	}
	public void setReEditDate(Date reEditDate) {
		this.reEditDate = reEditDate;
	}
	public Integer getReDelNy() {
		return reDelNy;
	}
	public void setReDelNy(Integer reDelNy) {
		this.reDelNy = reDelNy;
	}
	public String getB_user_usrSeq() {
		return B_user_usrSeq;
	}
	public void setB_user_usrSeq(String b_user_usrSeq) {
		B_user_usrSeq = b_user_usrSeq;
	}
	public String getB_shop_nsSeq() {
		return B_shop_nsSeq;
	}
	public void setB_shop_nsSeq(String b_shop_nsSeq) {
		B_shop_nsSeq = b_shop_nsSeq;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public Integer getReview_count() {
		return review_count;
	}
	public void setReview_count(Integer review_count) {
		this.review_count = review_count;
	}
	public double getAverage_star() {
		return average_star;
	}
	public void setAverage_star(double average_star) {
		this.average_star = average_star;
	}
	public String getMeSeq() {
		return meSeq;
	}
	public void setMeSeq(String meSeq) {
		this.meSeq = meSeq;
	}
	public String getMeName() {
		return meName;
	}
	public void setMeName(String meName) {
		this.meName = meName;
	}
	public String getMeDesc() {
		return meDesc;
	}
	public void setMeDesc(String meDesc) {
		this.meDesc = meDesc;
	}
	public String getMeTime() {
		return meTime;
	}
	public void setMeTime(String meTime) {
		this.meTime = meTime;
	}
	public Integer getMePrice() {
		return mePrice;
	}
	public void setMePrice(Integer mePrice) {
		this.mePrice = mePrice;
	}
	public Integer getMeCount() {
		return meCount;
	}
	public void setMeCount(Integer meCount) {
		this.meCount = meCount;
	}
	public Integer getMeUseNy() {
		return meUseNy;
	}
	public void setMeUseNy(Integer meUseNy) {
		this.meUseNy = meUseNy;
	}
	public Integer getMeDelNy() {
		return meDelNy;
	}
	public void setMeDelNy(Integer meDelNy) {
		this.meDelNy = meDelNy;
	}
	public String getBoSeq() {
		return boSeq;
	}
	public void setBoSeq(String boSeq) {
		this.boSeq = boSeq;
	}
	public Date getBoDate() {
		return boDate;
	}
	public void setBoDate(Date boDate) {
		this.boDate = boDate;
	}
	public Date getBoTime() {
		return boTime;
	}
	public void setBoTime(Date boTime) {
		this.boTime = boTime;
	}
	public Integer getBoDeposit() {
		return boDeposit;
	}
	public void setBoDeposit(Integer boDeposit) {
		this.boDeposit = boDeposit;
	}
	public Integer getBoTotalPrice() {
		return boTotalPrice;
	}
	public void setBoTotalPrice(Integer boTotalPrice) {
		this.boTotalPrice = boTotalPrice;
	}
	public Integer getBoPayment() {
		return boPayment;
	}
	public void setBoPayment(Integer boPayment) {
		this.boPayment = boPayment;
	}
	public Date getBoSettleDate() {
		return boSettleDate;
	}
	public void setBoSettleDate(Date boSettleDate) {
		this.boSettleDate = boSettleDate;
	}
	public Date getBoRegDate() {
		return boRegDate;
	}
	public void setBoRegDate(Date boRegDate) {
		this.boRegDate = boRegDate;
	}
	public Date getBoEditdate() {
		return boEditdate;
	}
	public void setBoEditdate(Date boEditdate) {
		this.boEditdate = boEditdate;
	}
	public Integer getBoDelNy() {
		return boDelNy;
	}
	public void setBoDelNy(Integer boDelNy) {
		this.boDelNy = boDelNy;
	}
	public String getBmSeq() {
		return bmSeq;
	}
	public void setBmSeq(String bmSeq) {
		this.bmSeq = bmSeq;
	}
	public Integer getBmUseNy() {
		return bmUseNy;
	}
	public void setBmUseNy(Integer bmUseNy) {
		this.bmUseNy = bmUseNy;
	}
	public Integer getBmDelNy() {
		return bmDelNy;
	}
	public void setBmDelNy(Integer bmDelNy) {
		this.bmDelNy = bmDelNy;
	}
	public String getB_booking_boSeq() {
		return B_booking_boSeq;
	}
	public void setB_booking_boSeq(String b_booking_boSeq) {
		B_booking_boSeq = b_booking_boSeq;
	}
	public String getB_menu_meSeq() {
		return B_menu_meSeq;
	}
	public void setB_menu_meSeq(String b_menu_meSeq) {
		B_menu_meSeq = b_menu_meSeq;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	public String getNsfSeq() {
		return nsfSeq;
	}
	public void setNsfSeq(String nsfSeq) {
		this.nsfSeq = nsfSeq;
	}
	public Integer getNsfType() {
		return nsfType;
	}
	public void setNsfType(Integer nsfType) {
		this.nsfType = nsfType;
	}
	public Integer getNsfDefaultNy() {
		return nsfDefaultNy;
	}
	public void setNsfDefaultNy(Integer nsfDefaultNy) {
		this.nsfDefaultNy = nsfDefaultNy;
	}
	public Integer getNsfSort() {
		return nsfSort;
	}
	public void setNsfSort(Integer nsfSort) {
		this.nsfSort = nsfSort;
	}
	public String getNsfPath() {
		return nsfPath;
	}
	public void setNsfPath(String nsfPath) {
		this.nsfPath = nsfPath;
	}
	public String getNsfOriginalName() {
		return nsfOriginalName;
	}
	public void setNsfOriginalName(String nsfOriginalName) {
		this.nsfOriginalName = nsfOriginalName;
	}
	public String getNsfUuidName() {
		return nsfUuidName;
	}
	public void setNsfUuidName(String nsfUuidName) {
		this.nsfUuidName = nsfUuidName;
	}
	public String getNsfExt() {
		return nsfExt;
	}
	public void setNsfExt(String nsfExt) {
		this.nsfExt = nsfExt;
	}
	public long getNsfSize() {
		return nsfSize;
	}
	public void setNsfSize(long nsfSize) {
		this.nsfSize = nsfSize;
	}
	public Integer getNsfDelNy() {
		return nsfDelNy;
	}
	public void setNsfDelNy(Integer nsfDelNy) {
		this.nsfDelNy = nsfDelNy;
	}
	public Integer getNsfPseq() {
		return nsfPseq;
	}
	public void setNsfPseq(Integer nsfPseq) {
		this.nsfPseq = nsfPseq;
	}
	public String getNsfRegIp() {
		return nsfRegIp;
	}
	public void setNsfRegIp(String nsfRegIp) {
		this.nsfRegIp = nsfRegIp;
	}
	public Integer getNsfRegSeq() {
		return nsfRegSeq;
	}
	public void setNsfRegSeq(Integer nsfRegSeq) {
		this.nsfRegSeq = nsfRegSeq;
	}
	public Integer getNsfRegDeviceCd() {
		return nsfRegDeviceCd;
	}
	public void setNsfRegDeviceCd(Integer nsfRegDeviceCd) {
		this.nsfRegDeviceCd = nsfRegDeviceCd;
	}
	public Date getNsfRegDateTime() {
		return nsfRegDateTime;
	}
	public void setNsfRegDateTime(Date nsfRegDateTime) {
		this.nsfRegDateTime = nsfRegDateTime;
	}
	public Date getNsfRegDateTimeSvr() {
		return nsfRegDateTimeSvr;
	}
	public void setNsfRegDateTimeSvr(Date nsfRegDateTimeSvr) {
		this.nsfRegDateTimeSvr = nsfRegDateTimeSvr;
	}
	public String getNsfTableName() {
		return nsfTableName;
	}
	public void setNsfTableName(String nsfTableName) {
		this.nsfTableName = nsfTableName;
	}
	public List<String> getMenuSeqs() {
		return menuSeqs;
	}
	public void setMenuSeqs(List<String> menuSeqs) {
		this.menuSeqs = menuSeqs;
	}
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
	public String getUsrZipCode() {
		return usrZipCode;
	}
	public void setUsrZipCode(String usrZipCode) {
		this.usrZipCode = usrZipCode;
	}
	public String getUsrAddr() {
		return usrAddr;
	}
	public void setUsrAddr(String usrAddr) {
		this.usrAddr = usrAddr;
	}
	public String getUsrAddrDetail() {
		return usrAddrDetail;
	}
	public void setUsrAddrDetail(String usrAddrDetail) {
		this.usrAddrDetail = usrAddrDetail;
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
