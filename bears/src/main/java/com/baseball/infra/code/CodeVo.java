package com.baseball.infra.code;

import com.baseball.infra.codegroup.Constants;

public class CodeVo {
	// search
	private Integer shcdDelNy;
	private Integer shcdUseNy;
	private Integer shcdOption;
	private String shcdValue;
	private Integer shcdOptionDate;
	private String shcdDateStart;
	private String shcdDateEnd;
	
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

	
//	----- getter / setter -----
	

	public Integer getShcdDelNy() {
		return shcdDelNy;
	}


	public void setShcdDelNy(Integer shcdDelNy) {
		this.shcdDelNy = shcdDelNy;
	}


	public Integer getShcdUseNy() {
		return shcdUseNy;
	}


	public void setShcdUseNy(Integer shcdUseNy) {
		this.shcdUseNy = shcdUseNy;
	}


	public Integer getShcdOption() {
		return shcdOption;
	}


	public void setShcdOption(Integer shcdOption) {
		this.shcdOption = shcdOption;
	}


	public String getShcdValue() {
		return shcdValue;
	}


	public void setShcdValue(String shcdValue) {
		this.shcdValue = shcdValue;
	}


	public Integer getShcdOptionDate() {
		return shcdOptionDate;
	}


	public void setShcdOptionDate(Integer shcdOptionDate) {
		this.shcdOptionDate = shcdOptionDate;
	}


	public String getShcdDateStart() {
		return shcdDateStart;
	}


	public void setShcdDateStart(String shcdDateStart) {
		this.shcdDateStart = shcdDateStart;
	}


	public String getShcdDateEnd() {
		return shcdDateEnd;
	}


	public void setShcdDateEnd(String shcdDateEnd) {
		this.shcdDateEnd = shcdDateEnd;
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

}
