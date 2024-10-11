package com.baseball.infra.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
	
	@Autowired
	ShopDao shopDao;
	
	// 목록 - selectList
	public List<ShopDto> shopSelectList(ShopVo shopVo){
		return shopDao.shopSelectList(shopVo);
	}
	
	// 등록 - insert
	public int shopInsert(ShopDto shopDto) {
		return shopDao.shopInsert(shopDto);
	}
	
	// 수정 - selectOne
	public ShopDto shopSelectOne(ShopDto shopDto) {
		return shopDao.shopSelectOne(shopDto);
	}
	
	// 수정 - update
	public int shopUpdate(ShopDto shopDto) {
		return shopDao.shopUpdate(shopDto);
	}
	
	// 삭제 - uelete
	public int shopUelete(ShopDto shopDto) {
		return shopDao.shopUelete(shopDto);
	}
	
	// 삭제 - delete
	public int shopDelete(ShopDto shopDto) {
		return shopDao.shopDelete(shopDto);
	}
	
}
