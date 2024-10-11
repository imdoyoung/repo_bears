package com.baseball.infra.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	// 목록 - selectList
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmList")
	public String shopXdmList(ShopVo shopVo, Model model) {
		
		shopVo.setShStartDate(shopVo.getShStartDate()+" 00:00:00");
		shopVo.setShEndDate(shopVo.getShEndDate()+" 23:59:59");
		
		model.addAttribute("shopList", shopService.shopSelectList(shopVo));
		
		return "/xdm/v1/infra/shop/shopXdmList";
	}
	
	// 등록 - selectForm
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmForm")
	public String shopXdmForm() {
		return "/xdm/v1/infra/shop/shopXdmForm";
	}
	
	// 등록 - selectInst
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmInst")
	public String ShopXdmInst(ShopDto shopDto) {
		System.out.println("/// shopInst 실행 ///");
		shopService.shopInsert(shopDto);
		return "redirect:/xdm/v1/infra/shop/shopXdmList";
	}
	
	// 수정 - selectOne(Mfom)
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmMfom")
	public String shopXdmMfom(ShopDto shopDto, Model model) {
		model.addAttribute("shopItem", shopService.shopSelectOne(shopDto));
		System.out.println("/// shopMfom-selectOne 실행 ///");
		return "/xdm/v1/infra/shop/shopXdmMfom";
	}
	
	// 수정 - update
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmUpdt")
	public String shopXdmUpdt(ShopDto shopDto) {
		shopService.shopUpdate(shopDto);
		System.out.println("/// shopMfom - update 실행 ///");
		return "redirect:/xdm/v1/infra/shop/shopXdmList";
	}
	
	// 삭제 - uelete
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmUel")
	public String shopXdmUel(ShopDto shopDto) {
		shopService.shopUelete(shopDto);
		return "redirect:/xdm/v1/infra/shop/shopXdmList";
	}
	
	// 삭제 - delete
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmDel")
	public String shopXdmDel(ShopDto shopDto) {
		shopService.shopDelete(shopDto);
		return "redirect:/xdm/v1/infra/shop/shopXdmList";
	}

}
