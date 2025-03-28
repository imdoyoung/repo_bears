package com.baseball.infra.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baseball.common.util.UtilDateTime;

import jakarta.servlet.http.HttpSession;

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
		
		return "xdm/v1/infra/shop/shopXdmList";
	}
	
	// 등록 - selectForm
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmForm")
	public String shopXdmForm() {
		return "xdm/v1/infra/shop/shopXdmForm";
	}
	
	// 등록 - selectInst
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmInst")
	public String ShopXdmInst(ShopDto shopDto) throws Exception {
		System.out.println("/// shopInst 실행 ///");
		shopService.shopInsert(shopDto, 0);
		shopService.insertUploaded(shopDto);
		return "redirect:/xdm/v1/infra/shop/shopXdmList";
	}
	
	// 수정 - selectOne(Mfom)
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmMfom")
	public String shopXdmMfom(ShopDto shopDto, Model model) {
		model.addAttribute("shopItem", shopService.shopSelectOne(shopDto));
		model.addAttribute("reviewList", shopService.shopReviewSelectList(shopDto));
		System.out.println("/// shopMfom-selectOne 실행 ///");
		return "xdm/v1/infra/shop/shopXdmMfom";
	}
	
	// 수정 - update
	@RequestMapping(value="/xdm/v1/infra/shop/shopXdmUpdt")
	public String shopXdmUpdt(ShopDto shopDto) throws Exception {
		shopService.shopUpdate(shopDto, 0);
		shopService.insertUploaded(shopDto);
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
		
		return "xdm/v1/infra/shop/shopMenuXdmList";
	}
	
	// 등록 - selectForm
	@RequestMapping(value="/xdm/v1/infra/shop/shopMenuXdmForm")
	public String shopMenuXdmForm(Model model) {
		// 코드그룹 정보를 불러와야함
		List<ShopDto> codeGroups = shopService.selectListShop();
		// 불러온 코드그룹 정보를 codeXdmForm에 전달해주어야함
		model.addAttribute("listShop", shopService.selectListShop());
		return "xdm/v1/infra/shop/shopMenuXdmForm";
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
//	
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
		
		return "usr/v1/infra/shop/userShopList";
	}
	
	// ShopDetail(Mfom-selectOne)
	@RequestMapping(value="/usr/v1/infra/shop/userShopDetail")
	public String userShopDetail(@RequestParam("nsSeq") String nsSeq, ShopDto shopDto, ShopVo shopVo, Model model) {
		
		model.addAttribute("shopItem", shopService.shopSelectOne(shopDto));
		model.addAttribute("reviewList", shopService.shopReviewSelectList(shopDto));
		model.addAttribute("averageStarItem", shopService.getAverageStar(shopDto));
		model.addAttribute("shopMenuList", shopService.menuSelectList(shopDto));
		
		return "usr/v1/infra/shop/userShopDetail";
	}
	
	// ShopDetail에서 review insert
	@ResponseBody
	@RequestMapping(value = "/usr/v1/infra/shop/userShopDetailReviewInst", method = RequestMethod.POST)
	public Map<String, Object> userShopDetailReviewInst(@RequestParam("nsSeq") String nsSeq, ShopDto shopDto, HttpSession httpSession) {
	    Map<String, Object> response = new HashMap<>();
	    System.out.println("리뷰 response 돌았다~");

	    // 세션 값 가져오기
	    String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
	    String sessIdXdm = (String) httpSession.getAttribute("sessIdXdm");
	    
	    // ShopDto에 값 설정
	    // ShopDto에 sessSeqXdm값으로 B_user_usrSeq 설정
	    shopDto.setB_user_usrSeq(sessSeqXdm);
	    // url에서 nsSeq를 파라미터로 받아 ShopDto에 nsSeq값으로 B_shop_nsSeq 설정
	    shopDto.setB_shop_nsSeq(nsSeq);
	    // ShopDto에 sessIdXdm값으로 reId, usrId 설정
	    shopDto.setUsrId(sessIdXdm);
	    shopDto.setReId(sessIdXdm);

	    System.out.println("nsSeq : " + shopDto.getB_shop_nsSeq());
	    System.out.println("shopDto : " + shopDto.toString());

	    // 리뷰 삽입
	    int result = shopService.reviewInsert(shopDto);
	    
	    if (result > 0) {
	        response.put("rt", "success");
	        response.put("success", true);
	        response.put("reId", shopDto.getReId());		// sessIdXdm 값이 이곳에 저장됨
	        response.put("usrId", shopDto.getUsrId());		// 명확한 확인을 위해 추가
	        response.put("reStar", shopDto.getReStar());	
	        response.put("reTitle", shopDto.getReTitle());
	        response.put("reContent", shopDto.getReContent());
	    } else {
	        response.put("rt", "fail");
	        response.put("message", "리뷰 삽입에 실패했습니다.");
	    }

	    return response;
	}

	
	
	
