package com.baseball.infra.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;
	
	// select
	public List<RestaurantDto> selectRestaurant(){
		return restaurantDao.selectRestaurant();
	}
	
	// insert
	public int insert(RestaurantDto restaurantDto) {
		return restaurantDao.insert(restaurantDto);
	}
	
	// update
	public RestaurantDto selectOne(RestaurantDto restaurantDto) {
		return restaurantDao.selectOne(restaurantDto);
	}
}
