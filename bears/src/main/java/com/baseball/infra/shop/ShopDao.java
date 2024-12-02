package com.baseball.infra.shop;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ShopDao {
	
	// 목록 - selectList
	public List<ShopDto> shopSelectList(ShopVo shopVo);
	
	// 등록 - insert
	public int shopInsert(ShopDto shopDto);
	
	// 수정 - selectOne(Mfom)
	public ShopDto shopSelectOne(ShopDto shopDto);
	
	// 수정 - update
	public int shopUpdate(ShopDto shopDto);
	
	// 삭제 - uelete
	public int shopUelete(ShopDto shopDto);
	
	// 삭제 - delete
	public int shopDelete(ShopDto shopDto);
	
	// 페이징 - selectOneCount
	public int shopSelectOneCount(ShopVo shopVo);
	
	// file 첨부
	public void insertUploaded(ShopDto shopDto);
	
	// 리뷰List - shopReviewSelectList
	public List<ShopDto> shopReviewSelectList(ShopDto shopDto);
	
	// 리뷰 - 별점 평균
	public ShopDto getAverageStar(ShopDto shopDto);
	
	// ===== MENU ===== //	
	// 메뉴목록 - shopMenuSelectList
	public List<ShopDto> shopMenuSelectList(ShopVo shopVo);
	
	// 페이징 - shopMenuSelectOneCount
	public int shopMenuSelectOneCount(ShopVo shopVo);
	
	// Shop-ShopMenu 연결 - selectListShop
	public List<ShopDto> selectListShop();
	
	// 등록 - insert
	public int shopMenuInsert(ShopDto shopDto);
	
	// shopDetail에서 Menu 리스트 띄우기
	public List<ShopDto> menuSelectList(ShopDto shopDto);
	
	// ===== booking ===== //
	// 예약 등록 - shopBookingInsert
	public int shopBookingInsert(ShopDto shopDto);
	public int shopBookingMenuInsert(ShopDto shopDto);
	
	// ===== ShopPayment ===== //
	// booking+user 정보 출력
	public ShopDto paymentBookingSelectOne(ShopDto shopdto);
	
	// bookingMenu+menu 정보 출력
	public List<ShopDto> paymentBookingMenuSelectList(ShopDto shopDto);
	
	// shop 정보 출력
	public ShopDto paymentShopSelectOne(ShopDto shopDto);
	
	// booking 정보 update
	public int bookingUpdate(ShopDto shopDto);
	
	// usr메인페이지에서 예약 많은 순
	public List<ShopDto> bestBookingList(ShopDto shopDto);
}
