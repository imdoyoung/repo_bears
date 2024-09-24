package com.baseball.infra.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ShopController {
	
	@Autowired
	ShopService shopService;

}
