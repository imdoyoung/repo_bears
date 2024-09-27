package com.baseball.infra.shop;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ShopDao {
	
	// 목록 - selectList
	public List<ShopDto> shopSelectList();
	
	// 등록 - insert
	public int shopInsert(ShopDto shopDto);
	
	// 수정 - selectOne(Mfom)
	public ShopDto shopSelectOne(ShopDto shopDto);

}
