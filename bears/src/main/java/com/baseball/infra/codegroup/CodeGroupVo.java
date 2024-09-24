package com.baseball.infra.codegroup;

import com.baseball.infra.constants.Constants;

public class CodeGroupVo {
	
	// search
	private Integer shDelNy;			// 삭제여부검색
	private Integer shUseNy;			// 사용여부검색
	private Integer shOption;			// 검색옵션
	private String shValue; 			// 검색값
	private Integer shOptionDate;		// 날짜검색옵션
	private String shDateStart;			// 검색시작날짜
	private String shDateEnd;			// 검색끝날짜
	
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
	
//	----- getter/setter -----
	


	public Integer getShDelNy() {
		return shDelNy;
	}


	public void setShDelNy(Integer shDelNy) {
		this.shDelNy = shDelNy;
	}


	public Integer getShUseNy() {
		return shUseNy;
	}


	public void setShUseNy(Integer shUseNy) {
		this.shUseNy = shUseNy;
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


	public Integer getShOptionDate() {
		return shOptionDate;
	}


	public void setShOptionDate(Integer shOptionDate) {
		this.shOptionDate = shOptionDate;
	}


	public String getShDateStart() {
		return shDateStart;
	}


	public void setShDateStart(String shDateStart) {
		this.shDateStart = shDateStart;
	}


	public String getShDateEnd() {
		return shDateEnd;
	}


	public void setShDateEnd(String shDateEnd) {
		this.shDateEnd = shDateEnd;
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
