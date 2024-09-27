package com.baseball.infra.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
	
	@Autowired
	ShopDao shopDao;
	
	// 목록 - selectList
	public List<ShopDto> shopSelectList(){
		return shopDao.shopSelectList();
	}
	
	// 등록 - insert
	public int shopInsert(ShopDto shopDto) {
		return shopDao.shopInsert(shopDto);
	}
	
	// 수정 - selectOne
	public ShopDto shopSelectOne(ShopDto shopDto) {
		return shopDao.shopSelectOne(shopDto);
	}
	
}
