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
	

}
