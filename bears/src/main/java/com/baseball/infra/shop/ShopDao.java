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
	
}