//	@ResponseBody// JSON 응답을 반환하도록 설정
//	@RequestMapping(value = "/usr/v1/infra/shop/userShopDetailReviewInst", method = RequestMethod.POST)
//	public Map<String, Object> userShopDetailReviewInst(@RequestParam("nsSeq") String nsSeq, ShopDto shopDto, Model model, HttpSession httpSession) {
//		
//		Map<String, Object> response = new HashMap<>();
//
//		System.out.println("리뷰 response 돌았다~");
//		
//	    // 세션에서 필요한 값 가져오기
//	    String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
//	    String sessIdXdm = (String) httpSession.getAttribute("sessIdXdm");
//
//	    // ShopDto에 값 설정
//	    // ShopDto에 sessSeqXdm값으로 B_user_usrSeq 설정
//	    shopDto.setB_user_usrSeq(sessSeqXdm);
//	    // url에서 nsSeq를 파라미터로 받아 ShopDto에 nsSeq값으로 B_shop_nsSeq 설정
//	    shopDto.setB_shop_nsSeq(nsSeq);
//	    // ShopDto에 sessIdXdm값으로 ReId 설정
//	    shopDto.setReId(sessIdXdm);
//	    
//	    System.out.println("nsSeq : " + shopDto.getB_shop_nsSeq());
//	    
//	    if(nsSeq != null) {
//	    	// 리뷰 삽입
//	    	shopService.reviewInsert(shopDto);
//	    	
//	    	response.put("rt", "success");
//	    	
//	    	// 삽입된 리뷰 데이터 반환 (필요한 데이터만 반환)
//	    	response.put("success", true); // 리뷰 저장 성공
//	    	response.put("reId", shopDto.getReId());
//	    	response.put("reStar", shopDto.getReStar());
//	    	response.put("reTitle", shopDto.getReTitle());
//	    	response.put("reContent", shopDto.getReContent());
//	    } else {
//	    	response.put("rt", "fail");
//	    }
//	    
//
//	    return response;
//	}

	
//	@RequestMapping(value="/usr/v1/infra/shop/userShopDetailReviewInst")
//	public String userShopDetailReviewInst(@RequestParam("nsSeq") String nsSeq, ShopDto shopDto, Model model, HttpSession httpSession) {
//
//		// 세션에서 sessSeqXdm 값 가져오기
//		String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
//		String sessIdXdm = (String) httpSession.getAttribute("sessIdXdm");
//		
//		// ShopDto에 sessSeqXdm값으로 B_user_usrSeq 설정
//	    shopDto.setB_user_usrSeq(sessSeqXdm);
//	    
//	    // url에서 nsSeq를 파라미터로 받아 ShopDto에 nsSeq값으로 B_shop_nsSeq 설정
//	    shopDto.setB_shop_nsSeq(nsSeq);
//	    
//	    // ShopDto에 sessIdXdm값으로 ReId 설정
//	    shopDto.setReId(sessIdXdm);
//	    
//		// review insert
//		shopService.reviewInsert(shopDto);
//		
//		return "redirect:/usr/v1/infra/shop/userShopDetail?nsSeq=" + shopDto.getB_shop_nsSeq();
//	}
	
	// ===== booking ===== //
	// 예약 등록 - shopBookingInsert
	// step1
//	@RequestMapping(value = "/usr/v1/infra/shop/shopBookingInsert")
//	public String shopBookingInsert(ShopDto shopDto) {
//		shopService.shopBookingInsert(shopDto);
//		shopService.shopBookingMenuInsert(shopDto);
//		return "/usr/v1/infra/shop/userShopPayment";
//	}
	
	// step2
	// shopBookingInsert의 B_user_usrSeq에 sessSeqXdm 값 저장하기
//	@RequestMapping(value = "/usr/v1/infra/shop/shopBookingInsert")
//	public String shopBookingInsert(ShopDto shopDto, HttpSession httpSession) {
//		
//	    // 세션에서 sessSeqXdm 값 가져오기
//	    String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
//
//	    if (sessSeqXdm != null) {
//	        // B_user_usrSeq로 사용되는 값 설정
//	        shopDto.setB_user_usrSeq(sessSeqXdm);
//	        
//	        // 실제 shopBookingInsert와 관련된 서비스 호출
//	        shopService.shopBookingInsert(shopDto);
//	        shopService.shopBookingMenuInsert(shopDto);
//	    } else {
//	        // 세션에 사용자 정보가 없으면 처리
//	        return "redirect:/login"; // 로그인 페이지로 리디렉션
//	    }
//
//	    return "/usr/v1/infra/shop/userShopPayment";
//	}

	
	// step3
	// shopBookingInsert에 html에서 계산 된 boTotalPrice 값 바인딩
