package com.baseball.infra.shop;

import java.util.Date;

import com.baseball.infra.constants.Constants;

public class ShopVo {
	
// ----- field -----
	// search
	private Integer shDelNy;				// 삭제 여부
	private Integer shMulti;				// 동시시술가능인원
	private Integer shAddrCode;				// 지역구
	private Integer shStar;					// 별점

	private Integer shAddParkingNy;			// 주차가능 여부
	private Integer shAddDogNy;				// 반려동물동반가능 여부
	private Integer shAddArtOfMonthNy;		// 이달의아트 유무
	private Integer shAddDrillcareNy;		// 트릴케어 유무
	private Integer shAddWetcareNy;			// 습식케어 유무
	
	private Integer shOption;				// 검색옵션
	private String 	shValue;				// 검색값
	private Integer shDateOption;			// 날짜검색옵션
	private String 	shStartDate;			// 검색시작날짜
	private String 	shEndDate;				// 검색종료날짜
	
	private Integer shMeDelNy;				// 메뉴삭제여부

	// paging
	private int thisPage = 1;		// 현재 페이지
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW;		// 화면에 보여줄 데이터 줄 갯수
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW;		// 화면에 보여줄 페이징 번호 갯수
	private int totalRows;			// 전체 데이터 갯수
	private int totalPages;			// 전체 페이지 번호
	private int startPage;			// 시작 페이지 번호
	private int endPage;			// 마지막 페이지 번호
	private int startRnumForMySql;	// 쿼리 시작 row
	
//	----- paging 계산 -----
	public void setParamsPaging(int totalRows) {	// 파라미터 세팅

		setTotalRows(totalRows);
		
		if(getTotalRows() == 0) {	// 입력받은 전체 데이터 갯수가 0이면
			setTotalPages(1);		// 전체 페이지 번호는 1
		} else {	// 입력받은 전체 데이터 갯수가 0이 아니면
			setTotalPages(getTotalRows() / getRowNumToShow());	// 전체 페이지 번호 =  전체 데이터 갯수 / 화면에 보여줄 데이터 줄 갯수
		}
		
		if(getTotalRows() % getRowNumToShow() > 0) {	// 전체 데이터 갯수 % 화면에 보여줄 데이터 줄 갯수 > 0 (나머지가 0 보다 클 때)
			setTotalPages(getTotalPages() + 1);		// 전체 페이지 번호 = 전체 페이지 번호 + 1
		}
		
		if(getTotalPages() < getThisPage()) {	// 전체 페이지 번호 < 현재 페이지
			setThisPage(getTotalPages());		// 현재페이지(전체 페이지 번호)
		}
		
		// 시작 페이지 번호(현재 페이지 - 1) / 화면에 보여줄 페이징 번호 개수 * 화면에 보여줄 페이징 번호 개수 + 1
		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);

		// 마지막 페이지 번호 = 시작 페이지 번호 + 화면에 보여줄 페이징 번호 개수 -1
		setEndPage(getStartPage() + getPageNumToShow() - 1);

		if (getEndPage() > getTotalPages()) {	// 마지막 페이지 번호 > 전체 페이지 번호
			setEndPage(getTotalPages());	// 마지막 페이지 번호 = 전체 페이지 번호
		}
		
		if (thisPage == 1) {			// 현재 페이지 번호가 1이라면
			setStartRnumForMySql(0);	// 쿼리 시작 row = 0
		} else {						// 현재 페이지 번호가 1이 아니라면
			setStartRnumForMySql((getRowNumToShow() * (getThisPage()-1)));	// 쿼리 시작 row = 화면에 보여줄 데이터 줄 갯수 -1
		}
		
