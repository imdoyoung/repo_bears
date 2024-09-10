package com.baseball.infra.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	// select
		// List
	@RequestMapping(value="/xdm/v1/infra/restaurant/restaurantXdmList")
	public String restaurantXdmList(Model model) {
		model.addAttribute("list", restaurantService.selectRestaurant());
		return "/xdm/v1/infra/restaurant/restaurantXdmList";
	}
	
	// insert
		// form
	@RequestMapping(value="/xdm/v1/infra/restaurant/restaurantXdmForm")
	public String restaurantXdmForm() {
		return "/xdm/v1/infra/restaurant/restaurantXdmForm";
	}
	
		// insert
	@RequestMapping(value="/xdm/v1/infra/restaurant/restaurantXdmInst")
	public String restaurantXdmInst(RestaurantDto restaurantDto) {
		restaurantService.insert(restaurantDto);
		return "redirect:/xdm/v1/infra/restaurant/restaurantXdmList";
	}
	
	// update
	@RequestMapping(value="/xdm/v1/infra/restaurant/restaurantXdmMfom")
	public String restaurantXdmMfom(RestaurantDto restaurantDto, Model model) {
		model.addAttribute("item", restaurantService.selectOne(restaurantDto));
		return "/xdm/v1/infra/restaurant/restaurantXdmMfom";
	}
	

}
