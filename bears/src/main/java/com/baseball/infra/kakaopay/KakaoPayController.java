package com.baseball.infra.kakaopay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KakaoPayController {
	
//private final KakaoPayService kakaoPayService;
	@Autowired
    private KakaoPayService kakaoPayService;
	
    
	@PostMapping("/order/pay/ready")
    public @ResponseBody KakaoPayReadyDto payReady(@RequestBody OrderCreateFormDto orderCreateForm) {
        
        String name = orderCreateForm.getName();
        int totalPrice = orderCreateForm.getTotalPrice();
        
        System.out.println("주문 상품 이름: " + name);
        System.out.println("주문 금액: " + totalPrice);

        // 카카오 결제 준비하기
        KakaoPayReadyDto kakaoPayReadyDto = kakaoPayService.payReady(name, totalPrice);
        // 세션에 결제 고유번호(tid) 저장
        SessionUtils.addAttribute("tid", kakaoPayReadyDto.getTid());
        System.out.println("결제 고유번호: " + kakaoPayReadyDto.getTid());

        return kakaoPayReadyDto;
    }

    @GetMapping("/order/pay/completed")
    public String payCompleted(@RequestParam("pg_token") String pgToken) {
    
        String tid = SessionUtils.getStringAttributeValue("tid");
        System.out.println("결제승인 요청을 인증하는 토큰: " + pgToken);
        System.out.println("결제 고유번호: " + tid);

        // 카카오 결제 요청하기
        KakaoPayDto approveResponse = kakaoPayService.payApprove(tid, pgToken);

        return "redirect:http://localhost:8080/order/completed";
    }

}