		// 내용 출력 
		System.out.println("thisPage : " + getThisPage());
		System.out.println("rowNumToShow : " + getRowNumToShow());
		System.out.println("pageNumToShow : " + getPageNumToShow());
		System.out.println("totalRows : " + getTotalRows());
		System.out.println("totalPages : " + getTotalPages());
		System.out.println("startPage : " + getStartPage());
		System.out.println("endPage : " + getEndPage());
		System.out.println("startRnumForMySql : " + getStartRnumForMySql());
		
	}


// ----- getter/setter -----
	public Integer getShDelNy() {
		return shDelNy;
	}

	public void setShDelNy(Integer shDelNy) {
		this.shDelNy = shDelNy;
	}

	public Integer getShMulti() {
		return shMulti;
	}

	public void setShMulti(Integer shMulti) {
		this.shMulti = shMulti;
	}

	public Integer getNsAddrCode() {
		return shAddrCode;
	}

	public void setNsAddrCode(Integer nsAddrCode) {
		this.shAddrCode = nsAddrCode;
	}

	public Integer getShnsAddParkingNyDelNy() {
		return shAddParkingNy;
	}

	public void setShnsAddParkingNyDelNy(Integer shnsAddParkingNyDelNy) {
		this.shAddParkingNy = shnsAddParkingNyDelNy;
	}

	public Integer getShAddDogNy() {
		return shAddDogNy;
	}

	public void setShAddDogNy(Integer shAddDogNy) {
		this.shAddDogNy = shAddDogNy;
	}

	public Integer getShAddArtOfMonthNy() {
		return shAddArtOfMonthNy;
	}

	public void setShAddArtOfMonthNy(Integer shAddArtOfMonthNy) {
		this.shAddArtOfMonthNy = shAddArtOfMonthNy;
	}

	public Integer getShAddDrillcareNy() {
		return shAddDrillcareNy;
	}

	public void setShAddDrillcareNy(Integer shAddDrillcareNy) {
		this.shAddDrillcareNy = shAddDrillcareNy;
	}

	public Integer getShAddWetcareNy() {
		return shAddWetcareNy;
	}

	public void setShAddWetcareNy(Integer shAddWetcareNy) {
		this.shAddWetcareNy = shAddWetcareNy;
	}

	public Integer getShStar() {
		return shStar;
	}

	public void setShStar(Integer shStar) {
		this.shStar = shStar;
	}

	public Integer getShOption() {
		return shOption;
	}

	public void setShOption(Integer shOption) {
		this.shOption = shOption;
	}

	public String getShValue() {
		return shValue;
	}

	public void setShValue(String shValue) {
		this.shValue = shValue;
	}

	public Integer getShDateOption() {
		return shDateOption;
	}

	public void setShDateOption(Integer shDateOption) {
		this.shDateOption = shDateOption;
	}

	public String getShStartDate() {
		return shStartDate;
	}

	public void setShStartDate(String shStartDate) {
		this.shStartDate = shStartDate;
	}

	public String getShEndDate() {
		return shEndDate;
	}

	public void setShEndDate(String shEndDate) {
		this.shEndDate = shEndDate;
	}

	public int getThisPage() {
		return thisPage;
	}

	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}

	public int getRowNumToShow() {
		return rowNumToShow;
	}

	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}

	public int getPageNumToShow() {
		return pageNumToShow;
	}

	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRnumForMySql() {
		return startRnumForMySql;
	}

	public void setStartRnumForMySql(int startRnumForMySql) {
		this.startRnumForMySql = startRnumForMySql;
	}


	public Integer getShAddrCode() {
		return shAddrCode;
	}


	public void setShAddrCode(Integer shAddrCode) {
		this.shAddrCode = shAddrCode;
	}


	public Integer getShAddParkingNy() {
		return shAddParkingNy;
	}


	public void setShAddParkingNy(Integer shAddParkingNy) {
		this.shAddParkingNy = shAddParkingNy;
	}


	public Integer getShMeDelNy() {
		return shMeDelNy;
	}


	public void setShMeDelNy(Integer shMeDelNy) {
		this.shMeDelNy = shMeDelNy;
	}
	
}