//	@RequestMapping(value = "/usr/v1/infra/shop/shopBookingInsert")
//	public String shopBookingInsert(ShopDto shopDto, HttpSession httpSession) {
//		
//		// 세션에서 sessSeqXdm 값 가져오기
//		String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
//		
//		if (sessSeqXdm != null) {
//			// B_user_usrSeq로 사용되는 값 설정
//			shopDto.setB_user_usrSeq(sessSeqXdm);
//			
//			// boTotalPrice 값 설정 (자동으로 폼에서 전달된 값이 ShopDto로 바인딩됨)
//	        System.out.println("총 금액: " + shopDto.getBoTotalPrice()); // 확인용 출력
//			
//			// 실제 shopBookingInsert와 관련된 서비스 호출
//			shopService.shopBookingInsert(shopDto);
//			shopService.shopBookingMenuInsert(shopDto);
//		} else {
//			// 세션에 사용자 정보가 없으면 처리
//			return "redirect:/login"; // 로그인 페이지로 리디렉션
//		}
//		
//		return "/usr/v1/infra/shop/userShopPayment";
//	}
	
	// step 4
	// shopBookingMenuInsert의 b_menu_meSeq에 meSeq 값 저장하기
	@RequestMapping(value = "/usr/v1/infra/shop/shopBookingInsert")
	public String shopBookingInsert(ShopDto shopDto,@RequestParam("menuSeqs") List<String> menuSeqs, HttpSession httpSession) {
		
		// 세션에서 sessSeqXdm 값 가져오기
		String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");
		
		if (sessSeqXdm != null) {
			// B_user_usrSeq로 사용되는 값 설정
			shopDto.setB_user_usrSeq(sessSeqXdm);
			
			// menuSeqs 값을 shopDto에 설정
			shopDto.setMenuSeqs(menuSeqs);	// shopDto에 menuSeqs 필드 추가
			
			// boTotalPrice 값 설정 (자동으로 폼에서 전달된 값이 ShopDto로 바인딩됨)
			System.out.println("총 금액: " + shopDto.getBoTotalPrice()); // 확인용 출력
			
			// 실제 shopBookingInsert와 관련된 서비스 호출
			// 실행 후 shopDto.boSeq에 boSeq 값이 저장됨
			shopService.shopBookingInsert(shopDto);		
			shopService.shopBookingMenuInsert(shopDto);
			
			// boSeq 값을 userShopPayment로 리다이렉션 전달
			 return "redirect:/usr/v1/infra/shop/userShopPayment?boSeq=" + shopDto.getBoSeq();
		} else {
			// 세션에 사용자 정보가 없으면 처리
			// 로그인 페이지로 리디렉션
			return "redirect:/usr/v1/infra/user/userShopSignin"; 
		}
//		return "/usr/v1/infra/shop/userShopPayment";
	}

	// ShopPayment
	@RequestMapping(value="/usr/v1/infra/shop/userShopPayment")
	public String userShopPayment(ShopDto shopDto, @RequestParam("boSeq") String boSeq, Model model) {

		// 결제 페이지에 예약 정보 출력(shopPaymentSelectOne 호출)
		model.addAttribute("bookingItem", shopService.paymentBookingSelectOne(shopDto));
		model.addAttribute("bookingMenuList", shopService.paymentBookingMenuSelectList(shopDto));
		model.addAttribute("shopItem", shopService.paymentShopSelectOne(shopDto));
		
		return "usr/v1/infra/shop/userShopPayment";
	}
	
	// ShopPaymentUpt(결제수단, 결제일 업데이트)
	@RequestMapping(value="/usr/v1/infra/shop/userShopPaymentUpt")
	public String userShopPaymentUpt(ShopDto shopDto) {
		shopService.bookingUpdate(shopDto);
		return "usr/v1/infra/shop/userShopPaymentComplete";
	}
	// 결제완료 후 이동할 페이지
	@RequestMapping(value="/usr/v1/infra/shop/userShopPaymentComplete")
	public String userShopPaymentComplete() {
		return "usr/v1/infra/shop/userShopPaymentComplete";
	}
	
	// usr 예약내역 리스트 페이지 출력
	@RequestMapping(value="/usr/v1/infra/shop/userShopBookingList")
	public String userBookingSelectList(@ModelAttribute("vo") ShopVo shopVo, Model model, HttpSession httpSession) {
	    
	    // 세션에서 sessSeqXdm 값 가져오기
	    String sessSeqXdm = (String) httpSession.getAttribute("sessSeqXdm");

	    // ShopVo에 usrSeq 설정
	    shopVo.setUsrSeq(sessSeqXdm);

	    // 페이징 설정
	    shopVo.setParamsPaging(shopService.userBookingSelectOneCount(shopVo));

	    // 예약 내역 리스트 조회
	    if (shopVo.getTotalRows() > 0) {
	        model.addAttribute("userBookingList", shopService.userBookingSelectList(shopVo));
	    }

	    return "usr/v1/infra/shop/userShopBookingList";
	}
	
	// usr 예약내역 상세 페이지 출력
	@RequestMapping(value="/usr/v1/infra/shop/userShopBookingDetail")
	public String userShopBookingDetail(ShopDto shopDto, Model model) {
		model.addAttribute("bookingDetailItem", shopService.userBookingDetailSelectOne(shopDto));
		model.addAttribute("bookingShopDetailItem", shopService.shopBookingDetailSelectOne(shopDto));
		model.addAttribute("bookingMenuDetailList", shopService.menuBookingDetailSelectList(shopDto));
		System.out.println("userBookingDetailSelectOne 잘 넘어감");
		return "usr/v1/infra/shop/userShopBookingDetail";
	}

	
	 
}
