package com.baseball.infra.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmList")
	public String shopXdmList() {
		return "/xdm/v1/infra/shop/shopXdmList";
	}

}
