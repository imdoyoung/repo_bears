package com.baseball.infra.shop;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.baseball.common.util.UtilDateTime;
import com.baseball.infra.code.CodeDto;

@Controller
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	
//=================== XDM - SHOP ===================//
	
	// 목록 - selectList
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmList")
	public String shopXdmList(@ModelAttribute("vo") ShopVo shopVo, Model model) {
		
//		shopVo.setShStartDate(shopVo.getShStartDate()+" 00:00:00");
//		shopVo.setShEndDate(shopVo.getShEndDate()+" 23:59:59");
		// 초기값 세팅이 없는 경우 사용
		shopVo.setShStartDate(shopVo.getShStartDate() == null || shopVo.getShStartDate() == "" ? null : UtilDateTime.add00TimeString(shopVo.getShStartDate()));
		shopVo.setShEndDate(shopVo.getShEndDate() == null || shopVo.getShEndDate() == "" ? null : UtilDateTime.add59TimeString(shopVo.getShEndDate()));
		
		// 페이징 - selectOneCount
		shopVo.setParamsPaging(shopService.shopSelectOneCount(shopVo));

		if(shopVo.getTotalRows() > 0) {
			model.addAttribute("shopList", shopService.shopSelectList(shopVo));
		}
		
		return "/xdm/v1/infra/shop/shopXdmList";
	}
	
	// 등록 - selectForm
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmForm")
	public String shopXdmForm() {
		return "/xdm/v1/infra/shop/shopXdmForm";
	}
	
	// 등록 - selectInst
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmInst")
	public String ShopXdmInst(ShopDto shopDto) throws Exception {
		System.out.println("/// shopInst 실행 ///");
		shopService.shopInsert(shopDto, 0);
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
	
//=================== XDM - SHOPMENU ===================//
	
	// 목록 - selectList
	@RequestMapping(value="/xdm/v1/infra/shop/shopMenuXdmList")
	public String shopMenuXdmList(@ModelAttribute("vo") ShopVo shopVo, Model model) {
		
		// 초기값 세팅이 없는 경우 사용
		shopVo.setShStartDate(shopVo.getShStartDate() == null || shopVo.getShStartDate() == "" ? null : UtilDateTime.add00TimeString(shopVo.getShStartDate()));
		shopVo.setShEndDate(shopVo.getShEndDate() == null || shopVo.getShEndDate() == "" ? null : UtilDateTime.add59TimeString(shopVo.getShEndDate()));
		
		// 페이징 - selectOneCount
		shopVo.setParamsPaging(shopService.shopMenuSelectOneCount(shopVo));

		if(shopVo.getTotalRows() > 0) {
			model.addAttribute("shopMenuList", shopService.shopMenuSelectList(shopVo));
		}
		
		return "/xdm/v1/infra/shop/shopMenuXdmList";
	}
	
	// 등록 - selectForm
	@RequestMapping(value="/xdm/v1/infra/shop/shopMenuXdmForm")
	public String shopMenuXdmForm(Model model) {
		// 코드그룹 정보를 불러와야함
		List<ShopDto> codeGroups = shopService.selectListShop();
		// 불러온 코드그룹 정보를 codeXdmForm에 전달해주어야함
		model.addAttribute("listShop", shopService.selectListShop());
		return "/xdm/v1/infra/shop/shopMenuXdmForm";
	}
		
	// 등록 - selectInst
	@RequestMapping(value="/xdm/v1/infra/shop/shopMenuXdmInst")
	public String ShopMenuXdmInst(ShopDto shopDto) throws Exception {
		System.out.println("/// shopMenuInst 실행 ///");
		shopService.shopMenuInsert(shopDto);
		return "redirect:/xdm/v1/infra/shop/shopMenuXdmList";
	}
	
//	// 수정 - selectOne(Mfom)
//	@RequestMapping(value="/xdm/v1/infra/shop/shopMenuXdmMfom")
//	public String shopMenuXdmMfom(ShopDto shopDto, Model model) {
//		model.addAttribute("shopMenuItem", shopService.shopMenuSelectOne(shopDto));
//		System.out.println("/// shopMenuMfom-MenuSelectOne 실행 ///");
//		return "/xdm/v1/infra/shop/shopXdmMfom";
//	}
//		
//	// 수정 - update
//	@RequestMapping(value="/xdm/v1/infra/shop/shopMenuXdmUpdt")
//	public String shopMenuXdmUpdt(ShopDto shopDto) {
//		shopService.shopMenuUpdate(shopDto);
//		System.out.println("/// shopMenuMfom - MenuUpdate 실행 ///");
//		return "redirect:/xdm/v1/infra/shop/shopMenuXdmList";
//	}
//	S
//	// 삭제 - uelete
//	@RequestMapping(value="/xdm/v1/infra/shop/shopMenuXdmUel")
//	public String shopMenuXdmUel(ShopDto shopDto) {
//		shopService.shopMenuUelete(shopDto);
//		return "redirect:/xdm/v1/infra/shop/shopMenuXdmList";
//	}
//		
//	// 삭제 - delete
//	@RequestMapping(value="/xdm/v1/infra/shop/shopMenuXdmDel")
//	public String shopMenuXdmDel(ShopDto shopDto) {
//		shopService.shopMenuDelete(shopDto);
//		return "redirect:/xdm/v1/infra/shop/shopMenuXdmList";
//	}	

	
	
	
	
//=================== USR - SHOP ===================//
	
	// ShopList
	@RequestMapping(value="/usr/v1/infra/shop/userShopList")
	public String userShopList(@ModelAttribute("vo") ShopVo shopVo, ShopDto shopDto, Model model) {

		// 페이징 - selectOneCount
		shopVo.setParamsPaging(shopService.shopSelectOneCount(shopVo));
		if(shopVo.getTotalRows() > 0) {
			model.addAttribute("shopList", shopService.shopSelectList(shopVo));
		}
		
		return "/usr/v1/infra/shop/userShopList";
	}
	
	// ShopDetail(Mfom-selectOne)
	@RequestMapping(value="/usr/v1/infra/shop/userShopDetail")
	public String userShopDetail(ShopDto shopDto, Model model) {
		model.addAttribute("shopItem", shopService.shopSelectOne(shopDto));
		model.addAttribute("reviewList", shopService.shopReviewSelectList(shopDto));
		model.addAttribute("averageStarItem", shopService.getAverageStar(shopDto));
		return "/usr/v1/infra/shop/userShopDetail";
	}
	
	
	
	
	
	
	
}
