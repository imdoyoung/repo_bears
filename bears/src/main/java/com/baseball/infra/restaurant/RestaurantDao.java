package com.baseball.infra.restaurant;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao {

	// 추상메서드
	// select
	public List<RestaurantDto> selectRestaurant();
	
	// insert
	public int insert(RestaurantDto restaurantDto);
	
	// update
	public RestaurantDto selectOne(RestaurantDto restaurantDto);
}
